/**
 * Name: Mark Edison Rosario
 * Section: BSCS 2-4
 * Subject: Data Structure and Algorithms
 * Language: Java
 *
 * Problem #1
 *
 * Write a program that will continuously accept a
 * character and store in a stack until letter ‘Z’ is entered.
 *
 */

import java.util.Scanner;
import java.util.Stack;

public class MProblem1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Character> chars = new Stack<>();

        System.out.print("Enter a character: ");
        char c = input.next().charAt(0);

        while(c != 'Z'){
            chars.push(c);

            System.out.print("Enter a character: ");
            c = input.next().charAt(0);
        }
    }
}
