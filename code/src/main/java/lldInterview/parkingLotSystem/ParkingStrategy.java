package lldInterview.parkingLotSystem;

public interface ParkingStrategy {
    ParkingSlot assign(ParkingRequest request);
}
