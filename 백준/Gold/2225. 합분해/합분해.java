import java.util.*;
import java.io.*;

public class Main {
	public static final int MOD = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[i].length; j++) {
				// N이 1일 때
				if(i == 1) {
					dp[i][j] = j;
				}
				// K가 1일 때
				else if(j == 1) {
					dp[i][j] = 1;
				}
				else {
					dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
				}
				
			}
		}
		
		System.out.println(dp[N][K] % MOD);
		
	}

}
