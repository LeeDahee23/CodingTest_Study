import java.util.*;
import java.io.*;

public class Main {
	private static final int[] dx = {0, 0, 1, -1};
	private static final int[] dy = {1, -1, 0, 0};
	private static int max = 0;
	private static char[][] board;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				find(board, i, j);
			}
		}
		
		System.out.println(max);
	}
	
	private static void find(char[][] board, int x, int y) {
		// 인접한 칸의 사탕 색 구하기
		for(int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 인접한 사탕이 범위 안에 있고, 나의 색과 다른 사탕이라면
			if(nx>=0 && nx<board.length && ny>=0 && ny<board.length) {
				// 나랑 인접한 사탕을 교환함
				swap(x, y, nx, ny);				
				// 교환했을 때 가장 긴 연속 부분의 길이를 구함
				findLongestLength(x, y);
				swap(x, y, nx, ny);
			}
		}
	}
	
	private static void swap(int x, int y, int nx, int ny) {
		char tmp = board[x][y];
		board[x][y] = board[nx][ny];
		board[nx][ny] = tmp;
	}
	
	// 문제점
	// 중복된 연산이 너무 많음(현재 위치의 행열만 살펴보면 됨!)
	private static void findLongestLength(int x, int y) {
		int cnt = 1;
		// 행의 길이: 열은 고정, 행만 위,아래를 나와 같은지 살펴보면 됨
		int zx = x-1;
		while(true) {
			if(zx<0 || board[x][y] != board[zx--][y]) break;
			cnt ++;
		}
		
		zx = x+1;
		while(true) {
			if(zx>=board.length || board[x][y] != board[zx++][y]) break;
			cnt ++;
		}
		
		max = Math.max(max, cnt);
		
		// 열의 길이
		cnt = 1;
		
		int zy = y-1;
		while(true) {
			if(zy<0 || board[x][y] != board[x][zy--]) break;
			cnt ++;
		}
		
		zy = y+1;
		while(true) {
			if(zy>=board[0].length || board[x][y] != board[x][zy++]) break;
			cnt ++;
		}
		
		max = Math.max(max, cnt);
	}
}
