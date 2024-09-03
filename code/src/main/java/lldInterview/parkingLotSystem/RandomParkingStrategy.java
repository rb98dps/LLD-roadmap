package lldInterview.parkingLotSystem;

import java.util.List;

public class RandomParkingStrategy implements ParkingStrategy {

    ParkingSlotManager parkingSlotManager = ParkingSlotManager.getParkingSlotManager();

    @Override
    public ParkingSlot assign(ParkingRequest request) {

        List<ParkingSlot> slots = parkingSlotManager.getLots().get(request.level);

        while(parkingSlotManager.getEmptySlots(request.level)!=0){

           for( ParkingSlot slot: slots){

               boolean assign = slot.assign();
               if(assign){
                   return slot;
               }
           }
        }
        return null;
    }
}
