import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Readlogs 	
{
	public static void main(String args[])
	{
		int b;
	//   Reader f1=new Reader("/var/lib/jenkins/jobs/Shipfar_Job/lastSuccessful/log");
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("/var/lib/jenkins/jobs/Shipfar_Job/lastSuccessful/log"));
			int i;
			while(br.readLine()!=null)
			{
				Pattern pattern = Pattern.compile(br.readLine()); 
			    Matcher matcher = pattern.matcher("Results :");
			    boolean found = false;  
			    while (matcher.find()) 
			    {  
			    	System.out.println("++++++++++++++++++++++++");  
			        found = true;  
			    }  
			    if(!found)
			    {  
			    	System.out.println("No match found.");  
			    }  
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
