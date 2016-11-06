import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Readlogs 	
{
	public static void main(String args[])
	{
		int i=0;
		String line=null;
		String job_name[]={"CRE_Job", "Score_Job", "Shipfar_Job", "Shiptrack_Job"};
	/*	System.out.println("What do you want to do ?");
		System.out.println("1. Enter job name to read logs.");
		System.out.println("2. Exit.");
		b=sc.nextInt();
		switch(b)
		{
				case 1 : System.out.print("Enter a valid job name.");
				Scanner st=new Scanner(System.in);
				job_name=st.next();    */
		x: for(i=0;job_name[i]!=null;i++)
		{
			System.out.println(job_name[i]);	
			try
			{
				BufferedReader br=new BufferedReader(new FileReader("/var/lib/jenkins/jobs/"+job_name[i]+"/lastSuccessful/log"));
				while((line=br.readLine())!=null)
				{
			    	Pattern pattern = Pattern.compile("Tests run:"); 
			    	Matcher matcher = pattern.matcher(line);
			    /*	if (bool==true)
			    	{
					bool=false;
					//System.out.println("*******************************************************");
					//return;
			    	}   */
			    	while (matcher.find()) 
			    	{  
					System.out.println(line);
					break x;
			    	}  
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			/*	break;
			case 2: return;
			case 3: System.out.println("Enter valid input!");  */
		}
	}
}
