public class StoreManager {

    private Inventory myInventory;

    public StoreManager(){
        myInventory = new Inventory();
    }

    public Inventory getInventory() {
        return myInventory;
    }

    public void setInventory(Inventory myInventory) {
        this.myInventory = myInventory;
    }

    public int checkStock(String id){
        return myInventory.getStock(id);
    }

    public int processTransaction(ProductSearch[] userCart){

        int total = 0;




    }






}
