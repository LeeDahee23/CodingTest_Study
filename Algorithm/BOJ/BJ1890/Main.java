import java.util.*;
import java.io.*;

public class BJ1890 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		long[][] dp = new long[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 0) break;
				
				if(i + arr[i][j] < N) dp[i + arr[i][j]][j] += dp[i][j];
				if(j + arr[i][j] < N) dp[i][j + arr[i][j]] += dp[i][j];
			}
		}
		
		System.out.println(dp[N-1][N-1]);
		
	}

}
