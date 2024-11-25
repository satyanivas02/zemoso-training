package java_assignments.assignment_7;

// Interface A with two methods
interface InterfaceA {
    void methodA1();
    void methodA2();
}

// Interface B with two methods
interface InterfaceB {
    void methodB1();
    void methodB2();
}

// Interface C with two methods
interface InterfaceC {
    void methodC1();
    void methodC2();
}

// Combined interface that inherits from A, B, and C and adds a new method
interface CombinedInterface extends InterfaceA, InterfaceB, InterfaceC {
    void methodCombined();
}

// Concrete base class
class BaseClass {
    public void baseMethod() {
        System.out.println("BaseClass method.");
    }
}

// Implementing class that inherits from BaseClass and implements CombinedInterface
class ImplementingClass extends BaseClass implements CombinedInterface {
    // Implement methods from InterfaceA
    public void methodA1() {
        System.out.println("methodA1 implementation.");
    }

    public void methodA2() {
        System.out.println("methodA2 implementation.");
    }

    // Implement methods from InterfaceB
    public void methodB1() {
        System.out.println("methodB1 implementation.");
    }

    public void methodB2() {
        System.out.println("methodB2 implementation.");
    }

    // Implement methods from InterfaceC
    public void methodC1() {
        System.out.println("methodC1 implementation.");
    }

    public void methodC2() {
        System.out.println("methodC2 implementation.");
    }

    // Implement new method in CombinedInterface
    public void methodCombined() {
        System.out.println("CombinedInterface specific method.");
    }
}

// Four methods to take each interface as an argument
public class InterfaceInheritance {
    static void useInterfaceA(InterfaceA obj) {
        obj.methodA1();
        obj.methodA2();
    }

    static void useInterfaceB(InterfaceB obj) {
        obj.methodB1();
        obj.methodB2();
    }

    static void useInterfaceC(InterfaceC obj) {
        obj.methodC1();
        obj.methodC2();
    }

    static void useCombinedInterface(CombinedInterface obj) {
        obj.methodCombined();
    }

    public static void main(String[] args) {
        // Create an object of ImplementingClass
        ImplementingClass obj = new ImplementingClass();

        // Pass the object to each method
        useInterfaceA(obj);
        useInterfaceB(obj);
        useInterfaceC(obj);
        useCombinedInterface(obj);

        // Access base class method
        obj.baseMethod();
    }
}
