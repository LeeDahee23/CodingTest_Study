import java.util.*;

class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i != j && computers[i][j] == 1){
                    graph[i].add(j);
                }
            }
        }
        
        visited = new boolean[n];
        int cnt = 0;
        
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                dfs(i, graph);
                cnt ++;
            }
        }
        
        return cnt;
    }
    
    private void dfs(int start, ArrayList<Integer>[] graph){
        if(!visited[start]){
            visited[start] = true;
            
            for(int i : graph[start]){
                dfs(i, graph);
            }
        }
    }
}