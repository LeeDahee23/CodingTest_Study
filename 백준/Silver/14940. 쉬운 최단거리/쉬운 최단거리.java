import java.util.*;
import java.io.*;

public class Main {
	private static final int[] dx = {0, 0, 1, -1};
	private static final int[] dy = {1, -1, 0, 0};
	private static int[][] map;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 행
		int m = Integer.parseInt(st.nextToken()); // 열
		map = new int[n][m];
		dp = new int[n][m];
		
		int goalY = -1, goalX = -1; // 행 열
		
		for(int i=0; i<n; i++) { // 행
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) { // 열
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 목표 지점
				if(map[i][j] == 2) {
					goalY = i;
					goalX = j;
				}
			}
		}
		
		findDistance(goalY, goalX);
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		

	}
	
	private static void findDistance(int startY, int startX) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[map.length][map[0].length];
		
		q.offer(new int[] {startY, startX});
		visited[startY][startX] = true;
		dp[startY][startX] = 0;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int y = p[0], x = p[1];
			// 시작 지점에서부터 인접한 곳을 갈건데
			for(int i=0; i<dx.length; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !visited[ny][nx]) {
					// 인접한 곳이 1이라면 현재 위치 값에 +1한 것과 이미 저장된 값을 비교해서 더 작은 값을 넣
					if(map[ny][nx] == 1) {
						dp[ny][nx] = dp[y][x] + 1;
						q.offer(new int[] {ny, nx});
						visited[ny][nx] = true;
					}
				}
				
			}
		}
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					dp[i][j] = -1;
				}
			}
		}
		
	}
}
