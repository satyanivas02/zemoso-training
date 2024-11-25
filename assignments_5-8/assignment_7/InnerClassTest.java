package java_assignments.assignment_7;

// Outer class with an inner class having a non-default constructor
class OuterClass {
    // Inner class with a non-default constructor
    class InnerClass {
        private String message;

        // Constructor that takes an argument
        public InnerClass(String message) {
            this.message = message;
            System.out.println("InnerClass: " + message);
        }
    }
}

// Another class with an inner class that inherits from the first inner class
class AnotherClass extends OuterClass {
    // Inner class inheriting from OuterClass.InnerClass
    class AnotherInnerClass extends OuterClass.InnerClass {
        // Constructor of AnotherInnerClass, calling super to pass argument
        public AnotherInnerClass(String message) {
            super(message);
            System.out.println("AnotherInnerClass: " + message);
        }
    }
}

// Main class to test the inner classes
public class InnerClassTest {
    public static void main(String[] args) {
        // Create an instance of AnotherClass
        AnotherClass anotherClass = new AnotherClass();

        // Create an instance of AnotherInnerClass
        AnotherClass.AnotherInnerClass inner = anotherClass.new AnotherInnerClass("Hello from AnotherInnerClass!");
    }
}

