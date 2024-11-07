package solid_assignment.srp.srp_violated;

import java.util.ArrayList;
import java.util.List;
class Order {
    private List<FoodItem> items = new ArrayList<>();
    private double totalPrice;

    public void addItem(FoodItem item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public void placeOrder() {
        System.out.println("Order placed with total price: " + totalPrice);
    }

    public void printReceipt() {
        System.out.println("Receipt:");
        for (FoodItem item : items) {
            System.out.println(item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total: $" + totalPrice);
    }
}