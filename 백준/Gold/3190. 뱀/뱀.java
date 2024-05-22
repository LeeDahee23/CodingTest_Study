import java.util.*;
import java.io.*;

public class Main {
	// 동 남 서 북
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	private static int[][] board;
	private static HashMap<Integer, String> map = new HashMap<>();
	private static ArrayList<int[]> snake = new ArrayList<>();
	private static int cx = 0, cy = 0;
	private static int time = 0, dir = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		board = new int[N][N]; // 빈칸: 0, 사과: 1, 뱀: 2
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			board[x][y] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			
			map.put(x, c);
		}
		
		snake.add(new int[] {0, 0});
		while(true) {
			time ++;
			
			// 뱀 이동
			int nx = cx + dx[dir];
			int ny = cy + dy[dir];
			
			// 이동한 위치가 벗어나는지 확인
			if(isFinish(nx, ny)) {
				break;
			}
			
			move(nx, ny);
			
		}
		
		System.out.println(time);
	}
	
	private static void move(int nx, int ny) {
		snake.add(new int[] {nx, ny});
		
		// 사과 있으면 길이 조절
		if(board[nx][ny] == 1) {
			board[nx][ny] = 0;
		}else {
			snake.remove(0);
		}
		
		cx = nx;
		cy = ny;
		
		// 현재 시간에 방향 바꿔야 하면 바꾸기
		if(map.containsKey(time)) {
			String s = map.get(time);
			
			if(s.equals("L")) {
				dir = (dir + 3) % 4;
			}
			else {
				dir = (dir + 1) % 4;
			}
		}
		
	}
	
	private static boolean isFinish(int x, int y) {
		if(x<0 || x>=board.length || y<0 || y>=board[0].length) {
			return true;
		}
		
		for(int[] pos : snake) {
			if(pos[0] == x && pos[1] == y) {
				return true;
			}
		}
		
		return false;
	}
}
