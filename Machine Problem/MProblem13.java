/**
 * Name: Mark Edison Rosario
 * Section: BSCS 2-4
 * Subject: Data Structure and Algorithms
 * Language: Java
 *
 * Problem #1
 *
 * Write a program that implements BINARY TREE TRAVERSALS using preorder traversal,
 * inorder traversal, and postorder traversal to produce a linear arrangement of the nodes.
 * Program input consists of the root nodes and its left and right subtrees.
 * The output should list the following information:
 * 1. the left and right subtrees of each node (show null if none)
 * 2. the root of the tree
 * 3. preorder traversal
 * 4. inorder traversal
 * 5. postorder traversal
 *
 * Example
 * Input:
 * (A,B,E) (this means A is the root, B is the left subtree, and E is the right subtree)
 * (B,C,null) (this means B is the root, C is the left subtree, and there is no right subtree)
 * (C,null,D)
 * (E,F,H)
 * (F,null,G)
 * (H,I,J)
 *
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node {
    String value;
    Node left;
    Node right;

    Node(String value) {
        this.value = value;
        right = null;
        left = null;
    }
}

public class TreeProblem {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
        String x; String[] str;
        Node root = null, temp;
        Queue<Node> Q = new LinkedList<>();

        System.out.println("Binary Tree Traversals\n");
        System.out.println("Enter 'Z' to terminate input\nInput: ");
        x = input.nextLine();

        while(!x.toUpperCase().equals("Z")){
            str = x.replaceAll("[() ]", "").split("[,]");
            if(root == null){
                root = new Node(str[0]);
            }
            //BFS
            Q.add(root);
            while( !Q.isEmpty() && !Q.peek().value.equals(str[0])){
                temp = Q.remove();
                if(temp.left != null)
                    Q.add(temp.left);
                if(temp.right != null)
                    Q.add(temp.right);
            }
            temp = Q.remove();

            if(temp.value.equals(str[0])){
                if(!str[1].equals("null")){
                    temp.left = new Node(str[1]);
                }
                if(!str[2].equals("null")){
                    temp.right = new Node(str[2]);
                }
            }
            //System.out.println("1: " + str[0] +" 2: " + " 3: " + str[2]);
            x = input.nextLine();
        }//End of Input
        System.out.println("\n\nOutput:");
        System.out.println("Node  L-Subtree  R-Subtree");
        printTree(root);
        System.out.println("\nRoot of the Tree: " + root.value);
        System.out.print("\nPreorder Traversal:  ");
        printPreorder(root);
        System.out.print("\nInorder Traversal:   ");
        printInorder(root);
        System.out.print("\nPostorder Traversal: ");
        printPostorder(root);
    }//end Main method

    public static void printTree(Node root){
        Stack<Node> nodes = new Stack<>();
        Node temp;
        nodes.push(root);

        while(!nodes.isEmpty()){
            temp = nodes.pop();
            if(temp.right != null || temp.left != null){
                System.out.format("%-5s ",temp.value);

                if(temp.right != null)
                    nodes.push(temp.right);
                if(temp.left != null)
                    nodes.push(temp.left);
                if(temp.left != null) {
                    System.out.format("%-10s ", temp.left.value);
                }else{
                    System.out.format("%-10s ", "null");
                }

                if(temp.right != null){
                    System.out.format("%-9s ", temp.right.value);
                }else{
                    System.out.format("%-9s ", "null");
                }
                System.out.println();
            }
        }
    }//end printTree


    public static void printPreorder(Node root){
        System.out.print(root.value + " ");
        if(root.left != null)
            printPreorder(root.left);
        if(root.right != null)
            printPreorder(root.right);
    }

    public static void printInorder(Node root){
        if(root.left != null)
            printInorder(root.left);
        System.out.print(root.value + " ");
        if(root.right != null)
            printInorder(root.right);
    }

    public static void printPostorder(Node root){
        if(root.left != null)
            printPostorder(root.left);
        if(root.right != null)
            printPostorder(root.right);
        System.out.print(root.value + " ");
    }
}
