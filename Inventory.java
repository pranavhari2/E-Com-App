import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products = new ArrayList<>();   // ArrayList of Products
    private int[] stock = new int[100];    // Array of Stocks

    public Inventory () {

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
        for (int i = 0; i <= products.size(); i++) {
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

    public int getStock (int id) {
        for (int i = 0; i <= products.size(); i++) {
            if (products.get(i).getID() == id) {
                return stock[i];
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
                this.stock[i] += stock;
            }
        }
        products.add(product);
        this.stock[products.size()-1] = stock;
    }

    /**
     * Decreases a products stock given the product and the amount of stock to be added.
     * Sets a product's stock to default if stock is below 0.
     *
     * @param product Product to add
     * @param stock  Amount of product to remove
     */

    public void removeStock (Product product, int stock) {
        for (int i = 0; i <= products.size(); i++) {
            if (products.get(i).equals(product)) {
                if (this.stock[i] - stock < 0){
                    this.stock[i] = 0;
                }
                else{
                    this.stock[i] -= stock;
                }
            }
        }
    }
}

