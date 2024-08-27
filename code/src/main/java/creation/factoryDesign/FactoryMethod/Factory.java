package creation.factoryDesign.FactoryMethod;

public interface Factory {
    Product createInstance();
}

class Product1Factory implements Factory{

    @Override
    public Product createInstance() {
        return new Product1();
    }
}

class Product2Factory implements Factory{

    @Override
    public Product createInstance() {
        return new Product2();
    }
}
