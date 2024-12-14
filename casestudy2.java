import java.util.Scanner;

public class casestudy2 {

    public static void displayMenu() {
        System.out.println("=== MENU KAFE ===");
        System.out.println("1. Black COffee - Rp 15000");
        System.out.println("2. Latte - Rp 22000");
        System.out.println("3. Pulled Tea- Rp 12000");
        System.out.println("4. Fried Noodles - Rp 18000");
    }
    
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

    public static void showOrders(String[][] orders, int orderCount) {
        System.out.println("=== ORDER LIST ===");
        for (int i = 0; i < orderCount; i++) {
            System.out.println("Name : " + orders[i][0]);
            System.out.println("Table Number : " + orders[i][1]);
            System.out.println("Order :");
            
            int totalBlackCoffee = Integer.parseInt(orders[i][2]);
            int totalLatte = Integer.parseInt(orders[i][3]);
            int totalPulledTea = Integer.parseInt(orders[i][4]);
            int totalFriedNoodle = Integer.parseInt(orders[i][5]);

            if (totalBlackCoffee > 0) 
                System.out.println(" - Black Coffee x" + totalBlackCoffee + " (Rp " + (totalBlackCoffee * 15000) + ")");
            if (totalLatte > 0) 
                System.out.println(" - Latte x" + totalLatte + " (Rp " + (totalLatte * 22000) + ")");
            if (totalPulledTea > 0) 
                System.out.println(" - Pulled Tea x" + totalPulledTea + " (Rp " + (totalPulledTea * 12000) + ")");
            if (totalFriedNoodle > 0) 
                System.out.println(" - Fried Noodles x" + totalFriedNoodle + " (Rp " + (totalFriedNoodle * 18000) + ")");
            
            System.out.println("Total Order Price : Rp " + orders[i][6]);
            System.out.println();
        }
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