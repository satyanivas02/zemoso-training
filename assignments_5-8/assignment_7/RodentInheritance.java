package java_assignments.assignment_7;

// Base class representing a Rodent
abstract class Rodent {
    // Constructor for Rodent
    public Rodent() {
        System.out.println("This is a Rodent.");
    }

    // Abstract methods for rodent behaviors
    abstract void eat();
    abstract void sleep();
}

// Derived class for Mouse
class Mouse extends Rodent {
    // Constructor for Mouse
    public Mouse() {
        System.out.println("This is a Mouse.");
    }

    // Implement the eat method
    @Override
    void eat() {
        System.out.println("Mouse is nibbling on cheese.");
    }

    // Implement the sleep method
    @Override
    void sleep() {
        System.out.println("Mouse is sleeping in a small burrow.");
    }
}

// Derived class for Gerbil
class Gerbil extends Rodent {
    // Constructor for Gerbil
    public Gerbil() {
        System.out.println("This is a Gerbil.");
    }

    // Implement the eat method
    @Override
    void eat() {
        System.out.println("Gerbil is munching on seeds.");
    }

    // Implement the sleep method
    @Override
    void sleep() {
        System.out.println("Gerbil is sleeping in sand.");
    }
}

// Derived class for Hamster
class Hamster extends Rodent {
    // Constructor for Hamster
    public Hamster() {
        System.out.println("This is a Hamster.");
    }

    // Implement the eat method
    @Override
    void eat() {
        System.out.println("Hamster is eating grains.");
    }

    // Implement the sleep method
    @Override
    void sleep() {
        System.out.println("Hamster is sleeping in a cage.");
    }
}

// Main class to test the Rodent hierarchy
public class RodentInheritance {
    public static void main(String[] args) {
        // Create an array of Rodents and fill with specific types
        Rodent[] rodents = { new Mouse(), new Gerbil(), new Hamster() };

        // Call the methods and observe polymorphism
        for (Rodent rodent : rodents) {
            rodent.eat();
            rodent.sleep();
        }
    }
}

