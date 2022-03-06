/**
 * Name: Mark Edison Rosario
 * Section: BSCS 2-4
 * Subject: Data Structure and Algorithms
 * Language: Java
 *
 * Problem #4
 *
 * Write a program that takes from standard input an expression without left parentheses
 * and prints the equivalent infix expression with the parentheses inserted. For example,
 * given the input:
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * your program should print
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 *
 */

import java.util.Scanner;
import java.util.Stack;

public class MProblem4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        String str1, str2, strOpt;

        System.out.println("Please separate each number, operator and parentheses using SPACE [ex. 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) ]");
        System.out.print("Enter the expression : ");
        String exp = input.nextLine();
        String[] arr = exp.split(" ");

        //Stack all elements until a ")" is found
        //Then combine all the last 3 elements from the stack into one element then push it back again
        for(String s: arr){
            if(!s.equals(")")){
                stack.push(s);
            }else{
                str2 = stack.pop();
                strOpt = stack.pop();
                str1 = stack.pop();
                stack.push("( " + str1 + " " + strOpt + " " + str2 + " )");
            }
        }

        while(stack.size() != 1){
            str2 = stack.pop();
            str1 = stack.pop();
            stack.push(str1 + " " + str2);
        }

        System.out.println("\nThe fixed expression is:    " + stack.pop());
    }
}
