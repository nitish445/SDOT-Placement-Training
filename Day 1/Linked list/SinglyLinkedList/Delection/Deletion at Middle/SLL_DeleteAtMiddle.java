class Node{
    int data;
    Node next;

    public Node(int val)
    {
        this.data=val;
        this.next=null;
    }
}

public class SLL_DeleteAtMiddle {

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

    //-----function to delete middle node
    public void deleteAtMiddle()
    {
        if (head == null || head.next == null)
        {
            System.out.println("List too short for middle deletion.");
            return;
        }

        Node slow = head, fast = head;
        Node prev = null;

        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) 
        {
            prev.next = slow.next;
        }
    }

    //-----function to print list
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

        SLL_DeleteAtMiddle list= new SLL_DeleteAtMiddle(); 

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);

        System.out.println("Original List:");
        list.display();

        list.deleteAtMiddle();
        System.out.println("After deleting middle node:");
        list.display();
    }
}
