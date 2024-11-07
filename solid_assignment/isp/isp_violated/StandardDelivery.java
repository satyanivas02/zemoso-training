package solid_assignment.isp.isp_violated;

class StandardDelivery implements DeliveryService {
    public void deliver(String address) {
        System.out.println("Delivering to address: " + address);
    }

    public void scheduleDelivery(String date) {
        throw new UnsupportedOperationException("Standard delivery does not support scheduling.");
    }
}
