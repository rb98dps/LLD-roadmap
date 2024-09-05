package lldInterview.preplaced.session3.splitwise;

public class Balance {
    private int id;
    private double bal;

    private double split;

    public double getSplit() {
        return split;
    }

    public void setSplit(double split) {
        this.split = split;
    }

    public Balance(int id, double bal, double split) {
        this.id = id;
        this.bal = bal;
        this.split = split;
    }

    public Balance(int id, double bal) {
        this.id = id;
        this.bal = bal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    @Override
    public String toString() {
        return "Balance{" +
                       "id=" + id +
                       ", bal=" + bal +
                       '}';
    }
}
