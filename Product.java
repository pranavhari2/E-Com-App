public class Product {

    private final String name;
    private final double price;
    private final String id;


    public Product(String name, double price, String id){
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
