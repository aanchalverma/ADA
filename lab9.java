import java.util.Scanner;
Public class PrimClass{
	final static int MAX=20;
	static int n;
	static int cost[][];
	static int parent[]=new int [9];
	static Scanner scan=new Scanner (System.in);
	public static void main(String[] args){
		Readmatrix();
		Prims();
	}
	static void ReadMatrix(){
		int i, j;
		cost=new int[MAX][MAX];
		System.out.println(“Enter the no. of nodes:”);
		n=scan.nextInt();
		System.out.println(“Enter the cost adjacency matrix:”);
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++){
				cost[i][j]=scan.nextInt();
				if(cost[i][j]==0)
					cost[i][j]=999;
			}
	}
	static void Prims(){
		int j, i, ne=1,min,mincost=0,a=0,b=0,u=0,v=0;
		int visited[]=new int[10];
		visited[1]=1;
		System.out.println(“The edges of minimum cost spanning tree are:”);
		while(ne<n){
			for(i=1,min=999;i<=n;i++)
				for(j=1;j<=n;j++)
					if(cost[i][j]<min){
						min=cost[i][j];
						a=u=i;
						b=v=j;
					}
			if(visited[u]==0 || visited[v]==0){
				System.out.println(ne+++”edge(“+a+”,”+b+”)=”+min);
				mincost+=min;
				visited[b]=1;
			}
			cost[a][b]=cost[b][a]=999;
		}
		System.out.println(“Minimum cost:”+mincost);
}
