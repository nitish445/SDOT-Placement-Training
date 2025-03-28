/*
 Write a Java program to reverse a given string using a stack. The program should:

Take a string as input from the user.
Push each character onto a stack to store them in reverse order.
Pop characters from the stack to reconstruct the reversed string.
Print the reversed string as output.

Example Runs:
Enter a string: Hello
Reversed String: olleH

Enter a string: Java
Reversed String: avaJ
 */

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        System.out.println("Reversed String: " + reverseString(input));
    }

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        char[] ch= str.toCharArray();

        int n=ch.length;

        for(int i=0; i<n;i++){
            stack.push(ch[i]);
        }

        String reversestring="";

        while (!stack.isEmpty()) {
            reversestring+=stack.pop();
        }
        return reversestring;
    }
}
