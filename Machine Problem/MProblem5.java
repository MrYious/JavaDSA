/**
 * Name: Mark Edison Rosario
 * Section: BSCS 2-4
 * Subject: Data Structure and Algorithms
 * Language: Java
 *
 * Problem #5
 *
 * Write a program that takes an infix expression from standard input, evaluates it, and prints
 * the value. (Piping the output of your program from the previous exercise to this program
 * gives equivalent behavior to Evaluate
 *
 */

import java.util.Scanner;
import java.util.Stack;

public class MProblem5 {
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
        Stack<Integer> stackInt = new Stack<>();

        System.out.println("Please separate each number, operator and parentheses using SPACE [ex. A * B + C - ( D - E ) ]");
        System.out.print("Enter an Infix expression : ");
        String exp = input.nextLine();
        String[] arr = exp.split(" ");
        exp = "";

        //Convert Infix Expression into a Postfix Expression
        for (String s : arr) {
            if (s.equals("(")) {
                stackOperator.push(s);
            }else if (s.equals(")")) {
                while (!stackOperator.isEmpty() && !stackOperator.peek().equals("(")) {
                    exp = exp + stackOperator.pop();
                    exp = exp + " ";
                }
                stackOperator.pop();
            }else if (isOperand(s)) {
                if (!stackOperator.isEmpty()) {
                    while (!stackOperator.isEmpty() && level(stackOperator.peek()) >= level(s)) {
                        exp = exp + stackOperator.pop();
                        exp = exp + " ";
                    }
                }
                stackOperator.push(s);
            }else {
                exp = exp + s;
                exp = exp + " ";
            }
        }

        while (!stackOperator.isEmpty()) {
            exp = exp + stackOperator.pop();
            exp = exp + " ";
        }

        //Evaluate the Postfix Expression
        arr = exp.split(" ");
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
        System.out.print("\nThe result of the expression is: ");
        System.out.print(stackInt.pop());
        System.out.println();
    }
}
