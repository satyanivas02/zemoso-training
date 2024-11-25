package java_assignments.assignment_7;

// Base class representing a general Cycle
class Cycle {
    public Cycle() {
        System.out.println("This is a cycle.");
    }
}

// Subclass for Unicycle
class Unicycle extends Cycle {
    public Unicycle() {
        System.out.println("This is a Unicycle.");
    }

    public void balance() {
        System.out.println("Unicycle needs balance to stay upright.");
    }
}

// Subclass for Bicycle
class Bicycle extends Cycle {
    public Bicycle() {
        System.out.println("This is a Bicycle.");
    }

    public void balance() {
        System.out.println("Bicycle also needs balance to stay upright.");
    }
}

// Subclass for Tricycle
class Tricycle extends Cycle {
    public Tricycle() {
        System.out.println("This is a Tricycle.");
    }
    // Tricycle does not have a balance method
}

// Main class to test Cycle hierarchy
public class CycleInhertance {
    public static void main(String[] args) {
        // Create an array of Cycle types
        Cycle[] cycles = { new Unicycle(), new Bicycle(), new Tricycle() };

        // Attempt to call balance() on each element
        for (Cycle cycle : cycles) {
            if (cycle instanceof Unicycle) {
                ((Unicycle) cycle).balance();
            } else if (cycle instanceof Bicycle) {
                ((Bicycle) cycle).balance();
            } else {
                System.out.println("Tricycle does not need balance.");
            }
        }
    }
}

