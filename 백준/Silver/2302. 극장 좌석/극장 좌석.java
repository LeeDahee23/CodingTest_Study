import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] dp = new int[41];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<N+1; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		int answer = 1;
		
		int beforeSeat = 0;
		for(int i=0; i<M; i++) {
			int vip = Integer.parseInt(br.readLine());
			answer *= dp[vip - beforeSeat - 1];
			beforeSeat = vip;
		}
		
		answer *= dp[N - beforeSeat];
		
		System.out.println(answer);
		
		
		
	}

}
