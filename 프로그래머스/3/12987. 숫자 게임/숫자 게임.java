import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<B.length; i++){
            que.offer(B[i]);
        }
        
        int answer = 0;
        for(int i=0; i<A.length;){
            if(que.isEmpty()) break;
            
            if(A[i] < que.peek()){
                i++;
                answer ++;
            }
             que.poll();
        }
            
        return answer;
    }
}