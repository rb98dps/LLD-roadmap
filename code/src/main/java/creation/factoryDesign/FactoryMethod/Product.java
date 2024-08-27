package creation.factoryDesign.FactoryMethod;

public interface Product {
    String details();
}

class Product1 implements Product{

    @Override
    public String details() {
        return "Prod 1";
    }
}

class Product2 implements Product{

    @Override
    public String details() {
        return "Prod 2";
    }
}