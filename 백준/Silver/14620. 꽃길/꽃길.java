import java.util.*;
import java.io.*;

public class Main {
	private static int N;
	private static int[][] board;
	private static boolean[][] visited;
	private static int min = Integer.MAX_VALUE;
	private static final int[] dx = {0, 0, 1, -1};
	private static final int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findFlowerPos(0, 0);
		System.out.println(min);
		
	}
	
	private static void findFlowerPos(int totalCost, int cnt) {
		if(cnt == 3) {
			min = Math.min(min, totalCost);
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(isPossible(i, j)) {
					// 방문처리
					setVisited(i, j, true);
					// findFlowerPos 다시 들어가
					int cost = getCost(i, j);
					findFlowerPos(totalCost + cost, cnt + 1);
					// 방문처리 풀기
					setVisited(i, j, false);
				}
			}
		}
		
	}
	
	private static int getCost(int x, int y) {
		int sum = board[x][y];
		for(int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			sum += board[nx][ny];
		}
		
		return sum;
	}
	
	private static void setVisited(int x, int y, boolean flag) {
		if(flag) {
			visited[x][y] = true;
			
			for(int i=0; i<dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				visited[nx][ny] = true; 
			}
		}
		else {
			visited[x][y] = false;
			
			for(int i=0; i<dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				visited[nx][ny] = false; 
			}
		}
	}
	
	private static boolean isPossible(int x, int y) {
		for(int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) {
				return false;
			}
		}
		
		return true;
	}

}
