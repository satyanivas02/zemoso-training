package solid_assignment.dip.dip_corrected;

class Order implements ProcessableOrder {
    public void process() {
        System.out.println("Processing order items...");
        System.out.println("Calculating total price...");
        System.out.println("Order processed successfully.");
    }

    public void cancel() {
        System.out.println("Order canceled.");
    }
}
