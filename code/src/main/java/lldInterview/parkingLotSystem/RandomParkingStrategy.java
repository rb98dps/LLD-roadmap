package lldInterview.parkingLotSystem;

import java.util.List;

public class RandomParkingStrategy implements ParkingStrategy {


    @Override
    public ParkingSlot assign(ParkingRequest request) {

        List<ParkingSlot> slots = ParkingSlotManager.getLots().get(request.level);

        while(ParkingSlotManager.getEmptySlots(request.level)!=0){

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
