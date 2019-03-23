package primes;

public class PrintPrimes{
	
	private static final int MAXPRIMES = 100;

	private static boolean isDivisible (int i, int j){
	   if (j%i == 0)
	      return true;
	   else
	      return false;
	}
	public static String printPrimes (int n){
	   String prime = new String();
	   int curPrime;           // Value currently considered for primeness
	   int numPrimes;          // Number of primes found so far.
	   boolean isPrime;        // Is curPrime prime?
	   int [] primes = new int [MAXPRIMES]; // The list of prime numbers.
	 
	   // Initialize 2 into the list of primes.
	   primes [0] = 2;
	   numPrimes = 1;
	   curPrime  = 2;
	   while (numPrimes < n){
	      curPrime++;  // next number to consider ...
	      isPrime = true;
	      for (int i = 0; i <= numPrimes-1; i++){   // for each previous prime.
	         if (isDivisible (primes[i], curPrime)){  // Found a divisor, curPrime is not prime.
	            isPrime = false;
	            break; // out of loop through primes.
	         }
	      }
	      if (isPrime){   // save it!
	         primes[numPrimes] = curPrime;
	         numPrimes++;
	      }
	   }  // End while
	
	   // Print all the primes out.
	   for (int i = 0; i <= numPrimes-1; i++){
		   prime += primes[i] + " ";
	   }
	   return prime;
	}  // end printPrimes
                            
}
