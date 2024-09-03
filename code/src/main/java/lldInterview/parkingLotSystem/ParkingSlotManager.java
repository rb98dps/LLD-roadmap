package lldInterview.parkingLotSystem;

import java.util.List;
import java.util.Map;

public class ParkingSlotManager {
    private final static ParkingSlotManager parkingSlotManager = new ParkingSlotManager();

    public static ParkingSlotManager getParkingSlotManager() {
        return parkingSlotManager;
    }

    private ParkingSlotManager(){

    }

    private Map<Integer, List<ParkingSlot>> lots;
    public void addParkingSlot(int level,ParkingSlot parkingSlot){
        lots.get(level).add(parkingSlot);
    }

    public  Integer getEmptySlots(int level){
        return Math.toIntExact(lots.get(level).stream().filter(parkingSlot -> !parkingSlot.assigned && parkingSlot.available).count());
    }

    public Map<Integer, List<ParkingSlot>> getLots() {
        return lots;
    }
}
