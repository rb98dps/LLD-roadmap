package creation.builder.facetBuilder;

public class Product1 {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Product1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private Product1(){

    }
    public static Product1Builder getBuilder(){
        return new Product1Builder();
    }

    public static class Product1Builder{
        private int id;
        private String name;

        public Product1Builder id(int id) {
            this.id = id;
            return this;
        }

        public Product1Builder name(String name) {
            this.name = name;
            return this;
        }

        public Product1 build(){
            return new Product1(id,name);
        }
    }
}
