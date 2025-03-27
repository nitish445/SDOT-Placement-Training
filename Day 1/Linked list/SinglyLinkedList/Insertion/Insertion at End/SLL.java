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

        /*
        //Creating a node
        Node head =new Node(1);
        Node mid =new Node(2);
        Node last =new Node(3);

        //printing data of all
        System.out.println(head.data);
        System.out.println(mid.data);
        System.out.println(last.data);
        

        //creating next
        head.next=mid;
        mid.next=last;

        //connecting node to next and displaying
        Node temp= head;

        while(temp!= null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
        */

        SLL list= new SLL(); //to access all data present in SLL

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);

        list.display();


    }
}
