/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algotech.hw1.sum.split.array;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Pierre Jimenez
 */
public class ReaderOps
{
    //Fields
    private BufferedReader bf;
    private String aLine;
    private int[] tape;
    
    ReaderOps(BufferedReader bf)
    {
        this.bf = bf;
    }
    
    public void toArray()
    {
        if(!aLine.equals("")) // checks for empty line
        {
            aLine = aLine.trim();
            tape = new int[aLine.length()/2 + 1];
            for(int i=0, j=0; i <= aLine.length(); i=i+2, j++)
            {
                tape[j] = Character.getNumericValue(aLine.charAt(i));
            }
        }
        
    }
    
    public boolean hasItem() throws IOException
    {
        aLine = bf.readLine();
        if (aLine == null)
        {
            bf.close();
            return false;
        }
        return true;
    }
    
    public int[] getTape()
    {
        return tape;           
    }
            
    
}
