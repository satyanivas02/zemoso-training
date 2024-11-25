package java_assignments.assignment_5.satyanivas.assignment;

public class Singleton {
    // Non-static member variable
    private String str;

    /* Static method that initializes the non-static member variable `str`.
       This method accepts a String as a parameter, assigns it to `str`, and returns
       a new instance of the `Singleton` class with `str` set to that value.
    */
    public static Singleton initialize(String input) {
        // Create a new Singleton object (instance of Singleton)
        Singleton instance = new Singleton();

        // Set the non-static `str` variable of this new instance to the provided `input` value
        instance.str = input;

        // Return the newly created instance
        return instance;
    }

    // Non-static method to print the String member variable
    public void printString() {
        System.out.println("String: " + str);
    }
}
