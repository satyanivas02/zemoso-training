package solid_assignment.dip.dip_corrected;

class UrgentOrder implements ProcessableOrder {
    public void process() {
        System.out.println("Processing urgent order items...");
        System.out.println("Applying expedited shipping...");
        System.out.println("Urgent order processed successfully.");
    }

    public void cancel() {
        System.out.println("Urgent order canceled. Notifying customer service.");
    }
}