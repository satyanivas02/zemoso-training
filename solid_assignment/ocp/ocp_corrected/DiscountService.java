package solid_assignment.ocp.ocp_corrected;

class DiscountService {
    public double applyDiscount(Order order, DiscountStrategy discountStrategy) {
        return discountStrategy.calculateDiscount(order);
    }
}
