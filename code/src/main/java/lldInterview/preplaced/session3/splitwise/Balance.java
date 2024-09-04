package lldInterview.preplaced.session3.splitwise;

class Balance {
    private int id;
    private double bal;

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
