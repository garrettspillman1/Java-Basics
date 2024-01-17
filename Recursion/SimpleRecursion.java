package Recursion;


public class SimpleRecursion {
	
	
	public static void main(String[] args) 
	{
	
	}
	public static void countDown(int i)
	
	{
		if(i < 0)
			return;
		System.out.println(i);
		countDown(i-1);
		
	}
	public static int factorial (int number)
	{
		if(number <= 0)
			return 1;
		else
			return number * factorial(number-1);
		
	}
	public static int gcd ( int a, int b)
	{
		if(b == 0)
			return a;
		else 
			return gcd(b,a%b);
	}
	public static int fibonacci(int number)
	{
		if(number == 1 || number == 2)
			return 1;
		else
			return fibonacci(number-1)+fibonacci(number-2);
	}
	
}
