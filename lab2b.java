import java.util.Scanner;
import java.util.StringTokenizer;
public class Customer
{
	public static void main(String []args)
	{
		String name;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Name and date of birth in the format <Name,DD/MM/YYYY>");
		name=scan.next();
		StringTokenizer st=new StringTokenizer(name,"/");
		int count=st.countTokens();
		for(int i=0;i<=count&&st.hasMoreTokens();i++)
		{
			System.out.print(st.nextToken());
			if(i<count)
			System.out.print(",");
		}
	}
}
