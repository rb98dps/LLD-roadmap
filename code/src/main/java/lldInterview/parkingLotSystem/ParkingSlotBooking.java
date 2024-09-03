package lldInterview.parkingLotSystem;

import java.util.Optional;
import java.util.UUID;

public class ParkingSlotBooking {

    ParkingStrategy parkingStrategy;

    FeeStrategy feeStrategy;

    ParkingSlotManager parkingSlotManager = ParkingSlotManager.getParkingSlotManager();
    TicketManager ticketManager = TicketManager.getTicketManager();

    ParkingSlotBooking(ParkingStrategy parkingStrategy, FeeStrategy feeStrategy){
        this.feeStrategy = feeStrategy;
        this.parkingStrategy = parkingStrategy;
    }
    public Ticket park(ParkingRequest request){

        if(parkingSlotManager.getEmptySlots(request.level) != 0){
            ParkingSlot parkingSlot = parkingStrategy.assign(request);
            if(parkingSlot!=null){
                Ticket ticket = new Ticket(parkingSlot,request);
                ticketManager.add(ticket);
                return ticket;
            } else {

            }


        }
        return null;
    }

    public int availableSlots(int level){
        return parkingSlotManager.getEmptySlots(level);
    }

    public double fees(Ticket ticket){
        return feeStrategy.calculate(ticket);
    }

    public ExitRequest exit(UUID ticketId){
        Optional<Ticket> ticket = ticketManager.getTicket(ticketId);
        ExitRequest exitRequest = new ExitRequest(false,0,"Ticket not found");
        ticket.ifPresent(ticket1 -> {
            if(ticket1.isCompleted()){
                exitRequest.setReason("Ticket already completed");

            } else {
                exitRequest.setReason("success");
                exitRequest.setCanExit(true);
                exitRequest.setFees(fees(ticket1));
            }
       });
        return exitRequest;
    }

}
