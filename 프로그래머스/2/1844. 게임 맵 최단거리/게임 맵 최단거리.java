import java.util.*;

class Node{
    int x, y, dis;
    public Node(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Solution {    
    public int solution(int[][] maps) {
        return findMinDistance(maps);
    }
    
    private int findMinDistance(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        maps[0][0] = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.x == n-1 && now.y == m-1){
                return now.dis;
            }
            
            for(int i=0; i<dx.length; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny]==1){
                    q.add(new Node(nx, ny, now.dis + 1));
                    maps[nx][ny] = 0;
                }
            }
        }
        
        return -1;
    }
}