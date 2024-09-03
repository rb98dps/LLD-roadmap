package lldInterview.parkingLotSystem;

public class ExitRequest {
    boolean canExit;
    double fees;

    String reason;

    public ExitRequest(boolean canExit, double fees, String reason) {
        this.canExit = canExit;
        this.fees = fees;
        this.reason = reason;
    }

    public boolean isCanExit() {
        return canExit;
    }

    public void setCanExit(boolean canExit) {
        this.canExit = canExit;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
