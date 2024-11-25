package java_assignments.assignment_7.CycleFactory;

import java_assignments.assignment_7.Bicycle;
import java_assignments.assignment_7.Cycle;
import java_assignments.assignment_7.Tricycle;
import java_assignments.assignment_7.Unicycle;

// Cycle interface
interface Cycle1 {
    void ride();
}

// Unicycle implementation of Cycle
class Unicycle1 implements Cycle1{
    public void ride() {
        System.out.println("Riding a Unicycle.");
    }
}

// Bicycle implementation of Cycle
class Bicycle1 implements Cycle1 {
    public void ride() {
        System.out.println("Riding a Bicycle.");
    }
}

// Tricycle implementation of Cycle
class Tricycle1 implements Cycle1 {
    public void ride() {
        System.out.println("Riding a Tricycle.");
    }
}

// Factory interface for creating Cycles
interface CycleFactory {
    Cycle createCycle();
}

// Factory for creating Unicycles
class UnicycleFactory implements CycleFactory {
    public Cycle createCycle() {
        return new Unicycle();
    }
}

// Factory for creating Bicycles
class BicycleFactory implements CycleFactory {
    public Cycle createCycle() {
        return new Bicycle();
    }
}

// Factory for creating Tricycles
class TricycleFactory implements CycleFactory {
    public Cycle createCycle() {
        return new Tricycle();
    }
}

// Main class to test Cycle factories
public class CycleFactoryTest {
    public static void main(String[] args) {
        // Using factories to create cycles
        CycleFactory unicycleFactory = new UnicycleFactory();
        Cycle unicycle = unicycleFactory.createCycle();
        unicycle.ride();

        CycleFactory bicycleFactory = new BicycleFactory();
        Cycle bicycle = bicycleFactory.createCycle();
        bicycle.ride();

        CycleFactory tricycleFactory = new TricycleFactory();
        Cycle tricycle = tricycleFactory.createCycle();
        tricycle.ride();
    }
}

