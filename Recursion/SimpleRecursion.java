package Recursion;

/**
 * @garrettspillman1
 *                   This class provides examples of simple recursive methods.
 */
public class SimpleRecursion {

	/**
	 * The main method (not used in this class).
	 *
	 * 
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {
        // Example of counting down from 5
        System.out.println("Counting down from 5:");
        SimpleRecursion.countDown(5);
		System.out.println();

        // Example of calculating factorial for 5
        int factorialResult = SimpleRecursion.factorial(5);
        System.out.println("Factorial of 5: " + factorialResult+"\n");

        // Example of calculating GCD for two numbers (15 and 25)
        int gcdResult = SimpleRecursion.gcd(15, 25);
        System.out.println("GCD of 15 and 25: " + gcdResult+"\n");

        // Example of calculating Fibonacci value at position 6
        int fibonacciResult = SimpleRecursion.fibonacci(6);
        System.out.println("Fibonacci value at position 6: " + fibonacciResult+"\n");		
	}

	/**
	 * Recursively counts down from a given number to 0 and prints each count.
	 *
	 * @param i The starting number for the countdown.
	 */
	public static void countDown(int i) {
		if (i < 0)
			return;
		System.out.println(i);
		countDown(i - 1);
	}

	/**
	 * Recursively calculates the factorial of a given number.
	 *
	 * @param number The number for which to calculate the factorial.
	 * @return The factorial of the given number.
	 */
	public static int factorial(int number) {
		if (number <= 0)
			return 1;
		else
			return number * factorial(number - 1);
	}

	/**
	 * Recursively calculates the greatest common divisor (GCD) of two numbers.
	 *
	 * @param a The first number.
	 * @param b The second number.
	 * @return The GCD of the two numbers.
	 */
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	/**
	 * Recursively calculates the Fibonacci sequence value at a given position.
	 *
	 * @param number The position in the Fibonacci sequence.
	 * @return The Fibonacci value at the given position.
	 */
	public static int fibonacci(int number) {
		if (number == 1 || number == 2)
			return 1;
		else
			return fibonacci(number - 1) + fibonacci(number - 2);
	}
}
