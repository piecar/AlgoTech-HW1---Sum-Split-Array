/*
A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.

Any element P of array splits this tape into two parts: A[0], A[1], ..., A[P − 1] and A[P + 1], ..., A[N − 1].

Determine if an element exists which the sum of the elements on its left is equal to the sum of the elements on its right.

In other words, find an element P of array such that:

A[0] + A[1] + ... + A[P − 1] = A[P + 1] + ... + A[N − 1]

For example, given:

A[0] = 1
A[1] = 2
A[2] = 3
A[3] = 3
Your program should print YES, since A[0] + A[1] = A[3].
 */
package algotech.hw1.sum.split.array.SingleFile;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pierre Jimenez
 */
public class Solution {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> tape = new ArrayList();
        ArrayList<Boolean> answers = new ArrayList();
        
        System.out.print("STDIN: ");
        Scanner scan = new Scanner(System.in);
        int numTests = scan.nextInt();
        for(int i=1; i<=numTests; i++){
            tape = scanToArray(scan);
            answers.add(SumEnds(tape));         
        }
        
        for(int i=1; i<=numTests; i++){
            System.out.println("OUT " + i +": " + answers.get(i-1));         
        }
        
        
              
        
    }

    private static boolean SumEnds(ArrayList<Integer> tape) {
        int leftSum = 0, rightSum =0;
        
        if(tape.size() >= 3){
            leftSum = tape.get(0);
            rightSum = sumRight(tape, rightSum);
            for(int p=1; p<tape.size()-1; p++){
                if(rightSum == leftSum){
                    return true;
                }
                leftSum += tape.get(p);
                rightSum -= tape.get(p+1);
            }
            return false;
        }
        else{
            return false; 
        }  
    }

    private static ArrayList<Integer> scanToArray(Scanner scan) {
        ArrayList<Integer> tape = new ArrayList();
        
        int numElem = scan.nextInt();
        for(int i=0; i<numElem; i++) {
            Integer num = scan.nextInt();
            tape.add(num);
        }
        return tape;
    }

    private static int sumRight(ArrayList<Integer> tape, int rightSum) {
        for(int i=2; i < tape.size(); i++){
            rightSum += tape.get(i);
        }
        return rightSum;
    }
    
}
