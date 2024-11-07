package solid_assignment.lsp.lsp_corrected;

class StandardDelivery implements DeliveryMethod {
    public void execute(String address) {
        System.out.println("Delivering to address: " + address);
    }
}
