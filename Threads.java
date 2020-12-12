package GHL;
//2线程
import java.util.Scanner;
import java.util.concurrent.*;

public class Threads {
	public static void main(String[] args) throws InterruptedException,ExecutionException {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		CompletableFuture<Long>completableFuture1 = CompletableFuture.supplyAsync(()->{
			long ans1 = 0;
			for (long i = 0; i < 500000000; i++) {
				if (contain(i, x)) ans1 += i;
			}
			return ans1;
		});
		
		CompletableFuture<Long>completableFuture2 = CompletableFuture.supplyAsync(()->{
			long ans2 = 0;
			for (long i = 500000001; i < 1000000000; i++) {
				if (contain(i, x)) ans2 += i;
			}
			return ans2;
		});
		CompletableFuture<Long>completableFuture3 = completableFuture1.thenCombine(completableFuture2,(result1,result2)->result1+result2);
		System.out.println(completableFuture3.get());
	}
		private static boolean contain(long num, int x) {
			return String.valueOf(num).contains(String.valueOf(x));
		}
}
