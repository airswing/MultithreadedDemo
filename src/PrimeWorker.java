
public class PrimeWorker implements Runnable {
	private long num;
	
	//This constructor is where the PrimeWorker object gets assigned its number
	public PrimeWorker(long num){
		this.num = num;
	}
	
	@Override
	public void run() {
		//Output result of the work
		if(isPrime(this.num))
			System.out.println(this.num + " is prime!");
		else
			System.out.println(this.num + " is NOT prime!");
	}
	
	//Returns true if num is prime
	private static boolean isPrime(long num) {
	    if(num == 2) return true;
	    if(num == 1 || num % 2 == 0) return false;
	    for(long i = 3; i * i < num; i += 2)
	        if (num % i == 0) return false;
	    return true;
	}

}
