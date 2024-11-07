package solid_assignment.dip.dip_violated;

class OrderProcessor {
    private Order order;

    public OrderProcessor() {
        this.order = new Order();
    }

    public void processOrder() {
        order.process();
    }

    public void cancelOrder() {
        order.cancel();
    }
}