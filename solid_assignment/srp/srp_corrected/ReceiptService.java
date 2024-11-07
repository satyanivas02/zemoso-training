package solid_assignment.srp.srp_corrected;

class ReceiptService {
    public void printReceipt(Order order) {
        System.out.println("Receipt:");
        for (FoodItem item : order.getItems()) {
            System.out.println(item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total: $" + order.getTotalPrice());
    }
}
