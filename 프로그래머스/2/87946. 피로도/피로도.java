class Solution {
    private int max = 0;
    private int[][] Dungeons;
    public int solution(int k, int[][] dungeons) {
        Dungeons = dungeons;
        boolean[] visited = new boolean[dungeons.length];
        findMaxDungeons(k, visited, 0);
        return max;
    }
    
    private void findMaxDungeons(int cur, boolean[] visited, int cnt){
        if(cnt > max){
            max = cnt;
        }
        
        for(int i=0; i<Dungeons.length; i++){
            int minPirodo = Dungeons[i][0];
            int usedPirodo = Dungeons[i][1];
            
            if(!visited[i] && cur >= minPirodo){
                visited[i] = true;
                findMaxDungeons(cur-usedPirodo, visited, cnt+1);
                visited[i] = false;
            }
        }
    }
}