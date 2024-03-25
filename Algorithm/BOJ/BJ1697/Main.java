import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		int result = 0;
		
		// N부터 시작해서
		queue.add(N);
		visited[N] = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now == K) {
				result = visited[now];
			}
			
			int add = now + 1;
			int minus = now - 1;
			int mul = now * 2;
			
			if(add >= 0 && add <= 100000 && visited[add] >= visited[now] + 1) {
				queue.add(add);
				visited[add] = visited[now] + 1;
			}
			if(minus >= 0 && minus <= 100000 && visited[minus] >= visited[minus] + 1) {
				queue.add(minus);
				visited[minus] = visited[now] + 1;
			}
			if(mul >= 0 && mul <= 100000 && visited[mul] >= visited[now] + 1) {
				queue.add(mul);
				visited[mul] = visited[now] + 1;
			}
		}
		
		System.out.println(result);
	}

}
