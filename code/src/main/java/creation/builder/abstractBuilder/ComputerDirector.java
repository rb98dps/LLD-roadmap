package creation.builder.abstractBuilder;

public class ComputerDirector {

    Computer create(ComputerBuilder computerBuilder){
        return computerBuilder.buildCPU().buildRAM().buildROM().build();
    }
}
