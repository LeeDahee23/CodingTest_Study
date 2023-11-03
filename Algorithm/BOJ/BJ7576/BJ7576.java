import java.util.*;
import java.io.*;

public class BJ7576 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] tomato = new int[N][M];
		
		for(int i=0; i<tomato.length; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<tomato[0].length; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		
		System.out.println(findDays(tomato));
	}
	
	private static int findDays(int[][] arr) {
		Queue<int[]> q = new LinkedList<>();
		final int[] dx = {0, 0, 1, -1};
		final int[] dy = {1, -1, 0, 0};
		int depth = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j] == 1) {
					q.offer(new int[] {i, j, 0});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			depth = cur[2];
			
			for(int i=0; i<dx.length; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				int nd = cur[2] + 1;
				
				if(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length && arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
					q.offer(new int[] {nx, ny, nd});
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j] == 0) {
					return -1;
				}
			}
		}
		
		return depth;
	}

}
