package agent4367;

import java.io.*;
import java.util.*;

public class Coverage {
	static HashSet<String> hash = new HashSet<String>();
		
	public static void visitedLine(String string) 
	{
		//adds the string from MethodVisitor4367
		hash.add(string);
		//System.out.println("String added to hash");
	}
	
	public static void writeToFile(FileWriter writer)
	{
		try 
		{		  
			//initializes a hash iterator and a buffer string to put the hash elements
		    Iterator<String> iterator = hash.iterator();  
            String buffer = "";		
            
            //the strings in the hash are added to the iterator along with a newline
            while (iterator.hasNext())
                buffer += iterator.next() + System.lineSeparator();  
            
            //once the iterator goes through the entire hash set, the writer writes the buffer into tmt-cov.txt and the hash is cleared
			writer.write(buffer);	
			System.out.println("written to file");
			hash.clear();
		}
		catch (Exception e) 
		{
			e.printStackTrace();	
		}
	}		
}