package MachineCoding.ParkingLot.controllers;

import MachineCoding.ParkingLot.dtos.GenerateTicketRequestDto;
import MachineCoding.ParkingLot.dtos.GenerateTicketResponseDto;
import MachineCoding.ParkingLot.dtos.ResponseStatus;
import MachineCoding.ParkingLot.exceptions.InvalidGateException;
import MachineCoding.ParkingLot.exceptions.NoAvailableSpotException;
import MachineCoding.ParkingLot.models.Ticket;
import MachineCoding.ParkingLot.models.VehicleType;
import MachineCoding.ParkingLot.services.TicketService;


public class TicketController {

    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }


    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto dto) throws InvalidGateException, NoAvailableSpotException {
        String vehicleNumber = dto.getVehicleNumber();
        VehicleType vehicleType = dto.getVehicleType();
        Long gateId = dto.getGateId();

        Ticket ticket = ticketService.generateTicket(
                gateId ,vehicleNumber , vehicleType
        );

        // USE BUILDER PATTERN IF THERE IS A LOT OF PARAMETER
        GenerateTicketResponseDto response = new GenerateTicketResponseDto();
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setTicketId(ticket.getId());
        response.setOperator(ticket.getOperator().getName());
        response.setSpotNumber(ticket.getParkingSpot().getNumber());

        return response;
    }
}
