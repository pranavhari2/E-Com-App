/*
   Authors:
   Pranav K. Hari, 101144482
   Sahil Agrawal, 101132393
 */

public class Product {

    private final String name;
    private final double price;
    private final int id;


    public Product(String name, double price, int id){
        this.id = id;
        this.price = price;
        this.name = name;
    }


    public double getPrice() {
        return this.price;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
