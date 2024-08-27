package creation.builder.facetBuilder;

public class Product {

    String name;
    Integer id;

    public String getName() {
        return name;
    }

    public Product(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    private Product() {
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                       "name='" + name + '\'' +
                       ", id=" + id +
                       '}';
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public static ProductBuilder getBuilder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        Product product;
        ProductBuilder() {
            initializeBuilder();
        }

        private void initializeBuilder() {
            product = new Product();
        }

        public ProductBuilder name(String name){
            product.setName(name);
            return this;
        }

        public ProductBuilder id(Integer id){
            product.setId(id);
            return this;
        }

        public Product build(){
            return this.product;
        }
    }
}
