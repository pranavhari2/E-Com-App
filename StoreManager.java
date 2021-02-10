public class StoreManager {

    private Inventory myInventory = new Inventory();

    /**
     *
     * @param product Product to be checked
     * @return Returns the stock of a given product.
     */

    public int checkStock(Product product){
        return myInventory.getStock(product.getID());
    }

    /**
     *
     * @param userCart Array of Product information  (eg: “[[productID1, quantity], [productID2, quantity], [productID3, quantity]])”
     * @return Returns the total price of all the items in a user's shopping cart. Returns -1 if stock is 0 for any product.
     *
     */

    public int processTransaction(int[][] userCart) {
        int total = 0;

        for (int[] stock : userCart) {   // Check if desired quantity is available for all products
            if (myInventory.getStock(stock[0]) - stock[1] < 0) {
                return -1;
            }
        }

        for (int[] stock : userCart) {
            total += myInventory.getProduct(stock[0]).getPrice() * stock[1];
            myInventory.removeStock(myInventory.getProduct(stock[0]), stock[1]);
        }

        return total;
    }

}
