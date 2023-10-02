package MachineCoding.ParkingLot;

import MachineCoding.ParkingLot.controllers.TicketController;
import MachineCoding.ParkingLot.repositories.GateRepository;
import MachineCoding.ParkingLot.repositories.ParkingLotRepository;
import MachineCoding.ParkingLot.repositories.TicketRepository;
import MachineCoding.ParkingLot.repositories.VehicleRepository;
import MachineCoding.ParkingLot.services.TicketService;
import MachineCoding.ParkingLot.strategies.spotAssigmentStrategy.RandomSpotAssigmentStrategy;
import MachineCoding.ParkingLot.strategies.spotAssigmentStrategy.SpotAssigmentStrategy;

public class ParkingLotApplication {
    public static void main(String[] args){
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository  vehicleRepository = new VehicleRepository();

        SpotAssigmentStrategy spotAssigmentStrategy = new RandomSpotAssigmentStrategy();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                spotAssigmentStrategy,
                ticketRepository,
                parkingLotRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Application has started at port: 8080");


    }
}
