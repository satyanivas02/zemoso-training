package solid_assignment.isp.isp_corrected;

class StandardDelivery implements Delivery {
    public void deliver(String address) {
        System.out.println("Delivering to address: " + address);
    }
}