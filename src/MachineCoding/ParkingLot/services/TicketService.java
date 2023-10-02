package MachineCoding.ParkingLot.services;

import MachineCoding.ParkingLot.exceptions.InvalidGateException;
import MachineCoding.ParkingLot.exceptions.NoAvailableSpotException;
import MachineCoding.ParkingLot.models.*;
import MachineCoding.ParkingLot.repositories.*;
import MachineCoding.ParkingLot.strategies.spotAssigmentStrategy.SpotAssigmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private IGateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SpotAssigmentStrategy spotAssigmentStrategy;
    private TicketRepository ticketRepository;
    private IParkingLotRepository parkingLotRepository;
    public TicketService(
            IGateRepository gateRepository,
            VehicleRepository vehicleRepository,
            SpotAssigmentStrategy spotAssigmentStrategy,
            TicketRepository TicketRepository,
            IParkingLotRepository parkingLotRepository
    ){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssigmentStrategy = spotAssigmentStrategy;
        this.ticketRepository = TicketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket generateTicket(
            Long gateId , String vehicleNumber, VehicleType vehicleType
    ) throws InvalidGateException, NoAvailableSpotException {
        /*
            Gate = Object (Get through gate id from db) else throw exception
            Operator = from gate object
            Vehicle = Object (Check in db if yes get that else create that)
            Parking Spot = Strategy
            Ticket = Object
         */

        //Gate
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new InvalidGateException();
        }
        Gate gate = gateOptional.get();

        //Operator
        Operator operator = gate.getCurrentOperator();

        //Vehicle
        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle vehicle;
        if(optionalVehicle.isEmpty()){
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle = vehicleRepository.save(vehicle);
        }else {
            vehicle = optionalVehicle.get();
        }

        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotOfGate(gate);

        Optional<ParkingSpot> parkingSpotOptional = spotAssigmentStrategy.findSpot(
                vehicleType , parkingLotOptional.get(), gate
        );

        if(parkingSpotOptional.isEmpty()){
            throw new NoAvailableSpotException();
        }

        ParkingSpot parkingSpot = parkingSpotOptional.get();

        Ticket ticket = new Ticket();
        ticket.setParkingSpot(parkingSpot);
        ticket.setGate(gate);
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);
        ticket.setOperator(operator);
        return ticketRepository.save(ticket);
    }
}
