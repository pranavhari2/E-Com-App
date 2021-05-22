
import java.util.ArrayList;

/**
 @author Pranav K. Hari, 101144482
 @author Sahil Agrawal, 101132393
 */

 /* Editing to test git commit*/


public class ShoppingCart {

    private ArrayList<Product> products = new ArrayList<>();   // ArrayList of Products
    private ArrayList<Integer> quantity = new ArrayList<>();    // Array of Quantity

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
     * Retrieves the stock for a product given a product ID
     *
     * @param id Product id to check for
     * @return int Returns stock of specified item id
     */

    public int getQuantity (int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == id) {
                return quantity.get(i);
            }
        }
        return 0;
    }

    /**
     * Return the List of Products in the shopping cart
     *
     * @return products, ArrayList<String>
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Return the List of quantites/stock of each product in the shopping cart
     *
     * @return quantity, ArrayList<Integer>
     */
    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    /**
     * Increases a products stock given the product and the amount of stock to be added.
     *
     * @param product Product to add
     * @param stock  Amount of product to add
     */

    public void addToCart (Product product, int stock) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(product)) {
                this.quantity.set(i,this.quantity.get(i)+stock);    // Increases quantity if duplicate
            }
        }
        products.add(product);
        quantity.add(stock);
    }

    /**
     * Decreases a products stock given the product and the amount of stock to be added.
     * Sets a product's stock to default if stock is below 0.
     *
     * @param product Product to add
     * @param stock  Amount of product to remove
     */

    public void removeFromCart (Product product, int stock) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(product)) {
                if (this.quantity.get(i) - stock < 0){
                    this.quantity.set(i,0);
                }
                else{
                    this.quantity.set(i, this.quantity.get(i)-stock);
                }
            }
        }
    }

    /**
     * Prints the user's cart
     */
    public void printCart(){
        System.out.print("Your Cart ---> \n");
        System.out.print("Product Name | Unit Price | Amount\n");
        for (int i =0; i<products.size(); i++){
            System.out.print(products.get(i).getName() + " | " + products.get(i).getPrice() + " | " + quantity.get(i)+"\n");
        }
    }
}

