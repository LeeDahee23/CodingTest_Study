import java.util.*;
import java.io.*;

public class BJ1916 {
	
	static final int INF = Integer.MAX_VALUE;	
	static class Node{
		int end;
		int weight;
		
		Node(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(new Node(e, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(graph, start, end, N));
	}
	
	private static int dijkstra(ArrayList<ArrayList<Node>> graph, int start, int end, int N) {
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		Arrays.fill(distance, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		
		distance[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curNode = cur.end;
			
			if(visited[curNode]) continue;
			visited[curNode] = true;
			
			for(Node node : graph.get(curNode)) {
				if(!visited[node.end]) {
					if(distance[node.end] > distance[curNode] + node.weight) {
						distance[node.end] = distance[curNode] + node.weight;
						pq.add(new Node(node.end, distance[node.end]));
					}
				}
			}
		}
		
		return distance[end];
	}
	
}
