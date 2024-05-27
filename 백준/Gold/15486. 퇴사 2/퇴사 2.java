import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] consultings = new int[N+2][2];
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			consultings[i][0] = Integer.parseInt(st.nextToken());
			consultings[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+2];
		int max = -1; // 현재까지의 최대 이익
		
		for(int i=1; i<dp.length; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
			
			int next = i + consultings[i][0]; // 다음 상담 날짜
			// 상담 가능함
			if(next < N+2) {
				
				dp[next] = Math.max(dp[next], max + consultings[i][1]);
			}
		}
		
		System.out.println(dp[N+1]);
		
	}

}
