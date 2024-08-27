package creation.factoryDesign.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Product1Factory();
        Product product = factory.createInstance();
        System.out.println(product.details());

        Factory factory1 = new Product2Factory();
        Product product2 = factory1.createInstance();
        System.out.println(product2.details());

    }
}
