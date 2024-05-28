import java.util.*;
import java.io.*;

public class Main {
	private static char[][] board;
	private static final int[] dx = {0, 0, 1, -1};
	private static final int[] dy = {1, -1, 0, 0};
	private static int answer = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new char[12][6];
		
		for(int i=0; i<board.length; i++) {
			String str = br.readLine();
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
        while(true) {
			int puyoCnt = explorePuyo();
			if(puyoCnt <= 0) {
				break;
			}
			
			answer ++;
			fallDown();
		}
		
		System.out.println(answer);
	}
	
	private static int explorePuyo() {
		int cnt = 0;
		// board를 돌면서 연속 4개 이상있는 칸이 있는지 확인
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j] != '.') {
					Queue<int[]> q = findSamePuyo(i, j);
					
					// 4개 이상이라면 값을 "0"으로 바꿈
					if(q.size() >= 4) {
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							board[cur[0]][cur[1]] = '0';
						}
						
						cnt ++;
					}
				}
				
			}
		}
		
		return cnt;
	}
	
	private static Queue<int[]> findSamePuyo(int row, int col) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> trace = new LinkedList<>();
		visited[row][col] = true;
		q.offer(new int[] {row, col});
		trace.offer(new int[] {row, col});
		
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i=0; i<dx.length; i++) {
				int nRow = cur[0] + dx[i];
				int nCol = cur[1] + dy[i];
				
				if(inRange(nRow, nCol) && !visited[nRow][nCol] && board[row][col] == board[nRow][nCol]) {
					visited[nRow][nCol] = true;
					q.offer(new int[] {nRow, nCol});
					trace.offer(new int[] {nRow, nCol});
				}
			}
		}
		
		return trace;
	}
	
	private static boolean inRange(int row, int col) {
		return row>=0 && row<board.length && col>=0 && col<board[0].length;
	}
	
	// "0" 칸은 위 값을 아래로 내림
	private static void fallDown() {
		Queue<Character> q = new LinkedList<>();
		
		for(int j=0; j<board[0].length; j++) {
			// 빈 칸이 아닌 칸만 뽑아냄
			for(int i=board.length-1; i>=0; i--) {
				if(board[i][j] != '0') {
					q.offer(board[i][j]);
				}
			}
			
			for(int i=board.length-1; i>=0; i--) {
				if(!q.isEmpty()) {
					char c = q.poll();
					board[i][j] = c;
				}
				else {
					board[i][j] = '.';
				}
			}
		}
		
	}

}
