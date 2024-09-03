package lldInterview.parkingLotSystem;

public class ParkingLot {

    public static void main(String[] args) {
        FeeStrategy feeStrategy = new HourlyFixedStrategy();
        ParkingStrategy parkingStrategy = new RandomParkingStrategy();

        ParkingSlotBooking parkingSlotBooking = new ParkingSlotBooking(parkingStrategy,feeStrategy);
        ParkingSlotManager parkingSlotManager = ParkingSlotManager.getParkingSlotManager();
        ParkingSlot parkingSlot = new ParkingSlot();

    }
}
