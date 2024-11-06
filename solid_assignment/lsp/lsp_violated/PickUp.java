package solid_assignment.lsp.lsp_violated;

class PickUp extends StandardDelivery {
    @Override
    public void deliver(String address) {
        throw new UnsupportedOperationException("Pick up does not support delivery.");
    }
}
