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
		Scanner sc=new Scanner(System.in);
		int b=0;
		String job_name[]={"CRE_Job", "Score_Job", "Shipfar_Job", "Shiptrack_Job", "TaxEngine_Job"};
	/*	System.out.println("What do you want to do ?");
		System.out.println("1. Enter job name to read logs.");
		System.out.println("2. Exit.");
		b=sc.nextInt();
		switch(b)
		{
				case 1 : System.out.print("Enter a valid job name.");
				Scanner st=new Scanner(System.in);
				job_name=st.next();    */
	//	for(int i=0;job_name[i]!=null;i++)
		{
			System.out.println(job_name[0]);	
			try
			{
				BufferedReader br=new BufferedReader(new FileReader("/var/lib/jenkins/jobs/"+job_name[0]+"/lastSuccessful/log"));
				boolean bool=false;
				String r=null;
				while(br.readLine()!=null)
				{
			    	Pattern pattern = Pattern.compile("Tests run:"); 
			    	r=br.readLine();
										System.out.println(r);
			    	Matcher matcher = pattern.matcher(br.readLine());
			    	if (bool==true)
			    	{
					System.out.println(r);
					return;
			    	}
			    	while (matcher.find()) 
			    	{  
				    bool=true;
					System.out.println(bool);
			    	}  
				}
				System.out.println(bool);
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
