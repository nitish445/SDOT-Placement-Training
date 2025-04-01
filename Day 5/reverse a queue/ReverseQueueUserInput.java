/*Java program to reverse a queue using recursion:

Steps:
Take input from the user for the number of elements.
Add elements to the queue.
Reverse the queue using recursion.
Print the reversed queue.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueueUserInput {
    
    // Function to reverse the queue using recursion
    public static void reverseQueue(Queue<Integer> queue) {
        // Base case: If queue is empty, return
        if (queue.isEmpty()) {
            return;
        }
        
        // Remove front element
        int front = queue.poll();
        
        // Recursively reverse the remaining queue
        reverseQueue(queue);
        
        // Add the removed element back at the rear
        queue.add(front);
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

        System.out.println("Original Queue: " + queue);
        
        // Reverse the queue
        reverseQueue(queue);
        
        System.out.println("Reversed Queue: " + queue);

        scanner.close();
    }
}
