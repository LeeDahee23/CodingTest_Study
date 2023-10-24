import java.util.*;
import java.io.*;

public class BJ15989 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] dp = new int[n+1][4];
			
			dp[1][1] = 1;
			dp[1][2] = 0;
			dp[1][3] = 0;
			
			if(n >= 2) {
				dp[2][1] = 1;
				dp[2][2] = 1;
				dp[2][3] = 0;
			}
			
			if(n >= 3) {
				dp[3][1] = 1;
				dp[3][2] = 1;
				dp[3][3] = 1;
			}
			
			for(int i=4; i<=n; i++) {
				dp[i][1] = dp[i-1][1];
				dp[i][2] = dp[i-2][1] + dp[i-2][2];
				dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
			}
			
			System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
		}
	}

}
