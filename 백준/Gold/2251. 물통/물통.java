import java.util.*;
import java.io.*;

public class Main {	
	private static ArrayList<Integer> answer = new ArrayList<>();
	private static int volumeA, volumeB, volumeC;
	private static boolean[][][] visited = new boolean[201][201][201];

	public static class Water{
		int A, B, C;
		public Water(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		volumeA = Integer.parseInt(st.nextToken());
		volumeB = Integer.parseInt(st.nextToken());
		volumeC = Integer.parseInt(st.nextToken());
		
		bfs(0, 0, volumeC);
		
		Collections.sort(answer);
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
		
	}
	
	private static void bfs(int binA, int binB, int binC) {
		Queue<Water> que = new LinkedList<>();
		que.offer(new Water(0, 0, volumeC));
		
		while(!que.isEmpty()) {
			Water water = que.poll();
			
			int a = water.A;
			int b = water.B;
			int c = water.C;
			
			if(visited[a][b][c] == true) continue;
			
			visited[a][b][c] = true;
			if(a==0) answer.add(c);
			
			// A->B, 물이 넘칠때, 물이 안넘칠때
			if(a + b > volumeB) {
				que.offer(new Water(a-(volumeB-b), volumeB, c));
			}else {
				que.offer(new Water(0, a + b, c));
			}
			// B->A, 물이 넘칠때, 물이 안넘칠때
			if(b + a > volumeA) {
				que.offer(new Water(volumeA, b-(volumeA-a), c));
			}else {
				que.offer(new Water(a + b, 0, c));
			}
			// A->C, 물이 넘칠때, 물이 안넘칠때
			if(a + c > volumeC) {
				que.offer(new Water(a-(volumeB-b), b, volumeC));
			}else {
				que.offer(new Water(0, b, c+a));
			}
			// C->A, 물이 넘칠때, 물이 안넘칠때
			if(a + c > volumeA) {
				que.offer(new Water(volumeA, b, c-(volumeA-a)));
			}else {
				que.offer(new Water(a+c, b, 0));
			}
			// B->C, 물이 넘칠때, 물이 안넘칠때
			if(b + c > volumeC) {
				que.offer(new Water(a, b-(volumeC-c), volumeC));
			}else {
				que.offer(new Water(a, 0, c+b));
			}
			// C->B, 물이 넘칠때, 물이 안넘칠때
			if(b + c > volumeB) {
				que.offer(new Water(a, volumeB, c-(volumeB-b)));
			}else {
				que.offer(new Water(a, c+b, 0));
			}
			
		}
		
		
		
	}

}
