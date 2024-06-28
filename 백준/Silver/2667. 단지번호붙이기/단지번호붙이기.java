import java.util.*;
import java.io.*;

public class Main {
	public static final int[] dx = {0, 0, 1, -1};
	public static final int[] dy = {1, -1, 0, 0};
	public static int N;
	public static char[][] board;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];	
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				board[i][j] = input.charAt(j);
			}
		}

		ArrayList<Integer> answer = new ArrayList<>();
		int total = 0;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j] == '1' && !visited[i][j]) {
					int cnt = bfs(i, j);
					answer.add(cnt);
					total ++;
				}
			}
		}
		
		Collections.sort(answer);
		System.out.println(total);
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
		
	}
	
	private static int bfs(int sx, int sy) {
		Queue<int[]> que = new LinkedList<>();
		
		que.offer(new int[] {sx, sy});
		visited[sx][sy] = true;
		int cnt = 1;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int i=0; i<dx.length; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(inRange(nx, ny) && board[nx][ny] == '1' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					que.offer(new int[] {nx, ny});
					cnt ++;
				}
			}
		}
		
		return cnt;
	}
	
	private static boolean inRange(int x, int y) {
		if(x>=0 && x<N && y>=0 && y<N) {
			return true;
		}
		
		return false;
	}

}
