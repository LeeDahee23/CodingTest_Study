import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.offer(s);
        }
        
        int answer = 0;
        while(!pq.isEmpty()){
            int s1 = pq.poll();
            if(s1 >= K){
                break;
            }
            if(pq.isEmpty()){
                answer = -1;
                break;
            }
            else{
                int s2 = pq.poll();
                int newS = s1 + s2*2;
                pq.offer(newS);
                answer ++;
            }
        }
        
        return answer;
    }
}