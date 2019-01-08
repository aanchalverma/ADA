import java.util.Scanner;
public class KnapsackDP {
	static final int max=100;
	static int w[];
	static int p[];
	static int n;
	static int M;
	static int v[][];
	static int keep[][];
	public static void main(String args[])
	{
		w=new int[max];
		p=new int[max];
		v=new int[max][max];
		keep=new int[max][max];
		int optsoln;
		readobjects();
		for(int i=0;i<=M;i++)
			v[0][i]=0;
		for(int i=0;i<=n;i++)
			v[i][0]=0;
		optsoln=knapsack();
		System.out.println("optimal solution="+optsoln);
	}
	static int knapsack()
	{                                                               
		int r;
		for(int i=1;i<=n;i++)
			for(int j=0;j<=M;j++)
				if ((w[i]<=j)&&(p[i]+v[i-1][j-w[i]]>v[i-1][j]))
				{
					v[i][j]=p[i]+v[i-1][j-w[i]];
					keep[i][j]=1;
					
				}
				else{
					v[i][j]=v[i-1][j];
					keep[i][j]=0;
				}
		r=M;
		System.out.println("items=");
		for(int i=n;i>0;i--)
			if(keep[i][r]==1)
			{
				System.out.println(i+" ");
				r=r-w[i];
				
				}
		System.out.println();
		return v[n][M];
		
	}
	static void readobjects(){
		Scanner scan=new Scanner(System.in);
		System.out.println("knapsack problem-Dynamic programming solution:");   
		System.out.println("enter the capacity of knapsack");
		M=scan.nextInt();
		System.out.println("enter the no. of objects:");
		n=scan.nextInt();
		System.out.println("enter the weights:");
		for(int i=1;i<=n;i++)
			w[i]=scan.nextInt();
		System.out.println("enter the profits:");
		for(int i=1;i<=n;i++){
			p[i]=scan.nextInt();
		}
		scan.close();
	}
}


