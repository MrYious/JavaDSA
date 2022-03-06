/**
 * Name: Mark Edison Rosario
 * Section: BSCS 2-4
 * Subject: Data Structure and Algorithms
 * Language: Java
 *
 * Problem #3
 *
 * Write a program that will continuously accept a character and store in a stack until an
 * asterisk (*) is entered, and then display the third to the last character entered.
 *
 */

import java.util.Scanner;
import java.util.Stack;

public class MProblem3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Character> chars = new Stack<>();

        System.out.print("Enter a character: ");
        char c = input.next().charAt(0);

        while(c != '*'){
            chars.push(c);

            System.out.print("Enter a character: ");
            c = input.next().charAt(0);
        }

        System.out.print("\nThird to the last character:  ");
        chars.pop();
        chars.pop();
        System.out.print(chars.pop());
        System.out.println();
    }
}
