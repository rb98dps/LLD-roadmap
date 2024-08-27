package creation.builder.facetBuilder;

public class Main {

    public static void main(String[] args) {

        //this is a good approach, but fails to do the job exactly as
        //Product.ProductBuilder is possible and others can get a instance of ProductBuilder without creating a
        // instance of new Product.
        // for every product creation we are creating a product builder as well that can not be

        Product product = Product.getBuilder().id(1).name("Rahul").build();
        Product product1 = Product.getBuilder().id(2).name("Rahul").build();
        System.out.println(product);
        System.out.println(product1);


        Product1 product11 = Product1.getBuilder().id(1).name("Rahul").build();
        Product1 product12 = Product1.getBuilder().id(2).name("Rahul").build();
        System.out.println(product11);
        System.out.println(product12);
    }
}
