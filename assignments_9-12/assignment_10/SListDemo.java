package java_assignments.assignment_10;

// Node class to represent each element in the SList
class Node<T> {
    T data;             // Generic data field
    Node<T> next;       // Reference to the next node

    // Constructor to initialize data
    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// SList class to represent a generic singly linked list
class SList<T> {
    private Node<T> head;    // Head of the list

    // Constructor to initialize the list with no elements
    public SList() {
        head = null;
    }

    // Method to get an iterator for the SList
    public SListIterator<T> iterator() {
        return new SListIterator<>(this);
    }

    // toString method to display elements in the SList
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) result.append(", ");
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    // Setter for the head, used internally by the iterator
    void setHead(Node<T> head) {
        this.head = head;
    }

    // Getter for the head, used internally by the iterator
    Node<T> getHead() {
        return head;
    }
}

// SListIterator class to iterate through SList and modify it
class SListIterator<T> {
    private Node<T> current;
    private SList<T> list;

    // Constructor, initialize with the start of the list
    SListIterator(SList<T> list) {
        this.list = list;
        this.current = list.getHead();
    }

    // Method to add a new element to the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (list.getHead() == null) {
            list.setHead(newNode); // If list is empty, new node becomes the head
        } else {
            Node<T> temp = list.getHead();
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode; // Add the new node at the end of the list
        }
    }

    // Method to check if there is a next element
    public boolean hasNext() {
        return current != null;
    }

    // Method to move to the next element and return data
    public T next() {
        T data = current.data;
        current = current.next;
        return data;
    }

    // Method to remove an element from the list
    public void remove(T data) {
        if (list.getHead() == null) return; // If the list is empty, nothing to remove

        if (list.getHead().data.equals(data)) {
            list.setHead(list.getHead().next); // Remove the head if it matches
            return;
        }

        Node<T> prev = null;
        Node<T> current = list.getHead();

        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current != null) { // Element found
            prev.next = current.next; // Bypass the node to be removed
        }
    }
}

// Main class to demonstrate usage of SList and SListIterator
public class SListDemo {
    public static void main(String[] args) {
        // Create an SList instance for Strings
        SList<String> sList = new SList<>();

        // Get an iterator for the SList
        SListIterator<String> iterator = sList.iterator();

        // Add elements to the SList using the iterator
        iterator.add("Apple");
        iterator.add("Banana");
        iterator.add("Cherry");

        // Print the list
        System.out.println("SList after adding elements: " + sList);

        // Remove an element
        iterator.remove("Banana");

        // Print the list again
        System.out.println("SList after removing 'Banana': " + sList);

        // Iterate through remaining elements
        iterator = sList.iterator(); // Reset iterator
        System.out.print("Remaining elements: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}

