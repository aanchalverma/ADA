import java.util.Scanner;
public class FloydsClass {
	 static final int max=20;
	 static int a[][];
	 static int n;
	 public static void main(String args[])
		{
		 a=new int[max][max];
		 readmatrix();
		 floyds();
		 printmatrix();
		}
	 static void readmatrix(){
		 System.out.println("enter no. of vertices");
		 Scanner scan=new Scanner(System.in);
		 n=scan.nextInt();
		 System.out.println("enter the cost adjacenecy matrix(999 for infinity):");
		 for(int i=1;i<=n;i++)
			 for(int j=1;j<=n;j++)
				 a[i][j]=scan.nextInt();
		 scan.close();
	 }
	 static void floyds(){
		 for(int k=1;k<=n;k++)
		 {
			 for(int i=1;i<=n;i++)
				 for(int j=1;j<=n;j++)
					 if((a[i][k]+a[k][j])<a[i][j])
						 a[i][j]=a[i][k]+a[k][j];
			 
		 }
	 }
	 static void printmatrix(){
		 System.out.println("all pair shortest path matrix is:");
		 for(int i=1;i<=n;i++){
			 for(int j=1;j<=n;j++)
				 System.out.print(a[i][j]+"\t");
		 	System.out.println("\n");
	 }
}
