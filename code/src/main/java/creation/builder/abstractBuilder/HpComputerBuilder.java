package creation.builder.abstractBuilder;

public class HpComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public HpComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public Computer build() {
        return computer;
    }

    @Override
    public ComputerBuilder buildRAM() {
        computer.setRam("8GB");
        return this;
    }

    @Override
    public ComputerBuilder buildCPU() {
        computer.setCpu("I3");
        return this;
    }

    @Override
    public ComputerBuilder buildROM() {
        computer.setRom("256Gb");
        return this;
    }
}
