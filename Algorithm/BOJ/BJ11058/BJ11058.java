import java.util.*;
import java.io.*;

public class BJ11058 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		
		for(int i=1; i<=N; i++) {
			dp[i] = Math.max(dp[i], i);
			
			for(int j=i+3; j<=N; j++) {
				dp[j] = Math.max(dp[j], dp[i] * (j-i-1)); 
			}
		}
		
		System.out.println(dp[N]);
	}

}
