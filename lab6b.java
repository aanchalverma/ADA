import java.util.Scanner;
class Kobject{
	float w;
	float p;
	float r;
}
public class KnapsackGreedy {
	static final int max=20;
	static int n;
	static float M;
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter no. of objects");
		n=scan.nextInt();
		Kobject [] obj=new Kobject[n];
		for(int i=0;i<n;i++)
			obj[i]=new Kobject();
		readobjects(obj);
		knapsack(obj);
		scan.close();
	}
	static void readobjects(Kobject obj[])
	{
		Kobject temp=new Kobject();
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the max capacity of knapsack:");
		M=scan.nextFloat();
		System.out.println("enter weights:");
		for(int i=0;i<n;i++)
			obj[i].w=scan.nextFloat();
		System.out.println("enter profit:");
		for(int i=0;i<n;i++)
			obj[i].p=scan.nextFloat();
		for(int i=0;i<n;i++)
			obj[i].r=obj[i].p/obj[i].w;
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-1-i;j++)
				if (obj[j].r<obj[j+1].r){
					temp=obj[j];
					obj[j]=obj[j+1];
					obj[j+1]=temp;
				}
		scan.close();
	}
	static void knapsack(Kobject kobj[])
	{
		float x[]=new float[max];
		float totalprofit=0;
		int i;
		float U;
		U=M;
		for(i=0;i<n;i++)
			x[i]=0;
		for(i=0;i<n;i++)
		{
			if(kobj[i].w>U)
				break;
			else{
				x[i]=1;
				totalprofit=totalprofit+kobj[i].p;
				U=U-kobj[i].w;
			}
		}
		System.out.println("i="+i);
		if(i<n)
			x[i]=U/kobj[i].w;
		totalprofit=totalprofit+(x[i]*kobj[i].p);
		System.out.println("the soultion vector x[]:");
		for(i=0;i<n;i++)
			System.out.print(x[i]+" ");
			System.out.println("\n total profit is:"+ totalprofit);
		
	}
}
