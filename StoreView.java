import java.util.Scanner;

public class StoreView {

    public static void main(String[] args) {
        StoreManager sm = new StoreManager();
        StoreView sv1 = new StoreView(sm, sm.assignNewCartID()); StoreView sv2 = new StoreView(sm, sm.assignNewCartID()); StoreView sv3 = new StoreView(sm, sm.assignNewCartID()); StoreView[] users = {sv1, sv2, sv3};
        int activeSV = users.length;
        Scanner sc = new Scanner(System.in);
        while (activeSV > 0) {
            System.out.print("CHOOSE YOUR STOREVIEW >>> ");
            int choice = sc.nextInt();
            if (choice < users.length && choice >= 0) {
                if (users[choice] != null) {
                    String chooseAnother = "";
                    while (!chooseAnother.equals("y") && !chooseAnother.equals("Y")) {
// this implementation of displayGUI waits for input and displays the page // corresponding to the user's input. it does this once, and then returns // true if the user entered 'checkout' or 'quit'.
                        if (users[choice].displayGUI()) {
                            users[choice] = null; activeSV--;
                            break;
                        }
                        System.out.print("GO TO ANOTHER STOREVIEW? (y) >>> "); chooseAnother = sc.next();
                    }
                } else {
                    System.out.println("MAIN > ERROR > BAD CHOICE\nTHAT STOREVIEW WAS DEACTIVATED"); }
            } else { System.out.println(
                    String.format("MAIN > ERROR > BAD CHOICE\nPLEASE CHOOSE IN RANGE [%d, %d]", 0, users.length - 1)
            ); }
        }
        System.out.println("ALL STOREVIEWS DEACTIVATED"); }
}
