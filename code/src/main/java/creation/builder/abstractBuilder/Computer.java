package creation.builder.abstractBuilder;

public class Computer {

    String cpu;
    String ram;
    String rom;

    @Override
    public String toString() {
        return "Computer{" +
                       "cpu='" + cpu + '\'' +
                       ", ram='" + ram + '\'' +
                       ", rom='" + rom + '\'' +
                       '}';
    }

    public Computer() {
    }

    public Computer(String cpu, String ram, String rom) {
        this.cpu = cpu;
        this.ram = ram;
        this.rom = rom;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }
}
