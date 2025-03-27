/*
Java implementation of Doubly Linked List (DLL) Deletion with methods to delete nodes at:

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

    // Insert at the end (helper function)
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

    // Delete from the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    // Delete from the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    // Delete at a specific position
    public void deleteAtPosition(int position) {
        if (head == null || position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    // Delete from the middle (calculated dynamically)
    public void deleteFromMiddle() {
        if (head == null || head.next == null) {
            deleteFromBeginning();
            return;
        }

        Node slow = head;
        Node fast = head;

        // Finding the middle node using slow and fast pointers
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Remove middle node
        if (slow.prev != null) {
            slow.prev.next = slow.next;
        }
        if (slow.next != null) {
            slow.next.prev = slow.prev;
        }
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

// Driver code
public class Deletion {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Inserting elements
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);
        dll.display();

        // Deleting from beginning
        dll.deleteFromBeginning();
        dll.display();

        // Deleting from end
        dll.deleteFromEnd();
        dll.display();

        // Deleting from a specific position (2nd position)
        dll.deleteAtPosition(2);
        dll.display();

        // Deleting from middle
        dll.deleteFromMiddle();
        dll.display();
    }
}
