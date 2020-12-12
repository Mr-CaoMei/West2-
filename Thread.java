package GHL;
//10线程
import java.util.Scanner;
import java.util.concurrent.*;

public class Thread {
	public static void main(String[] args) throws InterruptedException,ExecutionException {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		CompletableFuture<Long>completableFuture1 = CompletableFuture.supplyAsync(()->{
			long ans1 = 0;
			for (long i = 0; i < 100000000; i++) {
				if (contain(i, x)) ans1 += i;
			}
			return ans1;
		});
		
		CompletableFuture<Long>completableFuture2 = CompletableFuture.supplyAsync(()->{
			long ans2 = 0;
			for (long i = 100000001; i < 200000000; i++) {
				if (contain(i, x)) ans2 += i;
			}
			return ans2;
		});
		
		CompletableFuture<Long>completableFuture3 = CompletableFuture.supplyAsync(()->{
			long ans3 = 0;
			for (long i = 200000001; i < 300000000; i++) {
				if (contain(i, x)) ans3 += i;
			}
			return ans3;
		});
		
		CompletableFuture<Long>completableFuture4 = CompletableFuture.supplyAsync(()->{
			long ans4 = 0;
			for (long i = 300000001; i < 400000000; i++) {
				if (contain(i, x)) ans4 += i;
			}
			return ans4;
		});
		
		CompletableFuture<Long>completableFuture5 = CompletableFuture.supplyAsync(()->{
			long ans5 = 0;
			for (long i = 400000001; i < 500000000; i++) {
				if (contain(i, x)) ans5 += i;
			}
			return ans5;
		});
		
		CompletableFuture<Long>completableFuture6 = CompletableFuture.supplyAsync(()->{
			long ans6 = 0;
			for (long i = 500000001; i < 600000000; i++) {
				if (contain(i, x)) ans6 += i;
			}
			return ans6;
		});
		
		CompletableFuture<Long>completableFuture7 = CompletableFuture.supplyAsync(()->{
			long ans7 = 0;
			for (long i = 600000001; i < 700000000; i++) {
				if (contain(i, x)) ans7 += i;
			}
			return ans7;
		});
		
		CompletableFuture<Long>completableFuture8 = CompletableFuture.supplyAsync(()->{
			long ans8 = 0;
			for (long i = 700000001; i < 800000000; i++) {
				if (contain(i, x)) ans8 += i;
			}
			return ans8;
		});
		
		CompletableFuture<Long>completableFuture9 = CompletableFuture.supplyAsync(()->{
			long ans9 = 0;
			for (long i = 800000001; i < 900000000; i++) {
				if (contain(i, x)) ans9 += i;
			}
			return ans9;
		});
		
		CompletableFuture<Long>completableFuture10 = CompletableFuture.supplyAsync(()->{
			long ans10 = 0;
			for (long i = 900000001; i < 1000000000; i++) {
				if (contain(i, x)) ans10 += i;
			}
			return ans10;
		});
		CompletableFuture<Long>completableFuture12 = completableFuture1.thenCombine(completableFuture2,(result1,result2)->result1+result2);
		CompletableFuture<Long>completableFuture13 = completableFuture12.thenCombine(completableFuture3,(result12,result3)->result12+result3);
		CompletableFuture<Long>completableFuture14 = completableFuture13.thenCombine(completableFuture4,(result13,result4)->result13+result4);
		CompletableFuture<Long>completableFuture15 = completableFuture14.thenCombine(completableFuture5,(result14,result5)->result14+result5);
		CompletableFuture<Long>completableFuture16 = completableFuture15.thenCombine(completableFuture6,(result15,result6)->result15+result6);
		CompletableFuture<Long>completableFuture17 = completableFuture16.thenCombine(completableFuture7,(result16,result7)->result16+result7);
		CompletableFuture<Long>completableFuture18 = completableFuture17.thenCombine(completableFuture8,(result17,result8)->result17+result8);
		CompletableFuture<Long>completableFuture19 = completableFuture18.thenCombine(completableFuture9,(result18,result9)->result18+result9);
		CompletableFuture<Long>completableFuture20 = completableFuture19.thenCombine(completableFuture10,(result19,result10)->result19+result10);
		System.out.println(completableFuture20.get());
	}
	
	private static boolean contain(long num, int x) {
		return String.valueOf(num).contains(String.valueOf(x));
	}
}
