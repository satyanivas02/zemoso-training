package java_assignments.assignment_6;

class StringPrinter1 {
    public StringPrinter1(String message) {
        System.out.println("StringPrinter constructor called with message: " + message);
    }

    public static void main(String[] args) {
        // Array of object references
        StringPrinter1[] printers = new StringPrinter1[5];

        // Assigning new objects to each reference in the array
        for (int i = 0; i < printers.length; i++) {
            printers[i] = new StringPrinter1("Message " + (i + 1));
        }

        // Each object instantiation calls the constructor, printing the message
    }
}

