import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] board = new int[5][5];
		for(int i=0; i<board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<board[0].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				findNumber(board, i, j, board[i][j]+"");
			}
		}
		
		System.out.println(set.size());
		
	}
	
	private static void findNumber(int[][] board, int sx, int sy, String str) {
		if(str.length() >= 6) {
			set.add(str);
			return;
		}
		
		for(int i=0; i<dx.length; i++) {
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			
			if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
				findNumber(board, nx, ny, str + board[nx][ny]);
			}
			
		}
		
		
	}

}
