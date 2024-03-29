import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] board = new int[n][m];
		int[][] knight = {{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
		int[][] queen = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
		
		st = new StringTokenizer(br.readLine());
		int queenCnt = Integer.parseInt(st.nextToken());
		int[][] queenPos = new int[queenCnt][2]; // queen의 위치
		for(int i=0; i<queenCnt; i++) {
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			queenPos[i][0] = x;
			queenPos[i][1] = y;
			board[x][y] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		int knightCnt = Integer.parseInt(st.nextToken());
		int[][] knightPos = new int[knightCnt][2]; // knight의 위치
		for(int i=0; i<knightCnt; i++) {
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			knightPos[i][0] = x;
			knightPos[i][1] = y;
			board[x][y] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		int pawnCnt = Integer.parseInt(st.nextToken());
		for(int i=0; i<pawnCnt; i++) {
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			board[x][y] = 1;
		}
		
		for(int i=0; i<queenPos.length; i++) {
			for(int q=0; q<queen.length; q++) {
				for(int cnt=1; ; cnt++) {
					int nextX = queenPos[i][0] + queen[q][0] * cnt;
					int nextY = queenPos[i][1] + queen[q][1] * cnt;

					// 범위를 벗어나거나 장애물을 만나면 이동 못함
					if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || board[nextX][nextY] == 1) {
						break;
					}
					else {
						board[nextX][nextY] = 2;
					}
				}
			}
		}
		
		for(int i=0; i<knightPos.length; i++) {
			for(int k=0; k<knight.length; k++) {
				int nextX = knightPos[i][0] + knight[k][0];
				int nextY = knightPos[i][1] + knight[k][1];
				
                // 범위를 벗어나지 않고 말이 없는 곳이면 이동함
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && board[nextX][nextY] == 0) {
					board[nextX][nextY] = 2;
				}
			}
		}
		
		
		int total = 0;		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] == 0) {
					total ++;
				}
			}

		}
        System.out.println(total);
	}

}
