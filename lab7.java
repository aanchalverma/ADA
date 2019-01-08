import java.util.Scanner;
public class Dijkstrasclass {
	final static int MAX=20;
	final static int infinity=999;
	static int n;
	static int a[][];
	static Scanner input =new Scanner(System.in);
	public static void main(String []args){
		ReadMatrix();
		int s=0;
		System.out.println("enter the starting vertex");
		s=input.nextInt();
		Dijkstra(s);
	}
	static void ReadMatrix()
	{
		a=new int[MAX][MAX];
		System.out.println("enter the no of vertices");
		n=input.nextInt();
		System.out.println("enter the cost adjacency matrix");
		for(int i=1;i<+n;i++)
			for(int j=1;j<=n;j++)
				a[i][j]=input.nextInt();
	}
	static void Dijkstra(int s)
	{
		int S[]=new int[MAX];
		int d[]=new int[MAX];
		int u,v;
		int i;
		for(i=1;i<=n;i++){
			S[i]=0;
			d[i]=a[s][i];
		}
		S[s]=1;
		d[s]=1;
		i=2;
		while(i<=n)
		{
			u=Extract_Min(S,d);
			S[u]=1;
			i++;
			for(v=1;v<=n;v++)
			{
				if(((d[u]+a[u][v]<d[v])&&(S[v]==0)))
					d[v]=d[u]+a[u][v];
			}
		}
		for(i=1;i<=n;i++)
			if(i!=s)
				System.out.println(i+":"+d[i]);
	}
	static int Extract_Min(int S[],int d[])
	{
		int i,j=1,min;
		min=infinity;
		for(i=1;i<=n;i++)
		{
			if((d[i]<min)&&(S[i]==0))
			{
				min=d[i];
				j=i;
			}
		}
		return(j);
	}
}
