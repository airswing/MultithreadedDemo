import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedDemo {
	//Initialize constants
	public static final int MAXTHREADS = 7;
	public static final long TOTALPRIMENUMS = 10000;
	public static final int SLEEPTIME = 500;
	
	public static void main(String[] args) {
		//Initialize Executor Service and make it handle MAXTHREADS at a time.
		ExecutorService pool = Executors.newFixedThreadPool(MAXTHREADS);
		
		//Start a thread for each number you want to check if it's prime
		for(long i = 1; i <= TOTALPRIMENUMS; i++){
			//Initialize PrimeWorker with value of i
			PrimeWorker worker = new PrimeWorker(i);
			//Give the worker to the pool to execute
			pool.execute(worker);
		}
		
		//Tell the pool to shutdown, even if it's not finished yet
		pool.shutdownNow();
		
		try {
			//Keep checking if the pool finally terminated before continuing
			while(!pool.isTerminated())
				Thread.sleep(SLEEPTIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//By the time the flow has reached this point we can guarantee that all threads completed.
		System.out.println("Threads are complete!");
		
	}

}
