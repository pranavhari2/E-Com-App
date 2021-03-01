public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        StoreManager manager = new StoreManager();


        System.out.println("Product: "+inventory.getProduct(1).getName()+"  Stock: "+ inventory.getStock(1));

        System.out.println(manager.checkStock(inventory.getProduct(1)));

        int[][] userCart = {{inventory.getProduct(1).getID(), 1},
                           {inventory.getProduct(2).getID(), 3-}
        };

        int total = manager.processTransaction(userCart);

        System.out.println(total);





    }
}