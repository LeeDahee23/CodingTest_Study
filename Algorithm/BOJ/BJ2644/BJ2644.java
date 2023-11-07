import java.util.*;
import java.io.*;

public class BJ2644 {
	static int result = -1;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		boolean[] visited = new boolean[n+1];
		findRelatives(graph, visited, start, end, 0);
		
		System.out.println(result);
	}
	
	private static void findRelatives(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int start, int end, int depth) {
		visited[start] = true;
		
		if(start == end) {
			result = depth;
			return;
		}
		
		for(int node : graph.get(start)) {
			if(!visited[node]) {
				findRelatives(graph, visited, node, end, depth + 1);
			}
		}
	}

}
