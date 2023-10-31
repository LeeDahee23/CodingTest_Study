import java.util.*;
import java.io.*;

public class BJ1753 {
	static class Edge{
		int end;
		int weight;
		
		Edge(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int K = Integer.parseInt(br.readLine()); // 시작 정점
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>(); // 인접리스트
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<Edge>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Edge(v, w)); // u에서 v까지의 가중치는 w
		}
		
		int[] result = dijkstra(graph, K, V);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<result.length; i++) {
			if(result[i] == INF) {
				sb.append("INF\n");
			}
			else {
				sb.append(result[i] + "\n");
			}
		}
		
		System.out.println(sb);
	}
	

	private static int[] dijkstra(ArrayList<ArrayList<Edge>> graph, int start, int V) {
		boolean[] visited = new boolean[V+1]; // 방문처리(0~V)
		int[] distance = new int[V+1]; // 시작지점부터의 거리(0~V)
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight); // 가중치를 기준으로 오름차순
		Arrays.fill(distance, INF);
		
		distance[start] = 0;
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			int curNode = curr.end;
			
			if(visited[curNode]) continue;
			visited[curNode] = true;

      // curNode에 연결되어있는 노드 갱신
			for(Edge e : graph.get(curNode)) {
					if(distance[e.end] > distance[curNode] + e.weight) {
						distance[e.end] = distance[curNode] + e.weight;
						pq.add(new Edge(e.end, distance[e.end]));
					}
			}
		}
		
		return distance;
		
	}


}
