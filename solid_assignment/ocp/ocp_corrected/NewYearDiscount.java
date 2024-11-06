package solid_assignment.ocp.ocp_corrected;

class NewYearDiscount implements DiscountStrategy {
    public double calculateDiscount(Order order) {
        return order.getAmount() * 0.2;
    }
}
