package MachineCoding.ParkingLot.repositories;

import MachineCoding.ParkingLot.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Long,Ticket> tickets = new TreeMap<>();
    private Long lastSaveId = 0L;
    public Ticket save(Ticket ticket){
        ticket.setId(lastSaveId + 1);
        lastSaveId +=  1;
        tickets.put(lastSaveId , ticket);
        return ticket;
    }
}
