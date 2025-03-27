/*
Java implementation of Doubly Linked List (DLL) Deletion with methods to Insert nodes at:

1)Beginning
2)End
3)Specific position
4)Middle (calculated dynamically)

*/

// Node structure
class Node {
    int data;
    Node next;
    Node prev;

    public Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}

// Doubly Linked List class
class DoublyLinkedList {
    Node head;

    public DoublyLinkedList() {
        head = null;
    }

    // Insert at the beginning
    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert at a specific position
    public void insertAtPosition(int value, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(value);
        if (position == 1) {
            insertAtBeginning(value);
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }

        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert at the middle (calculated dynamically)
    public void insertAtMiddle(int value) {
        if (head == null || head.next == null) {
            insertAtEnd(value);
            return;
        }

        Node slow = head;
        Node fast = head;

        // Finding the middle node using slow and fast pointers
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newNode = new Node(value);

        // Insert after the middle node (slow pointer)
        newNode.next = slow.next;
        if (slow.next != null) {
            slow.next.prev = newNode;
        }
        slow.next = newNode;
        newNode.prev = slow;
    }

    // Display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class Insertion {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.display();

        dll.insertAtBeginning(5);
        dll.display();

        dll.insertAtPosition(15, 3);
        dll.display();

        dll.insertAtMiddle(25);
        dll.display();
    }
}
