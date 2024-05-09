// 효율성 고려 안한 코드
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int n = prices.length;
        
        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(prices[i] > prices[j]){
                    answer[i] = j-i;
                    break;
                }
            }
            if(answer[i] == 0){
                answer[i] = n-1-i;
            }
        }
        
        return answer;
    }
}