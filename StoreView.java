import java.util.Scanner;

/**
 @author Pranav K. Hari, 101144482
 @author Sahil Agrawal, 101132393
 */

public class StoreView {

    private StoreManager storeManager = new StoreManager();
    private int cartId;
    public static final String[] COMMANDS = {"browse", "viewCart", "add", "remove", "checkout", "help"};

    /** C
     * Constructor 1
     * @param storeManager, StoreManager
     * @param cartId, int
     */
    public StoreView(StoreManager storeManager, int cartId){
        this.storeManager = storeManager;
        this.cartId = cartId;
        this.storeManager.newShoppingCart();
    }

    /** Displays the specified menu for a user's selection
     *
     * @return true or false, boolean
     */
    public boolean displayGUI(){
        System.out.print("CART >>> " + cartId + "\n");
        System.out.print("Enter a command...\n");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();

        switch (choice) {
            case "browse":
                System.out.print("|---------------THE COURSE STORE---------------|\n");
                System.out.print("\\-------------------BROWSE---------------------"+"/"+"\n");
                System.out.print("Type \'help\' for a list of commands.\n\n");
                System.out.print("Stock | Product Name | Unit Price\n");

                for (Product p: storeManager.getMyInventory().getProducts()){
                    System.out.print(storeManager.getMyInventory().getStock(p.getID()) + " | " + p.getName() + " | " + p.getPrice()+"\n");
                }
                break;
            case "viewCart":
                storeManager.getUserCart(cartId).printCart();
                break;
            case "add":
                addView();
                break;
            case "remove":
                removeView();
                break;
            case "help":
                System.out.print("Available Commands: \n");
                for (String s: COMMANDS){
                    System.out.print(s+"\n");
                }
                return false;
            case "checkout":
                storeManager.processTransaction(this.cartId);
                return true;
            case "quit":
                return true;
        }

        return false;
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        StoreManager sm = new StoreManager(inventory);

        StoreView sv1 = new StoreView(sm, sm.assignNewCartID());
        StoreView sv2 = new StoreView(sm, sm.assignNewCartID());
        StoreView sv3 = new StoreView(sm, sm.assignNewCartID());
        StoreView[] users = {sv1, sv2, sv3};

        int activeSV = users.length;
        Scanner sc = new Scanner(System.in);
        while (activeSV > 0) {
            System.out.print("CHOOSE YOUR STOREVIEW >>> ");
            int choice = sc.nextInt();
            if (choice < users.length && choice >= 0) {
                if (users[choice] != null) {
                    String chooseAnother = "";
                    while (!chooseAnother.equals("y") && !chooseAnother.equals("Y")) {
                        if (users[choice].displayGUI()) {
                            users[choice] = null; activeSV--;
                            break;
                        }
                        System.out.print("GO TO ANOTHER STOREVIEW? (y) >>> "); chooseAnother = sc.next();
                    }
                }
                else {
                    System.out.println("MAIN > ERROR > BAD CHOICE\nTHAT STOREVIEW WAS DEACTIVATED");
                }
            }
            else {
                System.out.println(String.format("MAIN > ERROR > BAD CHOICE\nPLEASE CHOOSE IN RANGE [%d, %d]", 0, users.length - 1));
            }
        }
        System.out.println("ALL STOREVIEWS DEACTIVATED");
    }

    /**
     *  This view is displayed when the user chooses to add to their cart
     */
    public void addView(){
        int option = 0;
        System.out.print("|---------------THE COURSE STORE---------------|\n");
        System.out.print("\\-------------------ADD---------------------"+"/"+"\n");
        System.out.print("Stock | Product Name | Unit Price | Option\n");

        for (Product p: storeManager.getMyInventory().getProducts()){
            System.out.print(storeManager.getMyInventory().getStock(p.getID())+" | "+p.getName() +" | "+"$"+ p.getPrice()+" | ("+option+")"+"\n");
            option++;
        }

        System.out.print("Choose an Option: \n");
        Scanner sc1 = new Scanner(System.in);
        int id = sc1.nextInt();

        System.out.print("Enter the amount of this product you want: ");
        int amount = sc1.nextInt();

        if (storeManager.addToUserCart(id, storeManager.getMyInventory().getProduct(id), amount, this.cartId)){
            System.out.print("Item added to cart.\n");
        }
        else{
            System.out.print("Could not add to cart. Not enough stock. Try again. \n");
        }

    }

    /**
     * This view is displayed when the user chooses to remove from their cart
     */
    public void removeView(){
        int option = 0;
        System.out.print("|---------------THE COURSE STORE---------------|\n");
        System.out.print("\\-------------------REMOVE---------------------"+"/"+"\n");
        storeManager.getUserCart(cartId).printCart();


        System.out.print("Choose an Option: \n");
        Scanner sc1 = new Scanner(System.in);
        int id = sc1.nextInt();

        System.out.print("Enter the amount of this product you want: ");
        int amount = sc1.nextInt();

        int productId = storeManager.getUserCart(cartId).getProduct(id).getID();

        if (!storeManager.removeFromUserCart(productId,storeManager.getMyInventory().getProduct(id),amount,cartId)){
            System.out.print("Could not remove from cart. Try again. \n");
        }
        else{
            System.out.print("Item removed from cart.\n");
        }
    }
}
