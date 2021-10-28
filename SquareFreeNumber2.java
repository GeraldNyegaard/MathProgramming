package mathProgramming;

import java.util.ArrayList;

/*
 *  List all square free numbers from 2 to 1000.
 *  Display the prime factors of all composite numbers.
 */
public class SquareFreeNumber2 {
	public static void main(String[] args) {

		int number = 2, divisor, result = 0, remainder = 0, x, limit = 1000;
		System.out.println("\n\tThe square free numbers from 2 to 1000 are:\n");

		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		x = number;

		while (number < limit) {
			divisor = isPrime(x);

			if (divisor == -1) {
				primeFactors.add(x);
				System.out.print("\t" + number);

				if (primeFactors.size() == 1) {
					System.out.println(" is prime.");
				} else {
					System.out.println(" has prime factors: " + primeFactors);
				}

				primeFactors.clear();
				number++;
				x = number;

			} else {
				primeFactors.add(divisor);

				result = x / divisor;
				remainder = result % divisor;

				if (remainder == 0) {
					primeFactors.clear();
					number++;
					x = number;

				} else {
					x = result;

				}
			}
		}
	}

	public static int isPrime(int x) {
		
		for (int divisor = 2; divisor * divisor <= x; divisor++) {
			if (x % divisor == 0)
				return divisor;
		}
		return -1;
	}
}
