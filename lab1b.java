import java.util.Scanner;
class arrayStack
{
	int arr[];
	int top,max;
	arrayStack(int n)
	{
		max=n;
		top=-1;
		arr=new int[max];
	}
	void push(int i)
	{
		if(top==max-1)
			System.out.println(" Stack overflow");
		else
			arr[++top]=i;
	}
	void pop()
	{
		if(top==-1)
			System.out.println(" Stack underflow");
		else
		{
			int ele=arr[top--];
			System.out.printf("popped element is "+ele);
		}
	}
	void display()
	{
		System.out.println("The elements of stack are");
		if(top==-1)
		{
			System.out.println("Stack underflow");
			return;
		}
		for(int i=top;i>=0;i--)
			System.out.println(arr[i]+"");
		    System.out.println();
	}
}
public class stack 
{
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the size of stack");
		int n=scan.nextInt();
		boolean done=false;
		arrayStack stk=new arrayStack(n);
		do
		{
			System.out.println("\nstack operation");
			System.out.println("1.push  2.pop  3.display  								4.exit");
			System.out.println("Enter your choice");
			int choice=scan.nextInt();
		switch(choice)
		{
			case 1:System.out.println("Enter integer                                                                                                                                                                                              								element to push");
				   stk.push(scan.nextInt());
				   break;
			case 2:stk.pop();
			       break;
			case 3:stk.display();
			       break;
			case 4:done=true;
			       break;
			default:System.out.println("Invalid entry");
			        break;
		}
	
	    }while(!done);
	}
}
