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
		String job_name=null;	
		int b=0;
		System.out.println("What do you want to do ?");
		System.out.println("1. Enter job name to read logs.");
		System.out.println("2. Exit.");
		Scanner sc=new Scanner(System.in);
		b=sc.nextInt();
		switch(b)
		{
				case 1 : System.out.print("Enter a valid job name.");
				sc=new Scanner(System.in);
				job_name=sc.next();
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("/var/lib/jenkins/jobs/"+job_name+"/lastSuccessful/log"));
			int i;
			boolean bool=false;
			String r=null;
			while(br.readLine()!=null)
			{
			    Pattern pattern = Pattern.compile("Results"); 
			    r=br.readLine();
			    Matcher matcher = pattern.matcher(br.readLine());
			    if (bool)
			    {
			        System.out.println(r);
				return;
			    }
			    while (matcher.find()) 
			    {  
				    bool=true;
			    }  
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				break;
			case 2: return;
				break;
			case 3: System.out.println("Enter valid input!");
		}
	}
}
