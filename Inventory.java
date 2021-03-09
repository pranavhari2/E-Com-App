/**
 @author Pranav K. Hari, 101144482
 @author Sahil Agrawal, 101132393
 */

import apple.laf.AquaLookAndFeel;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products = new ArrayList<>();   // ArrayList of Products
    private ArrayList<Integer> stock = new ArrayList<>();    // Array of Stocks

    /**
     * Default Constructor initialized with some values
     */
    public Inventory () {

       Product product1 = new Product("Apple",5.00,0);
       Product product2 = new Product("Chocolate",2.00,1) ;
       Product product3 = new Product("Cheerios",8.00,2) ;

       products.add(0,product1);
       products.add(1,product2);
       products.add(2,product3);

       this.stock.add(0,1);
       this.stock.add(1,2);
       this.stock.add(2,3);
    }

    /**

     * @param product Product to be added to products arrayList.
     */

    public void addProduct (Product product) {
        products.add(product);
    }


    /**
     * Retrives the product given the product ID.
     *
     * @param id Product id to be checked
     * @return Product Product with the same ID.
     */

    public Product getProduct (int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == id) {
                return products.get(i);
            }
        }
        return null;
    }

    /**
     * Retrives the products in the inventory
     *
     * @return ArrayList Products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Retrieves the stock for a product given a product ID
     *
     * @param id Product id to check for
     * @return int Returns stock of specified item id
     */

    public int getStock (int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == id) {
                return stock.get(i);
            }
        }
        return 0;
    }

    /**
     * Increases a products stock given the product and the amount of stock to be added.
     *
     * @param product Product to add
     * @param stock  Amount of product to add
     */

    public void addStock (Product product, int stock) {
        for (int i = 0; i <= products.size(); i++) {
            if (products.get(i).equals(product)) {
                this.stock.set(i,this.stock.get(i)+1);
            }
        }
        products.add(product);
        this.stock.add(stock);
    }

    /**
     * Decreases a products stock given the product and the amount of stock to be added.
     * Sets a product's stock to default if stock is below 0.
     *
     * @param product Product to add
     * @param stock  Amount of product to remove
     */

    public void removeStock (Product product, int stock) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(product)) {
                if (this.stock.get(i) - stock < 0){
                    this.stock.set(i,0);
                }
                else{
                    this.stock.set(i,this.stock.get(i)-stock);
                }
            }
        }
    }

    /**
     * Prints the current inventory of the store
     */
    public void printInventory(){
        System.out.print("Product Name | Unit Price | Stock\n");
        for (int i =0; i<products.size(); i++){
            System.out.print(products.get(i).getName() + " | " + "$"+products.get(i).getPrice() + " | " + stock.get(i)+"\n");
        }
    }
}

