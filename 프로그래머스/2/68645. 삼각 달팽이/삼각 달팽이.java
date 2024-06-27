import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, -1}};
        int[][] triangle = new int[n][n];
        int value = 1, dirIdx = 0;
        int curX = 0, curY = 0;
        
        while(true){
            // 종료 조건
            if(value > n*(n+1)/2) break;
            
            // 현재 값 넣기
            triangle[curX][curY] = value++;
            
            // 다음 위치가 범위를 벗어나거나 이미 값이 있다면
            int nextX = curX + dir[dirIdx][0];
            int nextY = curY + dir[dirIdx][1];
            if(nextX<0 || nextX>=n || nextY<0 || nextY>=n || triangle[nextX][nextY] > 0){
                // 방향을 바꿈
                dirIdx = (dirIdx + 1) % 3;
            }
            
            curX += dir[dirIdx][0];
            curY += dir[dirIdx][1];
            
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(triangle[i][j] > 0){
                    answer.add(triangle[i][j]);
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}