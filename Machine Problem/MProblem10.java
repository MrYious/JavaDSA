/**
 * Name: Mark Edison Rosario
 * Section: BSCS 2-4
 * Subject: Data Structure and Algorithms
 * Language: Java
 *
 * Problem #1
 *
 * The Josephus problem is the following game: N people, numbered 1 to N, are sitting in a
 * circle. Starting at person 1, a hot potato is passed. After M passes, the person holding the
 * hot potato is eliminated, the circle closes ranks, and the game continues with the person
 * who was sitting after the eliminated person picking up the hot potato. The last remaining
 * person wins. Thus, if M = 0 and N = 5, players are eliminated in order, and player 5 wins.
 * If M = 1 and N = 5, the order of elimination is 2, 4, 1, 5.
 *
 *      a) Write a program to solve the Josephus problem for general values of M and N. Try
 *              to make your program as efficient as possible. Make sure you dispose of cells.
 *      b) What is the running time of your program?
 *      c) If M = 1, what is the running time of your program? How is the actual speed affected
 *      by the delete routine for large values of N (N > 100,000)?
 *
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MProblem1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N,  //People
            M;  //Passes / Interval

        System.out.print("Enter the value of N: ");
        N = input.nextInt();
        System.out.print("Enter the value of M: ");
        M = input.nextInt();

        long startTime = System.nanoTime();

        //Solve using Queue
        Queue<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            list.add(i);
        }
        while(list.size() != 1){
            for(int i = 0; i < M; i++){
                list.add(list.remove());
            }
            list.remove();
        }

        System.out.println("The last is: " + list.remove());

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("\nExecution time in nanoseconds  : " + timeElapsed);
        System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
    }
}
