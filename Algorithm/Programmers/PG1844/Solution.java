import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        
        while(!q.isEmpty()){
            int[] n = q.poll();
            int x = n[0];
            int y = n[1];
            
            if(x==maps.length - 1 && y==maps[0].length - 1) {
                return maps[x][y];
            }
                
            for(int i=0; i<dx.length; i++){
                int nx = n[0] + dx[i];
                int ny = n[1] + dy[i];
                
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length && maps[nx][ny]==1){
                                       
                    maps[nx][ny] += maps[x][y];
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return -1;
    }
}