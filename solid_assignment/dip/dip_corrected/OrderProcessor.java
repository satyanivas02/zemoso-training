package solid_assignment.dip.dip_corrected;

class OrderProcessor {
    private ProcessableOrder processableOrder;

    public OrderProcessor(ProcessableOrder processableOrder) {
        this.processableOrder = processableOrder;
    }

    public void processOrder() {
        processableOrder.process();
    }

    public void cancelOrder() {
        processableOrder.cancel();
    }
}
