package java_assignments.assignment_6;

class OverloadedConstructor {
    private int num;

    // First constructor without parameters
    public OverloadedConstructor() {
        this(10); // Calls the second constructor with num set to 10
    }

    // Second constructor with an int parameter
    public OverloadedConstructor(int num) {
        this.num = num;
        System.out.println("Constructor called with num = " + num);
    }

    public static void main(String[] args) {
        new OverloadedConstructor(); // Calls first constructor, which calls the second one
        new OverloadedConstructor(20); // Directly calls the second constructor
    }
}

