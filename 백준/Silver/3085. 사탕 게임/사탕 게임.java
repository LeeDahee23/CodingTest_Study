import java.util.*;
import java.io.*;

public class Main {
	private static final int[] dx = {0, 0, 1, -1};
	private static final int[] dy = {1, -1, 0, 0};
	private static int max = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		
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
			
			char[][] tmpBoard = new char[board.length][board[0].length];
			for(int j=0; j<board.length; j++) {
				tmpBoard[j] = board[j].clone();
			}
			
			// 인접한 사탕이 범위 안에 있고, 나의 색과 다른 사탕이라면
			if(nx>=0 && nx<board.length && ny>=0 && ny<board.length && tmpBoard[x][y] != tmpBoard[nx][ny]) {
				// 나랑 인접한 사탕을 교환함
				char tmp = tmpBoard[x][y];
				tmpBoard[x][y] = tmpBoard[nx][ny];
				tmpBoard[nx][ny] = tmp;
				
				// 교환했을 때 가장 긴 연속 부분의 길이를 구함
				int cnt = findLongestLength(tmpBoard);
				max = Math.max(max, cnt);
			}
		}
	}
	
	private static int findLongestLength(char[][] board) {
		int cnt, max = 0;
		// 행의 길이
		for(int i=0; i<board.length; i++) {
			cnt = 1;
			for(int j=0; j<board[i].length-1; j++) {
				if(board[i][j] == board[i][j+1]) cnt++;
				else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			
			max = Math.max(max, cnt);
		}
		
		// 열의 길이
		for(int i=0; i<board.length; i++) {
			cnt = 1;
			for(int j=0; j<board[i].length-1; j++) {
				if(board[j][i] == board[j+1][i]) cnt++;
				else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			
			max = Math.max(max, cnt);
		}
		
		return max;
	}
}
