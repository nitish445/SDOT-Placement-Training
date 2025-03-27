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

    //-----function to insert data at beginning
    public void insertAtBeginning(int data)
    {
        Node new_Node = new Node(data);
        new_Node.next = head; // Point new node to current head
        head = new_Node; // Update head to the new node
    }

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

    //-----to connect to next and data and print
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

        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);

        System.out.println("Original List:");
        list.display();

        list.insertAtBeginning(1); // Insert at the beginning
        System.out.println("After inserting at the beginning:");
        list.display();
    }
}
