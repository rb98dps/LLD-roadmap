package creation.builder.abstractBuilder;

 interface ComputerBuilder {
     Computer build();
     ComputerBuilder buildRAM();
     ComputerBuilder buildCPU();
     ComputerBuilder buildROM();
}
