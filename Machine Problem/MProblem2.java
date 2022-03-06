/**
 * Name: Mark Edison Rosario
 * Section: BSCS 2-4
 * Subject: Data Structure and Algorithms
 * Language: Java
 *
 * Problem #2
 *
 * Write a program that will continuously accept a character and store in a stack until a vowel
 * is entered, then display the letters in reverse order of their arrival.
 *
 */

import java.util.Scanner;
import java.util.Stack;

public class MProblem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Character> chars = new Stack<>();

        System.out.print("Enter a character: ");
        char c = input.next().charAt(0);


        while(("aeiouAEIOU".indexOf(c)) < 0){   //Check if it is one of the vowels
            chars.push(c);

            System.out.print("Enter a character: ");
            c = input.next().charAt(0);
        }

        System.out.print("\nLetters:  ");
        while(!chars.isEmpty()){
            System.out.print(chars.pop() + " ");
        }
        System.out.println();
    }
}
