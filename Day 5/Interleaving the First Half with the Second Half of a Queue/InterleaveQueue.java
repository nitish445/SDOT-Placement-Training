/*
Interleaving the First Half with the Second Half of a Queue

Approach:
Find the Midpoint: Determine the first and second halves of the queue.
Use a Stack or Another Queue:
Store the first half in a separate queue.
Interleave elements from both halves alternately.
Reinsert into Original Queue: Maintain order while interleaving.

Steps to Interleave the First Half with the Second Half of a Queue
Step 1: Input and Validation
Take input for the number of elements in the queue.
Ensure that the number of elements is even (interleaving requires equal halves).

Step 2: Split the Queue into Two Halves
Find the midpoint: halfSize = queue.size() / 2.
Store the first half in a separate queue (firstHalf).

Step 3: Interleave Elements
Alternately enqueue one element from the first half and one from the second half into the original queue.

Step 4: Output the Interleaved Queue
Print the queue after interleaving.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InterleaveQueue {
    
    // Function to interleave first half with second half
    public static void interleaveQueue(Queue<Integer> queue) {
        if (queue.size() % 2 != 0) {
            System.out.println("Queue size should be even for perfect interleaving.");
            return;
        }

        int halfSize = queue.size() / 2;
        Queue<Integer> firstHalf = new LinkedList<>();

        // Step 1: Store the first half in a separate queue
        for (int i = 0; i < halfSize; i++) {
            firstHalf.add(queue.poll());
        }

        // Step 2: Interleave elements from firstHalf and remaining queue
        while (!firstHalf.isEmpty()) {
            queue.add(firstHalf.poll()); // Add from first half
            queue.add(queue.poll()); // Add from second half
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        
        // Taking user input
        System.out.print("Enter the number of elements (even number): ");
        int n = scanner.nextInt();
        
        if (n % 2 != 0) {
            System.out.println("Please enter an even number of elements.");
            return;
        }

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        System.out.println("Original Queue: " + queue);
        
        // Interleave the queue
        interleaveQueue(queue);
        
        System.out.println("Interleaved Queue: " + queue);

        scanner.close();
    }
}
