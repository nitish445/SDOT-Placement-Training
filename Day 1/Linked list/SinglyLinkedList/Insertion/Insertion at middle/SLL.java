/*
 * Complete Java Code for a Singly Linked List with "Insert at Middle" using the Turtle Method
 *
 * The turtle method (slow and fast pointer technique) is used to find the middle node of the list.
 * The slow pointer moves one step at a time while the fast pointer moves two steps.
 * When the fast pointer reaches the end, the slow pointer will be at the middle.
 *
 * This example includes:
 *  - Standard insertion at the end.
 *  - Insertion at the middle (after the middle node).
 */

class Node{
    int data;
    Node next;

    public Node(int val)
    {
        this.data=val;
        this.next=null;
    }
}

public class SLL {

    Node head;

    //-----function to insert data at end
    public void insertAtEnd(int data)
    {
        Node new_Node= new Node(data);
        if(head==null)
        {
            head= new_Node;
            return;
        }

        Node temp=head;
        while (temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=new_Node;
    }

    /*
     * Method to insert a new node in the middle of the list using the turtle method.
     * The new node is inserted right after the middle node.
     */
    public void insertAtMiddle(int data) {
        Node newNode = new Node(data);
        // If list is empty or has only one element, insert at end
        if (head == null || head.next == null) {
            insertAtEnd(data);
            return;
        }
        
        Node slow = head;  // Turtle: moves one step at a time
        Node fast = head;  // Hare: moves two steps at a time
        
        // Move slow pointer one step and fast pointer two steps until fast reaches the end
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Insert new node after the slow pointer (middle)
        newNode.next = slow.next;
        slow.next = newNode;
    }


    //-----to connect to next and data and print (explantion and step in down)
    public void display()
    {
        Node temp= head;

        while(temp!= null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        SLL list= new SLL(); //to access all data present in SLL

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);

        list.insertAtMiddle(10);

        list.display();


    }
}
