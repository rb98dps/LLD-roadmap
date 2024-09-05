package lldInterview.preplaced.session3.splitwise;

public class Transaction {

    private int senderId;
    private double balance;
    private int receiverId;

    public Transaction(int senderId, double balance, int receiverId) {
        this.senderId = senderId;
        this.balance = balance;
        this.receiverId = receiverId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public String toString() {

        if (balance > 0) {
            return senderId + ", owes = " + balance + ", to " + receiverId;
        } else if (balance < 0) {
            return senderId + " will receive = " + -balance + " from " + receiverId;
        }
        return senderId + " settled with " + receiverId;
    }
}
