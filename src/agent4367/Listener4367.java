package agent4367;
 
import java.io.*;
import org.junit.runner.notification.RunListener;
import org.junit.runner.Description;
import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;
import agent4367.Coverage;

public class Listener4367 extends RunListener
{
	static FileWriter writer;
	
	//address of the file in the UTD Unix server under my (Adrian Dizon's) personal drive
	//String fileAddress = "/home/010/a/am/amd160530/4367/Project/stmt-cov.txt";
	
	//if running on windows, I guess comment out the first fileAddress init and use the 2nd one
	String fileAddress = "stmt-cov.txt";
	
	//Runs at the beginning of the run, called by the pom file
	public void testRunStarted(Description description) throws Exception 
	{
		//System.out.println("about to try creating input file");
		
		//initializes the file to be written to
		File output = new File(fileAddress);
			
		if (output.exists())
			output.delete();
		else
			output.createNewFile();
			
		//System.out.println("stmt-cov.txt has been created");
			
		//designates the file as the file that writer will write to
		writer = new FileWriter(fileAddress,false);
	}	
	
	//Called when a test starts
	public void testStarted(Description description) throws Exception
	{
		writer.write("Testing " + description.getClassName()+ ":" + description.getMethodName() + System.lineSeparator());
		//System.out.println("testStarted has been executed");
	}
	
	//uses StatementCoverage's writeIntoFile method to write the hashset into the stmt-cov.txt file initialized earlier
	public void testFinished(Description description) throws Exception
	{
		Coverage.writeToFile(writer);
		//System.out.println("testFinished has been executed, Coverage has been called");
	}
		
	//Called when all tests have finished. Closes the writer
	public void testRunFinished(Result result) throws Exception
	{
		writer.close();
		//System.out.println("testRunFinished has been executed");
	}	
}