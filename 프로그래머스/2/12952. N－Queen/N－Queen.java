class Solution {
    private int N;
    private boolean[] width;
    private boolean[] diagonal1;
    private boolean[] diagonal2;
    
    private int getAns(int y){
        int answer = 0;
        if(y == N){
            answer ++;
        }
        else{
            for(int i=0; i<N; i++){
                if(width[i] || diagonal1[i+y] || diagonal2[i-y+N]){
                    continue;
                }
                width[i] = diagonal1[i+y] = diagonal2[i-y+N] = true;
                answer += getAns(y+1);
                width[i] = diagonal1[i+y] = diagonal2[i-y+N] = false;
            }
        }
        
        return answer;
    }
    
    public int solution(int n) {
        N = n;
        width = new boolean[n];
        diagonal1 = new boolean[n*2];
        diagonal2 = new boolean[n*2];
        int answer = getAns(0);
        return answer;
    }
}