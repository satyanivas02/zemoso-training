package java_assignments.assignment_5.satyanivas.assignment;

public class Main {
    public static void main(String[] args) {
        // Create an object of the Data class
        Data dataObj = new Data();

        // Call method to print member variables
        System.out.println("Printing member variables in Data class:");
        dataObj.printMemberVariables();

        // Call method to print local variables (will not work due to compilation error if uncommented)
        System.out.println("\nAttempting to print local variables in Data class:");
        dataObj.printLocalVariables();

        // Explanation:
        /* The printLocalVariables method in Data class attempts to print uninitialized local variables.
           In Java, local variables do not have a default value and must be initialized before use.
           Uncommenting the print statements in printLocalVariables will cause a compilation error.
        */

        // Create an object of the Singleton class using the static initialize method
        Singleton singletonObj = Singleton.initialize("Hello, Singleton!");

        // Call the non-static method to print the String member variable
        System.out.println("\nPrinting the String in Singleton class:");
        singletonObj.printString();
    }
}

