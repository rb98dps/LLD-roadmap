package lldInterview.parkingLotSystem;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSlot {
    AtomicBoolean assigned;
    boolean available;
    int level;
    Location location;
    Vehicle vehicle;
    UUID uuid;

    public boolean assign(){

        if(available){
            return assigned.compareAndSet(false, true);
        }
        return false;

    }

    public void park(){
        available = false;
        assigned.compareAndSet(true, false);
    }

    public Location getCoordinates(){
        return location;
    }

    public boolean isAvailable() {
        return available && !assigned;
    }
}
