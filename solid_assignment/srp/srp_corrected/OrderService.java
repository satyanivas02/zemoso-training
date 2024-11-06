package solid_assignment.srp.srp_corrected;

class OrderService {
    public void placeOrder(Order order) {
        System.out.println("Order placed with total price: $" + order.getTotalPrice());
    }
}