/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algotech.hw1.sum.split.array;

/**
 *
 * @author Pierre Jimenez
 */
public class SumEnds {
    private int[] tape;
    private int leftSum, rightSum;
    
    public SumEnds(int[] tape)
    {
        this.tape = tape;
        this.leftSum = 0;
        this.rightSum = 0;
    }
    
    public boolean hasEqualParts()
    {
        if(minSize()){
            leftSum = tape[0];
            sumRight();
            for(int p=1; p<tape.length-1; p++){
                if(rightSum == leftSum){
                    return true;
                }
                leftSum += tape[p];
                rightSum -= tape[p+1];
            }
            return false;
        }
        else{
            return false; 
        }                   
    }

    private boolean minSize()
    {
        return tape.length >= 3;
    }

    private void sumRight()
    {
        for(int i=2; i < tape.length; i++){
            rightSum += tape[i];
        }
    }   
    
}
