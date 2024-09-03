package lldInterview.parkingLotSystem;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Ticket {

    private LocalDateTime dateTime;

    private UUID uuid;

    boolean completed = false;
    Vehicle vehicle;

    Location location;

    Ticket(ParkingSlot parkingSlot, ParkingRequest request){
        dateTime = LocalDateTime.now();
        uuid = UUID.randomUUID();
        vehicle = request.vehicle;
        location = parkingSlot.location;
        parkingId = parkingSlot.uuid;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setParkingId(UUID parkingId) {
        this.parkingId = parkingId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Location getLocation() {
        return location;
    }

    public UUID getParkingId() {
        return parkingId;
    }

    private UUID parkingId;
}
