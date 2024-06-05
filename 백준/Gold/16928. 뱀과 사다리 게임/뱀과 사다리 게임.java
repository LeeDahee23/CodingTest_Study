import java.util.*;
import java.io.*;

public class Main {
	private static int answer = 0;
	private static HashMap<Integer, Integer> move = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			move.put(from, to);
		}
		
		bfs(1);
		
		// 100번의 값을 출력
		System.out.println(answer);
	}
	
	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		int[] count = new int[101];
		
		que.offer(start);
		count[start] = 0;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			if(cur == 100) {
				answer = count[cur];
				return;
			}
			
			for(int i=1; i<=6; i++) {
				int next = cur + i;
				
				if(next > 100) continue;
				
				if(count[next] == 0 && !move.containsKey(next)) {
					count[next] = count[cur] + 1;
					que.offer(next);
				}
				// 주사위로 이동한 칸이 사다리나 뱀이라면, 사다리/뱀을 이동시키고
				if(move.containsKey(next) && count[move.get(next)] == 0) {
					que.offer(move.get(next));
					count[move.get(next)] = count[cur] + 1;
				}
			}
		}
	}
	
}
