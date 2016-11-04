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
	//   Reader f1=new Reader("/var/lib/jenkins/jobs/Shipfar_Job/lastSuccessful/log");
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("/var/lib/jenkins/jobs/Shipfar_Job/lastSuccessful/log"));
			int i;
			boolean bool=false;
			while(br.readLine()!=null)
			{
			    Pattern pattern = Pattern.compile("Results :"); 
			    Matcher matcher = pattern.matcher(br.readLine());
			    while (matcher.find()) 
			    {  
			    	System.out.println("++++++++++++++++++++++++");
				    bool=true;
			    }  
				b++;
				System.out.println(b);
			}
			System.out.println(bool);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
