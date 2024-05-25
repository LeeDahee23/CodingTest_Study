import java.util.*;
import java.io.*;

public class Main {
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};
	private static int[][] dice = new int[4][3];
	private static int[][] board;
	private static int x;
	private static int y;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice[0][0] = dice[0][2] = dice[2][0] = dice[2][2] = dice[3][0] = dice[3][2] = -1;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int dir = Integer.parseInt(st.nextToken()) - 1;
			
			moveDice(dir);
		}
	}
	
	private static void moveDice(int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(!isRange(nx, ny)) {
			return;
		}
		
		int[][] rotatedDice = new int[4][3];
		rotatedDice[0][0] = rotatedDice[0][2] = rotatedDice[2][0] = rotatedDice[2][2] = rotatedDice[3][0] = rotatedDice[3][2] = -1;
		
		switch(dir) {
			case(0): // 동
				rotatedDice[0][1] = dice[0][1];
				rotatedDice[2][1] = dice[2][1];
				rotatedDice[1][0] = dice[1][1];
				rotatedDice[1][1] = dice[1][2];
				rotatedDice[1][2] = dice[3][1];
				rotatedDice[3][1] = dice[1][0];
				break;
				
			case(1): // 서
				rotatedDice[0][1] = dice[0][1];
				rotatedDice[2][1] = dice[2][1];
				rotatedDice[1][1] = dice[1][0];
				rotatedDice[1][2] = dice[1][1];
				rotatedDice[3][1] = dice[1][2];
				rotatedDice[1][0] = dice[3][1];
				break;
				
			case(2):// 북
				rotatedDice[1][0] = dice[1][0];
				rotatedDice[1][2] = dice[1][2];
				rotatedDice[0][1] = dice[3][1];
				rotatedDice[1][1] = dice[0][1];
				rotatedDice[2][1] = dice[1][1];
				rotatedDice[3][1] = dice[2][1];
				break;
				
			case(3):// 남
				rotatedDice[1][0] = dice[1][0];
				rotatedDice[1][2] = dice[1][2];
				rotatedDice[3][1] = dice[0][1];
				rotatedDice[2][1] = dice[3][1];
				rotatedDice[1][1] = dice[2][1];
				rotatedDice[0][1] = dice[1][1];
				break;
		}
		
		dice = rotatedDice.clone();
		
		if(board[nx][ny] == 0) {
			board[nx][ny] = dice[1][1];
		}else {
			dice[1][1] = board[nx][ny];
			board[nx][ny] = 0;
		}
		
		x = nx;
		y = ny;
		
		System.out.println(dice[3][1]);
	}
	
	private static boolean isRange(int x, int y) {
		if(x<0 || x>=board.length || y<0 || y>=board[0].length) {
			return false;
		}
		
		return true;
	}

}
