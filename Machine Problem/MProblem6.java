/**
 * Name: Mark Edison Rosario
 * Section: BSCS 2-4
 * Subject: Data Structure and Algorithms
 * Language: Java
 *
 * Problem #6
 *
 * Write a program InfixToPostfix that converts an arithmetic expression from infix to postfix.
 *
 */

import java.util.Scanner;
import java.util.Stack;

public class MProblem6 {
    static boolean isOperand( String input ) {
        switch (input) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
                return true;
            default:
                return false;
        }
    }
    static int level(String op) {
        switch (op) {
            case "(":
            case ")":
                return -1;
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
            case "^":
                return 2;
            default:
                throw new IllegalArgumentException("Operator unknown: " + op);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<String> stackOperator = new Stack<>();

        System.out.println("Please separate each number, operator and parentheses using SPACE [ex. A * B + C - ( D - E ) ]");
        System.out.print("Enter an Infix expression : ");
        String exp = input.nextLine();
        String[] arr = exp.split(" ");

        System.out.print("\nThe Postfix expression is: ");

        for (String s : arr) {
            if (s.equals("(")) {
                stackOperator.push(s);
            }else if (s.equals(")")) {
                while (!stackOperator.isEmpty() && !stackOperator.peek().equals("(")) {
                    System.out.print(stackOperator.pop() + " ");
                }
                stackOperator.pop();
            }else if (isOperand(s)) {
                if (!stackOperator.isEmpty()) {
                    while (!stackOperator.isEmpty() && level(stackOperator.peek()) >= level(s)) {
                        System.out.print(stackOperator.pop() + " ");
                    }
                }
                stackOperator.push(s);
            }else {
                System.out.print(s + " ");
            }
        }

        while (!stackOperator.isEmpty()) {
            System.out.print(stackOperator.pop() + " ");
        }
        System.out.println();System.out.println();
    }
}
