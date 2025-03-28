/*
You are given an array prices[] where prices[i] represents the price of a stock on the i-th day. Your task is to compute the stock span for each day.
The stock span for a day is defined as the number of consecutive days (including the current day) for which the stock price was less than or equal to its price on that day.

Input
And value of n;
A single list of integers prices[] where 1 ≤ len(prices) ≤ 10⁵ and 1 ≤ prices[i] ≤ 10⁶.

Output
A list of integers representing the stock span for each day.

Example 1
Input:
prices = [100, 80, 60, 70, 60, 75, 85]
Output:
[1, 1, 1, 2, 1, 4, 6]

Example 2
Input:
prices = [10, 4, 5, 90, 120, 80]
Output:
[1, 1, 2, 4, 5, 1]

 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of days: ");
        int n = scanner.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int[] result = calculateSpan(prices);

        System.out.println("Stock Span: " + Arrays.toString(result));

        scanner.close();
    }
}
