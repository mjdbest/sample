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
		int b=0;
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("/var/lib/jenkins/jobs/Shipfar_Job/lastSuccessful/log"));
			int i;
			boolean bool=false;
			String r="xyz";
			while(br.readLine()!=null)
			{
			    Pattern pattern = Pattern.compile("Results"); 
			    r=br.readLine();
			    Matcher matcher = pattern.matcher(br.readLine());
			    while (matcher.find()) 
			    {  
			      System.out.println(r);
			//	System.out.println("+++++++++++");
				return ;
			    }  
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
