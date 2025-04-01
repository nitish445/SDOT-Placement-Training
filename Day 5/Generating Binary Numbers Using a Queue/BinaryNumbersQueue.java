/*
Generating Binary Numbers Using a Queue in Java

Approach:
Use a queue to store binary numbers in string format.
Start with "1" (smallest binary number greater than zero).
Iterate N times to generate the first N binary numbers:
Dequeue the front element.
Print it as the next binary number.
Enqueue its next two binary numbers:
Append "0" to the dequeued number.
Append "1" to the dequeued number.
Repeat until N binary numbers are generated.

Steps to Generate Binary Numbers Using a Queue
Step 1: Initialize the Queue
Start by adding the first binary number, "1", to the queue.
Queue = ["1"]

Step 2: Generate N Binary Numbers
Loop through the process N times to generate the binary numbers.
For each iteration, dequeue the front element (a binary number).
Print the dequeued element as part of the result.

Step 3: Enqueue Next Binary Numbers
After dequeuing a binary number:
Append "0" to the dequeued binary number and enqueue it back into the queue.
Append "1" to the dequeued binary number and enqueue it back into the queue.
This ensures the next possible binary numbers are generated in sequence.

Step 4: Repeat the Process
Continue the process for N iterations to generate N binary numbers.

Step 5: Output the Binary Numbers
After completing the loop, the first N binary numbers will have been printed in sequence.


*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryNumbersQueue {

    // Function to generate N binary numbers using a queue
    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");  // Start with "1"

        for (int i = 0; i < n; i++) {
            String front = queue.poll(); // Get the front element
            System.out.print(front + " "); // Print the binary number

            // Enqueue next two binary numbers
            queue.add(front + "0");
            queue.add(front + "1");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the number of binary numbers to generate: ");
        int n = scanner.nextInt();

        System.out.println("First " + n + " binary numbers:");
        generateBinaryNumbers(n);

        scanner.close();
    }
}
