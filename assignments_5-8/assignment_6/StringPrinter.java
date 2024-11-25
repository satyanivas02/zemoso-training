package java_assignments.assignment_6;

class StringPrinter {
    public StringPrinter(String message) {
        System.out.println("StringPrinter constructor called with message: " + message);
    }

    public static void main(String[] args) {
        // Array of object references, but no objects are actually created here
        StringPrinter[] printers = new StringPrinter[5];

        // At this point, nothing is printed because no constructor has been called
        System.out.println("Array of StringPrinter references created.");
    }
}

