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
package algotech.hw1.sum.split.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author piecar
 */
public class tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader bf = null;
        
        FileOps f = new FileOps();
        try
        {
            bf = f.getBFContents();
        } catch (IOException e)
        {
            display(e.toString(), "File not found ....");
        }
        
        ReaderOps ro = new ReaderOps(bf);
        
        try {
            while(ro.hasItem())
            {
                ro.toArray();
                int[] tape = ro.getTape();
                SumEnds mySumEnds = new SumEnds(tape);
                System.out.println(mySumEnds.hasEqualParts());
            }
        } catch (IOException ex) {
            Logger.getLogger(tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    static void display(String msg, String s)
    {
	 JOptionPane.showMessageDialog(null, msg, s, JOptionPane.ERROR_MESSAGE);
    }
    
}
