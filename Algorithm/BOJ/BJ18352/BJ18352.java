import java.util.*;
import java.io.*;

public class BJ18352 {
	static final int INF = Integer.MAX_VALUE;			

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 인접리스트
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(e);
		}
		
		int[] result = bfs(graph, X, N);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<result.length; i++) {
			if(result[i] == K) {
				sb.append(i + "\n");
			}
		}
		
		if(sb.length() == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sb);
		}
		
	}
	
	private static int[] bfs(ArrayList<ArrayList<Integer>> graph, int start, int N) {
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		Queue<Integer> q = new LinkedList<>();
		
		dist[start] = 0;
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for(int next : graph.get(cur)) {
				if(!visited[next] && dist[next] > dist[cur] + 1) {
					dist[next] = dist[cur] + 1;
					q.offer(next);
				}
			}
		}
		
		return dist;
	}

}
