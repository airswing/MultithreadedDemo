import java.math.BigInteger;

public class PrimeWorker implements Runnable {
	private long num;
	private BigInteger bigNum;
	boolean usingBigNum = false;

	//This constructor is where the PrimeWorker object gets assigned its number
	public PrimeWorker(long num){
		this.num = num;
	}

	//This constructor is where the PrimeWorker object gets assigned its big number
	public PrimeWorker(BigInteger bigNum) {
		this.bigNum = bigNum;
		usingBigNum = true;
	}

	@Override
	public void run() {
		//Output result of the work
		if(usingBigNum)
			if(isPrime(bigNum))
				System.out.println(this.bigNum + " is prime!");
			else
				System.out.println(this.bigNum + " is NOT prime!");
		else
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

	//Return true if num is prime
	public boolean isPrime(BigInteger num) {
		if (!num.isProbablePrime(5)) return false;
		final BigInteger TWO = new BigInteger("2");
		if(num.equals(TWO)) return true;
		if(num.equals(BigInteger.ONE) || BigInteger.ZERO.equals(num.mod(TWO))) return false;
		final BigInteger THREE = new BigInteger("3");
		for (BigInteger i = THREE; i.multiply(i).compareTo(num) < 1; i = i.add(TWO))
			if (BigInteger.ZERO.equals(num.mod(i))) return false;
		return true;
	}

}
