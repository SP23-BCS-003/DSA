// File: LinkedList.java

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Insert a new node at the beginning
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert a new node at a specific position (1-based index)
    public void insertAtMiddle(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            insertAtFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Insert a new node at the end
    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Remove the first node
    public void deleteAtFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    // Remove a node at a specific position (1-based index)
    public void deleteAtMiddle(int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        current.next = current.next.next;
    }

    // Remove the last node
    public void deleteAtLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Helper function to display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Test insertions
        list.insertAtFirst(1);
        list.insertAtLast(3);
        list.insertAtMiddle(2, 2);
        list.display(); // Output: 1 -> 2 -> 3 -> null

        // Test deletions
        list.deleteAtFirst();
        list.display(); // Output: 2 -> 3 -> null

        list.deleteAtMiddle(1);
        list.display(); // Output: 3 -> null

        list.deleteAtLast();
        list.display(); // Output: null
    }
}
