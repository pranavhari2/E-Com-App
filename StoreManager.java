
import sun.nio.cs.ext.SJIS;

import java.util.ArrayList;


/**
 @author Pranav K. Hari, 101144482
 @author  Sahil Agrawal, 101132393
 */


public class StoreManager {

    private Inventory myInventory = new Inventory();
    private ArrayList<ShoppingCart> userCarts = new ArrayList<>();
    private static int cartId = -1;

    /**
     * Default Constructor;
     */
    public StoreManager(){};

    /**
     * Constructor 2
     *
     * @param inventory, Inventory
     */
    public StoreManager(Inventory inventory){
        this.myInventory = inventory;
    }

    /** Retrieves the inventory of the system
     *
     * @return myInventory, the inventory managed by the store manager
     */
    public Inventory getMyInventory() {
        return myInventory;
    }

    public int newShoppingCart() {
        userCarts.add(new ShoppingCart());
        return userCarts.size() - 1;           //Index of new shopping cart
    }

    /**
     * Gets the user's shopping cart
     * @param id, int
     * @return userCarts.get(id), ShoppingCart
     */
    public ShoppingCart getUserCart(int id){
        return userCarts.get(id);
    }

    /**
     * Assigns a new cart Id to a cart
     *
     * @return cartId, int
     */
    public int assignNewCartID(){
        cartId++;;
        return cartId;
    }

    /**
     *
     * @param product Product to be checked
     * @return Returns the stock of a given product.
     */
    public int checkStock(Product product){
        return myInventory.getStock(product.getID());
    }


    /**
     *adds the product to the cart and removes the amount of product added from the stock
     * @param productId, int
     * @param product, Product
     * @param amount, int
     * @param cartId, int
     */
    public boolean addToUserCart(int productId, Product product, int amount, int cartId){

        if (myInventory.getStock(productId) == -1 || myInventory.getStock(productId) - amount < 0){
            System.out.print("HERE");
            return false;
        }
        else{
            userCarts.get(cartId).addToCart(product,amount);
            myInventory.removeStock(product,amount);
            return true;
        }
    }

    /**
     * removes from the cart and adds the products back to the stock
     * @param productId, int
     * @param product, Product
     * @param amount, int
     * @param cartId, int
     */
    public boolean removeFromUserCart(int productId, Product product, int amount, int cartId) {
        if ( userCarts.get(cartId).getQuantity(productId) == -1 ||  userCarts.get(cartId).getQuantity(productId) - amount < 0){
            return false;
        }
        else{
            userCarts.get(cartId).removeFromCart(product,amount);
            myInventory.addStock(product,amount);
            return true;
        }
    }

    /**
     *returns the total cost of all the items in the cart
     * @param cartId
     * @return a float of the total price
     */

    public float processTransaction(int cartId) {
        int total = 0;

        // Summary of Products
        System.out.print("Your Cart --->  \n");
        System.out.print("Stock | Product Name | Unit Price\n");
        for (Product p: userCarts.get(cartId).getProducts()){
            System.out.print(userCarts.get(cartId).getQuantity(p.getID()) + " | " + p.getName()+ " | "+p.getPrice()+ "\n");
        }

        // Total Calculation
        System.out.print("Your Total ---> \n");
        for(int i=0; i < userCarts.size(); i++){
            Product p = userCarts.get(cartId).getProduct(i);
            total+=userCarts.get(cartId).getProducts().get(i).getPrice()*userCarts.get(cartId).getQuantity(i);
        }
        return total;
    }


}
