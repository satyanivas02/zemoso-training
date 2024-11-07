package solid_assignment.lsp.lsp_corrected;

class PickUp implements DeliveryMethod {
    public void execute(String address) {
        System.out.println("Order ready for pickup at location.");
    }
}