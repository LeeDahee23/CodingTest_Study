import java.util.*;
import java.io.*;

public class BJ12026 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int[] dp = new int[N]; // B, O, J
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		
		for(int i=1; i<input.length(); i++) {
			char now = input.charAt(i);
			
			for(int j=0; j<i; j++) {
				if(now == 'B' && input.charAt(j) == 'J' && dp[j] < Integer.MAX_VALUE ) {
					dp[i] = Math.min(dp[i], dp[j] + (int)Math.pow(i-j, 2));
				}
				else if(now == 'O' && input.charAt(j) == 'B' && dp[j] < Integer.MAX_VALUE ) {
					dp[i] = Math.min(dp[i], dp[j] + (int)Math.pow(i-j, 2));
				}
				else if(now == 'J' && input.charAt(j) == 'O' && dp[j] < Integer.MAX_VALUE ) {
					dp[i] = Math.min(dp[i], dp[j] + (int)Math.pow(i-j, 2));
				}
			}
			
		}
		
		if(dp[N-1] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[N-1]);
	}

}
