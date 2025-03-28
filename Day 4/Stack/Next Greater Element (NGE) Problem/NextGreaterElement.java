/*
Write a Java program to find the Next Greater Element (NGE) for each element in an array.

Problem Description:
For each element in the given array, find the first greater element to its right. If there is no greater element, return -1.

Input:
An integer N representing the number of elements in the array.
N space-separated integers representing the elements of the array.

Output:
An array of N integers where each element is replaced by its Next Greater Element (NGE).

Example Runs:
Input 1:
Enter the number of elements: 5
Enter the elements: 4 5 2 25 7
Output 1:
Next Greater Elements: [5, 25, 25, -1, -1]

Input 2:
Enter the number of elements: 4
Enter the elements: 13 7 6 12
Output 2:
mathematica
Copy
Edit
Next Greater Elements: [-1, 12, 12, -1]

 */

import java.util.Stack;

public class NextGreaterElement {
    public static int[] findNextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
         int[] arr = {4, 5, 2, 25, 7}; // Directly given array

         // Get the result array
        int[] ngeArray = findNextGreaterElement(arr);

         // Print the output array
        System.out.print("Next Greater Elements: [");
        for (int i = 0; i < ngeArray.length; i++) {
            System.out.print(ngeArray[i]);
            if (i < ngeArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
