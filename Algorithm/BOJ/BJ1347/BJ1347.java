import java.util.*;
import java.io.*;

public class BJ1347 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력받기
		int n = Integer.parseInt(br.readLine());
		char[][] board = new char[101][101];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				board[i][j] = '#';
			}
		}
		
		// dir 배열(남서북동)
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		// idx=0부터 시작
		int idx = 0;
		int startX = 50, startY = 50;
		int maxX = 50, maxY = 50, minX = 50, minY= 50;
		// 시작지점 변경하기
        board[startX][startY] = '.';
		
		String str = br.readLine();
		for(int i=0; i<n; i++) {
			char dir = str.charAt(i);
			// R, L이면 방향 돌고
			if(dir == 'R') {
				if(idx == 3) {
					idx = 0;
				} else idx ++;
			}else if(dir == 'L') {
				if(idx == 0) {
					idx = 3;
				}else idx --;
			}
			// F이면 전진
			else if(dir == 'F'){
				startX += dx[idx];
				startY += dy[idx];
				maxX = Math.max(startX, maxX);
				maxY = Math.max(startY, maxY);
				minX = Math.min(startX, minX);
				minY = Math.min(startY, minY);
				
				board[startX][startY] = '.';
			}
		}
		
		// 미로 출력
		for(int i=minX; i<=maxX; i++) {
			for(int j=minY; j<=maxY; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
