package creation.builder.abstractBuilder;

public class DellComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public DellComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public Computer build() {
        return computer;
    }

    @Override
    public ComputerBuilder buildRAM() {
        computer.setRam("16GB");
        return this;
    }

    @Override
    public ComputerBuilder buildCPU() {
        computer.setCpu("I9");
        return this;
    }

    @Override
    public ComputerBuilder buildROM() {
        computer.setRom("512Gb");
        return this;
    }
}
