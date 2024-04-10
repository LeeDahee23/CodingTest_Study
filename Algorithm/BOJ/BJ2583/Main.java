import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] board;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M]; // false: 빈칸, true: 직사각형
		
		// 모눈종이에 직사각형 칠하기
		for(int t=0; t<K; t++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()); // 왼쪽 아래
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken()); // 오른쪽 위
			int ey = Integer.parseInt(st.nextToken());
			
			for(int i=sx; i<ex; i++) {
				for(int j=sy; j<ey; j++) {
					board[i][j] = true;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		// 모눈종이 돌면서 false인 영역의 크기를 하나씩 구하기
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(!board[i][j]) {
					int cnt = findArea(i, j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i : list) {
			System.out.print(i + " ");
		}
		
		
	}
	
	private static int findArea(int x, int y) {
		int cnt = 0;
		
		final int[] dx = {0, 0, 1, -1};
		final int[] dy = {1, -1, 0, 0};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		board[x][y] = true;
		cnt ++;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i=0; i<dx.length; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && !board[nx][ny]) {
					q.add(new int[] {nx, ny});
					board[nx][ny] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}
