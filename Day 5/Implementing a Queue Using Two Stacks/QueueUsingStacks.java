/*
Implementing a Queue Using Two Stacks
The Queue data structure operates on a First-In-First-Out (FIFO) basis, while a Stack operates on a Last-In-First-Out (LIFO) basis. To simulate a queue using two stacks, we can use the following approach:

Approach (Using Two Stacks):
Stack1: This will be used for enqueuing (pushing elements to the queue).
Stack2: This will be used for dequeuing (popping elements from the queue).

Steps to Implement the Queue Using Two Stacks:
Step 1: Enqueue Operation
To add an element to the queue, simply push it onto Stack1.

Step 2: Dequeue Operation
To remove an element from the queue:

If Stack2 is empty:
Transfer all elements from Stack1 to Stack2. This reverses the order of the elements, so the element at the front of the queue will now be on top of Stack2.
Pop the top element from Stack2 to return it as the dequeued element.

If Stack2 is not empty:
Simply pop the top element from Stack2 (which is the front of the queue).

Step 3: Additional Operations
Peek: To see the front of the queue, just peek at the top of Stack2.
Empty: The queue is empty if both Stack1 and Stack2 are empty.


*/

import java.util.Stack;

public class QueueUsingStacks {

    // Define two stacks
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation (Push to stack1)
    public void enqueue(int data) {
        stack1.push(data);
    }

    // Dequeue operation (Pop from stack2)
    public int dequeue() {
        // If stack2 is empty, transfer elements from stack1 to stack2
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1; // Indicates the queue is empty
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // Pop from stack2 which is the front of the queue
        return stack2.pop();
    }

    // Peek operation (Look at the front element)
    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1; // Indicates the queue is empty
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Dequeue elements
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());

        // Enqueue more elements
        queue.enqueue(40);
        queue.enqueue(50);

        // Peek front element
        System.out.println("Peek: " + queue.peek());

        // Dequeue all elements
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());

        // Check if queue is empty
        System.out.println("Is Queue Empty? " + queue.isEmpty());
    }
}
