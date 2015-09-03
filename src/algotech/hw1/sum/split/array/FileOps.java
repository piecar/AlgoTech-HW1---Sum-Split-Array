package algotech.hw1.sum.split.array;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author OWNER
 */
public class FileOps
{
    File f;
    
    public FileOps()
    {
       JFileChooser choose = new JFileChooser(".");
       int status = choose.showOpenDialog(null);

       try
       {
       		if (status != JFileChooser.APPROVE_OPTION)
                    throw new IOException();

       		f = choose.getSelectedFile();

       		if (!f.exists()) throw new FileNotFoundException();
       }
       catch(FileNotFoundException e)
       {
       		display(e.toString(), "File not found ....");
       }
       catch(IOException e)
       {
       		display(e.toString(),  "Approve option was not selected");
       }

   }
    BufferedReader getBFContents() throws FileNotFoundException
    {
        BufferedReader bf = new BufferedReader(new FileReader(f));
        return bf;
    }
   void display(String msg, String s)
   {
	 JOptionPane.showMessageDialog(null, msg, s, JOptionPane.ERROR_MESSAGE);
   }
    
}
