import java.util.*;
import java.io.*;

public class Main {
	public static class Node{
		int clipboard;
		int total;
		int time;
		
		public Node(int clipboard, int total, int time) {
			this.clipboard = clipboard;
			this.total = total;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[1001][1001]; // [clipboard][전체]
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 1, 0));
		visited[0][1] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.total == S) {
				System.out.println(cur.time);
				break;
			}
			
			// 현재 이모티콘 모두 복사해서 클립보드에 저장
			q.offer(new Node(cur.total, cur.total, cur.time + 1));
			
			// 클립보드에 잇는 이모티콘 붙여넣기
			if(cur.clipboard > 0 && cur.total + cur.clipboard <= S && !visited[cur.clipboard][cur.total + cur.clipboard]) {
				q.offer(new Node(cur.clipboard, cur.total + cur.clipboard, cur.time+1));
				visited[cur.clipboard][cur.clipboard + cur.total] = true;
			}
			
			// 화면 이모티콘 중 하나 삭제
			if(cur.total > 0 && !visited[cur.clipboard][cur.total-1]) {
				q.offer(new Node(cur.clipboard, cur.total - 1, cur.time+1));
				visited[cur.clipboard][cur.total-1] = true;
			}
		}
		
		
	}

}
