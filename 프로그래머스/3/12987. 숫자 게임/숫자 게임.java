import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        for(int i=0, j=0; j<B.length; j++){
            if(A[i] < B[j]){
                answer ++;
                i ++;
            }
        }
            
        return answer;
    }
}