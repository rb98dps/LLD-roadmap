package lldInterview.parkingLotSystem;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class TicketManager {

    private static final TicketManager ticketManager = new TicketManager();
    private TicketManager(){

    }

    public static TicketManager getTicketManager(){
        return ticketManager;
    }
    Set<Ticket> tickets;

    public void add(Ticket ticket){
        tickets.add(ticket);

    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void complete(UUID id){
        tickets.stream().filter(ticket ->
            ticket.getUuid() == id
        ).forEach(ticket -> ticket.setCompleted(true));
    }

    public Optional<Ticket> getTicket(UUID uuid){
        return tickets.stream().filter(ticket -> ticket.getUuid() == uuid).findFirst();
    }

}
