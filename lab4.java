import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class QuickSortComplexity 
{
	static final int MAX=1000000;
	static int[] a=new int[MAX];
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter maximum array size");
		int n=input.nextInt();
		Random random=new Random();
		System.out.println("Enter the array elements");
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		//a[i]=random.nextInt(1000);
		a=Arrays.copyOf(a,n);
		//QuickSortAlgorithm(0,n-1);
		System.out.println("Input Array:");
		for(int i=0;i<n;i++)
			System.out.printf(a[i]+ " ");
		System.out.println();
		long startTime=System.nanoTime();
		QuickSortAlgorithm(0,n-1);
		long stopTime=System.nanoTime();
		long elapsedTime=stopTime-startTime;
		System.out.printf("\nsorted array:");
		for(int i=0;i<n;i++)
			System.out.printf(a[i]+" ");
		System.out.println();
		System.out.println("\nTime complexity in ms for n="+n+" is"+(double)elapsedTime/1000000);
	}
public static void QuickSortAlgorithm(int l,int h)
{
	int i,j,temp,pivot;
	if(l<h)
	{
		i=l;
		j=h+1;
		pivot=a[l];
		while(true)
		{
			i++;
			while(a[i]<pivot&&i<h)
				i++;
				j--;
			while(a[j]>pivot)
				j--;
			if(i<j)
			{
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
			else
				break;
		}
		a[l]=a[j];
		a[j]=pivot;
		QuickSortAlgorithm(l,j-1);
		QuickSortAlgorithm(j+1,h);
	}
  }
}

