import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    String name;
    String category;
    double price;

    MenuItem(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " - $" + price;
    }
}

class Menu {
    ArrayList<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void displayMenu() {
        System.out.println("\n------- FOOD MENU -------");
        for (MenuItem item : items) {
            System.out.println(item.getCategory() + ": " + item);
        }

    }

    public MenuItem getItemByName(String name) {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

}

class Order {
    private List<MenuItem> orderItems = new ArrayList<>();
    private double total = 0;
    private double disPrice=0;

    public void addToOrder(MenuItem item) {
        orderItems.add(item);
    }

    public void displayOrder() {
        System.out.println("\n------- YOUR ORDER -------");

        for (MenuItem item : orderItems) {
            System.out.println(item);
            total += item.getPrice();
        }
        confirmOrder();

    }

    // GST method
    public double getGST(){
        return total*0.18;
    }

    // Total amount method
    public double getSubTotal(){
        return total + getGST();
    }

    // Discount method
    public void getDiscount(){
        double disCount=getSubTotal()*0.10;
        disPrice = getSubTotal() - disCount;
        System.out.printf("Discount  : $%.2f\n", disPrice);

        System.out.println("--------------------------------");
        System.out.println("Final Bill - "+disPrice+" (After discount!)");
        System.out.println("=================================");
        System.out.println("\nCongratulations! You got 10% discount on your Order.");
        
    }

    // Confirm Order
    public void confirmOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIf your order is Correct Enter (Yes/No):- ");
        String choice1 = sc.nextLine();

        if (choice1.equalsIgnoreCase("yes")) {

            System.out.println("\nORDER Confirmed\n========== BILL RECEIPT ==========");
            System.out.printf("Total Bill: $%.2f\n", total);
            System.out.printf("GST(18%%)  : $%.2f\n", getGST());
            System.out.printf("SubTotal  : $%.2f\n", getSubTotal());

            double finalAmount = getSubTotal();

            if(finalAmount >= 500){
                getDiscount();
                finalAmount = disPrice;
            }
              
            System.out.print("Pay for your dish! ");
            double money = sc.nextDouble();
            
            if (money < finalAmount) {
                System.out.println("You didn't pay sufficient amount. Order cancelled.");
            } 
            else {
                double change = money - finalAmount;
                System.out.println("\nThank you for your order!");
                System.out.printf("Change : $%.2f\n", change);
                System.out.println("Visit again!");
            }
        } else {
            System.out.println("You cancle Order\nThankyou! Visite again\n");
        }
    }

}


public class OnlineResturantOrderSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        menu.addItem(new MenuItem("Cheeseburger", "Main Course", 150));
        menu.addItem(new MenuItem("Cheese Sandwich", "Main Course", 220));
        menu.addItem(new MenuItem("Chicken Burger", "Main Course", 300));
        menu.addItem(new MenuItem("Spicy Chicken", "Main Course", 350));
        menu.addItem(new MenuItem("Hot Dog", "Main Course", 450));

        menu.addItem(new MenuItem("Fruit Salad", "Appetizer", 99));
        menu.addItem(new MenuItem("Cocktails", "Appetizer", 120));
        menu.addItem(new MenuItem("Nuggets", "Appetizer", 200));
        menu.addItem(new MenuItem("Sandwich", "Appetizer", 100));
        menu.addItem(new MenuItem("French Fries", "Appetizer", 80));

        menu.addItem(new MenuItem("Milk Shake", "Beverage", 50));
        menu.addItem(new MenuItem("Iced Tea", "Beverage", 85));
        menu.addItem(new MenuItem("Orange Juice", "Beverage", 80));
        menu.addItem(new MenuItem("Lemon Tea", "Beverage", 50));
        menu.addItem(new MenuItem("Coffee", "Beverage", 70));

        Order order = new Order();

        menu.displayMenu();

        String choice2;
        do {
            System.out.print("\nEnter item name to order: ");
            String itemName = sc.nextLine();

            MenuItem selectedItem = menu.getItemByName(itemName);
            if (selectedItem != null) {
                order.addToOrder(selectedItem);
                System.out.println(itemName + " added to order.");
            } else {
                System.out.println("Item not found!");
            }
            System.out.println("Do you want to add more items? (yes/no): ");
            choice2 = sc.nextLine();
        } while (choice2.equalsIgnoreCase("yes"));

        order.displayOrder();

    }
}


// Order confirmed
// Subtotal: ₹220.0
// GST (18%): ₹39.6
// Total: ₹259.6 

// return String.format("%s - %c%.2f", name, '\u20B9', price);