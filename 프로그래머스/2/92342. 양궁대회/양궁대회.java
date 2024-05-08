class Solution {
    private int max;
    private int[] apeach;
    private int[] maxArr;
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;
        getAns(n, 0, new int[11]);
        
        return max == 0 ? new int[]{-1} : maxArr;
    }
    
    private void getAns(int n, int idx, int[] ryan){
        if(n == 0){
            calculateDiff(ryan);
            return;
        }
        
        for(int i=idx; i<11; i++){
            int cnt = Math.min(n, apeach[i] + 1);
            ryan[i] = cnt;
            getAns(n - cnt, i+1, ryan);
            ryan[i] = 0;
        }
    }
    
    private void calculateDiff(int[] ryan){
        int score = getRyanScore(ryan);
        if(max < score){
            max = score;
            maxArr = ryan.clone();
        }
        else if(max > 0 && max == score){
            for(int i=10; i>=0; i--){
                if(maxArr[i] != ryan[i]){
                    if(maxArr[i] < ryan[i]){
                        maxArr = ryan.clone();
                    }
                    break;
                }
                
                
            }
        }
    }
    
    private int getRyanScore(int[] ryan){
        int ryanScore = 0;
        for(int i=0; i<11; i++){
            if(ryan[i] + apeach[i] > 0){
                ryanScore += ryan[i] > apeach[i] ? 10-i : -(10-i);
            }
        }
        
        return ryanScore;
    }
}