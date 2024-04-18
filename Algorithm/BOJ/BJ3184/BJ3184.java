import java.util.*;
import java.io.*;

public class BJ3184 {
	static char[][] board;
	static boolean[][] visited;
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];
		int sheep = 0, wolf = 0;
		
		for(int i=0; i<board.length; i++) {
			String input = br.readLine();
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = input.charAt(j);
				if(board[i][j] == '#') {
					visited[i][j] = true;
				}
			}
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(!visited[i][j]) {
					int[] cnt = count(i, j);
					if(cnt[0] == 0 && cnt[1] == 0) continue;
					
					if(cnt[0] > cnt[1]) sheep += cnt[0];
					else wolf += cnt[1];
				}
			}
		}
		
		System.out.println(sheep + " " + wolf);
		
	}
	
	private static int[] count(int sx, int sy) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {sx, sy});
		visited[sx][sy] = true;
		int sheep = 0, wolf = 0;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			
			if(board[x][y] == 'o') sheep ++;
			if(board[x][y] == 'v') wolf ++;
			
			for(int i=0; i<dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && !visited[nx][ny]) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		
		return new int[]{sheep, wolf};
		
	}

}
