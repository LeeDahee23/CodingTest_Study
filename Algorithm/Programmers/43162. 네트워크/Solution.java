import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        // computers를 돌면서
        for(int i=0; i<computers.length; i++){
            // i번 컴퓨터에 방문한 적 없다면
            if(!visited[i]){
                // i번 컴퓨터에서 연결된 컴퓨터 bfs로 찾기
                queue.add(i);
                // visited[i] = true;
                answer ++;
                
                while(!queue.isEmpty()){
                    int com = queue.poll();
                    
                    for(int j=0; j<computers[com].length; j++){
                        if(j != com && !visited[j] && computers[com][j] == 1){
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
                
            
        }
            
        
        return answer;
    }
}