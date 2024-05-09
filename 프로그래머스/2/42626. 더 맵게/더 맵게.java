import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.offer(s);
        }
        
        int answer = 0;
        while(pq.size() > 1){
            int s1 = pq.poll(); // 제일 작은 스코빌
            int s2 = pq.poll(); // 두번째로 작은 스코빌
            
            if(s1 >= K){
                break;
            }
            else{
                int newS = s1 + s2*2;
                pq.offer(newS);
                answer ++;
            }
        }
        
        if(pq.size() >= 1 && pq.peek() < K) answer = -1;
        return answer;
    }
}