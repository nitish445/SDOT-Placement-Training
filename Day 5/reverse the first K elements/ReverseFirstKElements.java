/*
 To reverse the first K elements of a queue while keeping the remaining elements in the same order, we can follow these steps:

Approach:
Use a Stack: Push the first K elements into a stack to reverse their order.
Reinsert from Stack: Pop elements from the stack and enqueue them back into the queue.
Maintain Order: Move the remaining elements (n - K) from the front to the rear to maintain order.

Steps to Reverse the First K Elements of a Queue:
Step 1: Input and Initialization
Take input for the number of elements in the queue.
Take input for the value of K (number of elements to reverse).
Validate that K is within the correct range (1 ≤ K ≤ queue size).

Step 2: Push First K Elements into a Stack
Remove the first K elements from the queue and push them onto a stack.
This reverses their order (because stacks follow LIFO – Last In, First Out).

Step 3: Pop from Stack and Enqueue Back
Pop elements from the stack one by one and enqueue them back into the queue.
This places the K reversed elements at the front of the queue.

Step 4: Maintain Order of Remaining Elements
The remaining (n - K) elements are still in their original order.
Remove and enqueue them back to maintain their relative order.

Step 5: Output the Modified Queue
Print the queue after reversing the first K elements.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseFirstKElements {
     
    // Function to reverse the first K elements of a queue
    public static void reverseKElements(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k <= 0 || k > queue.size()) {
            System.out.println("Invalid value of K.");
            return;
        }

        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first K elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Pop from stack and enqueue back into queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Step 3: Move remaining elements to the rear
        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.add(queue.poll());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        
        // Taking user input
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        System.out.print("Enter K (number of elements to reverse): ");
        int k = scanner.nextInt();

        System.out.println("Original Queue: " + queue);
        
        // Reverse the first K elements
        reverseKElements(queue, k);
        
        System.out.println("Queue after reversing first " + k + " elements: " + queue);

        scanner.close();
    }
}
