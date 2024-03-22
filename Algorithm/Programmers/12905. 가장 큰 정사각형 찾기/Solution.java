class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] dp = new int[board.length+1][board[0].length+1];
        
        // dp 배열에 옮기기
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dp[i+1][j+1] = board[i][j];
            }
        }
        
        // dp 배열 돌면서
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                // 내가 1이라면
                if(dp[i][j] == 1){
                    // min(왼, 위, 대각선) + 1 한게 나
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    // dp 값의 최댓값 구하기
                    answer = Math.max(answer, dp[i][j]);
                }
                
            }
        }
            
        return answer * answer;
    }
}