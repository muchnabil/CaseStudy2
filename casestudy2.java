import java.util.Scanner;

public class casestudy2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] orders = new String[100][7];
        int orderCount = 0;
        
        while (true) {
            System.out.println("=== MENU CAFE ===");
            System.out.println("1. Add Order");
            System.out.println("2. Show Order List");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Choose Menu : ");
            int chooseMenu = sc.nextInt();

            if (chooseMenu == 1) {
                takeOrder(sc, orders, orderCount); 
                orderCount++;
            } else if (chooseMenu == 2) {
                showOrders(orders, orderCount); 
            } else if (chooseMenu == 3) {
                System.out.println("Thank You!");
                break;
            } else {
                System.out.println("Invalid option, Please select again.");
            }
        }

        sc.close();
    }
}