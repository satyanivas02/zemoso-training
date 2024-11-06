package solid_assignment.srp.srp_corrected;

import java.util.ArrayList;
import java.util.List;
class Order {
    private List<FoodItem> items = new ArrayList<>();
    private double totalPrice;

    public void addItem(FoodItem item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<FoodItem> getItems() {
        return items;
    }
}
