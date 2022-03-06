/**
 * Name: Mark Edison Rosario
 * Section: BSCS 2-4
 * Subject: Data Structure and Algorithms
 * Language: Java
 *
 * Problem #7
 *
 * Write a program EvaluatePostfix that takes a postfix expression from standard input,
 * evaluates it, and prints the value.
 *
 */

import java.util.Scanner;
import java.util.Stack;

public class MProblem7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> stackInt = new Stack<>();

        System.out.println("Separate each number and operator using SPACE to distinguish different numbers with multiple digits");
        System.out.print("Enter a Postfix expression : ");
        String exp = input.nextLine();
        String[] arr = exp.split(" ");


        for (String s : arr) {
            switch (s) {
                case "+":
                    stackInt.push(stackInt.pop() + stackInt.pop());
                    break;
                case "-":
                    stackInt.push(stackInt.pop() - stackInt.pop());
                    break;
                case "*":
                    stackInt.push(stackInt.pop() * stackInt.pop());
                    break;
                case "/":
                    stackInt.push(stackInt.pop() / stackInt.pop());
                    break;
                default:
                    stackInt.push(Integer.parseInt(s));
                    break;
            }
        }
        System.out.print("\nThe result of the Postfix expression is: ");
        System.out.print(stackInt.pop());
        System.out.println();
    }
}
