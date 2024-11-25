package java_assignments.assignment_8;

// Custom Exception 1
class FirstException extends Exception {
    public FirstException(String message) {
        super(message); // Pass message to superclass constructor
    }
}

// Custom Exception 2
class SecondException extends Exception {
    public SecondException(String message) {
        super(message); // Pass message to superclass constructor
    }
}

// Custom Exception 3
class ThirdException extends Exception {
    public ThirdException(String message) {
        super(message); // Pass message to superclass constructor
    }
}

// Class containing method that throws different exceptions
class ExceptionDemo {

    /**
     * Method that throws each of the three custom exceptions based on condition
     * @param condition Determines which exception to throw
     * @throws FirstException, SecondException, ThirdException Based on the condition
     */
    public void testExceptions(int condition) throws FirstException, SecondException, ThirdException {
        switch (condition) {
            case 1:
                throw new FirstException("FirstException triggered");
            case 2:
                throw new SecondException("SecondException triggered");
            case 3:
                throw new ThirdException("ThirdException triggered");
            default:
                throw new NullPointerException("NullPointerException triggered");
        }
    }
}

// Main class to test exception handling
public class Main {
    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo();

        try {
            // Calling testExceptions with a specific value to trigger an exception
            demo.testExceptions(2); // Change this number to test different exceptions
        } catch (Exception e) {
            // Catch all types of exceptions in a single catch block
            System.out.println("Caught an exception: " + e.getMessage());
        } finally {
            // This block always runs, regardless of exception being thrown
            System.out.println("Finally block executed.");
        }
    }
}

