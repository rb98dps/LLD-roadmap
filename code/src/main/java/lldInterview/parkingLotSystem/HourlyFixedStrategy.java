package lldInterview.parkingLotSystem;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HourlyFixedStrategy implements FeeStrategy{

    double hourRate;
    @Override
    public double calculate(Ticket ticket) {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = ticket.getDateTime();
        long hours = ChronoUnit.HOURS.between(startTime, endTime);

        return hours * hourRate;
    }
}
