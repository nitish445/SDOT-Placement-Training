/*
Write a Java program that checks whether a given string of parentheses is valid. A string is considered valid if:
Each opening bracket ((, {, [) has a corresponding and correctly ordered closing bracket (), }, ]).
No unmatched brackets exist.
The brackets are nested correctly.

The program should:
Accept an input string of brackets from the user.
Implement a function isValid(String s) that returns true if the input string is valid, otherwise false.
Print the result.

Example Runs:
Enter a string: {[()]}
Is valid? true

Enter a string: {[(])}
Is valid? false
 */


import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        int n = ch.length;

        for (int i = 0; i < n; i++) {
            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                stack.push(ch[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                
                if ((ch[i] == ')' && top != '(') ||
                    (ch[i] == '}' && top != '{') ||
                    (ch[i] == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();


        System.out.println("Is valid? " + isValid(input));
    }
}
