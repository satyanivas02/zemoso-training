package java_assignments.assignment_5.satyanivas.assignment;

public class Data {
    // Member variables (fields) are not initialized
    int intVar;  // Default value for int is 0
    char charVar;  // Default value for char is '\u0000' (null character)

    // Method to print the values of intVar and charVar
    public void printMemberVariables() {
        System.out.println("intVar: " + intVar);
        System.out.println("charVar: '" + charVar + "'"); // Displaying charVar explicitly
    }

    // Method with local variables without initialization
    public void printLocalVariables() {
        int localInt;
        char localChar;

        // Uncommenting the below lines will cause a compilation error because
        // local variables must be initialized before use.
        /*
        System.out.println("localInt: " + localInt);
        System.out.println("localChar: '" + localChar + "'");
        */

        /* Explanation:
           Unlike member variables, local variables in Java do not have a default value and must be
           explicitly initialized before use. Attempting to print uninitialized local variables will
           cause a compilation error.
        */
    }
}
