import java.util.*;
import java.io.*;

public class BJ11724 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] graph = new boolean[N+1][N+1];
		boolean[] visited = new boolean[N+1];
		int cnt = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u][v] = true;
			graph[v][u] = true;
		}
		
		for(int i=1; i<visited.length; i++) {
			if(!visited[i]) {
				visited = countConnectedComponent(graph, visited, i);
				cnt ++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	private static boolean[] countConnectedComponent(boolean[][] graph, boolean[] visited, int s) {
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.offer(s);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0; i<graph[cur].length; i++) {
				if(!visited[i] && graph[cur][i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
		return visited;
	}

}
