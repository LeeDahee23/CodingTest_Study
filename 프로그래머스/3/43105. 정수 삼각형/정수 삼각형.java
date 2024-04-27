class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                // 맨 왼쪽: 위층(i-1, j)에 더하기
                if(j == 0){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }
                // 맨 오른쪽: 위층 왼쪽(i-1, j-1)에 더하기
                else if(j == n-1){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }
                // 그 외: 위층(i-1, j), 위층 왼쪽(i-1, j-1) 중 큰 값에 더하기
                else{
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }
        
        // 맨 마지막 층의 최댓값 return
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, dp[n-1][i]);
        }
        
        return max;
    }
}