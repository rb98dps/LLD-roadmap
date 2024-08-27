package creation.builder.abstractBuilder;

public class Main {

    public static void main(String[] args) {
        DellComputerBuilder dellComputerBuilder = new DellComputerBuilder();
        HpComputerBuilder hpComputerBuilder = new HpComputerBuilder();
        ComputerDirector computerDirector = new ComputerDirector();
        System.out.println( computerDirector.create(dellComputerBuilder));
        System.out.println( computerDirector.create(hpComputerBuilder));
    }
}
