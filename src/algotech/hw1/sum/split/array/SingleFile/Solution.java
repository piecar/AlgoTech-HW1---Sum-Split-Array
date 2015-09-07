/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algotech.hw1.sum.split.array.SingleFile;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author piecar
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Integer> tape = scanToArray();
        
        boolean answer = SumEnds(tape);
        
        System.out.println("STDOUT: " + answer);
        
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

    private static ArrayList<Integer> scanToArray() {
        ArrayList<Integer> tape = new ArrayList();
        System.out.print("STDIN: ");
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt())
        {
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
