import java.util.Scanner;

public class casestudy2 {
    public static void takeOrder(Scanner sc, String[][] orders, int orderCount) {
    
        int[] priceMenu = {15000, 22000, 12000, 18000};
        String[] menuNames = {"Black Coffee", "Latte", "Pulled Tea", "Fried Noodle"};
    
        System.out.println();
        sc.nextLine();
        System.out.print("Enter Customer's Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Table Number : ");
        int tableNumber = sc.nextInt();
    
        orders[orderCount][0] = name;
        orders[orderCount][1] = String.valueOf(tableNumber);

        int[] quantities = new int[4];
        displayMenu();

    int cafeMenu;
        do {
            System.out.print("Choose Menu (Enter Menu Number or 0 to Finish) : ");
            cafeMenu = sc.nextInt();
            if (cafeMenu == 0) {
                break;
            }
            if (cafeMenu >= 1 && cafeMenu <= 4) {
                System.out.print("Enter The Number of Items For " + menuNames[cafeMenu - 1] + " : ");
                int quantity = sc.nextInt();
                System.out.println();
                quantities[cafeMenu - 1] += quantity;
                
            } else {
                System.out.println("Menu not valid, Please try again.");
            }

        } while (cafeMenu != 0);

        for (int i = 0; i < menuNames.length; i++) {
            orders[orderCount][i + 2] = String.valueOf(quantities[i]);
        }
        int totalPrice = 0;
        for (int i = 0; i < menuNames.length; i++) {
            totalPrice += quantities[i] * priceMenu[i];
        }

        orders[orderCount][6] = String.valueOf(totalPrice);
        System.out.println("Order Added Successfully.");
        System.out.println("Total Order Price : Rp " + totalPrice);
    }

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