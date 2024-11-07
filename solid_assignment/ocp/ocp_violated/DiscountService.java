package solid_assignment.ocp.ocp_violated;

class DiscountService {
    public double calculateDiscount(Order order, String discountType) {
        if (discountType.equals("NEWYEAR")) {
            return order.getAmount() * 0.2;
        } else if (discountType.equals("BLACKFRIDAY")) {
            return order.getAmount() * 0.5;
        }
        return 0;
    }
}
