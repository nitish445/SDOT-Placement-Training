class Node{
    int data;
    Node next;

    public Node(int val)
    {
        this.data=val;
        this.next=null;
    }
}

public class SLL_DeleteAtBeginning {

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

    //-----function to delete first node
    public void deleteAtBeginning()
    {
        if (head == null)
        {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        head = head.next;
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

        SLL_DeleteAtBeginning list= new SLL_DeleteAtBeginning(); 

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);

        System.out.println("Original List:");
        list.display();

        list.deleteAtBeginning();
        System.out.println("After deleting first node:");
        list.display();
    }
}
