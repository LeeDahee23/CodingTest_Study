import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        
        // 우선순위큐에 works를 다 넣은 다음에
        for(int work : works){
            pq.offer(work);
        }
        // n이 0이 될때까지
        while(n > 0){
            // works의 최댓값에서 1씩 빼고
            int max = pq.poll();
            max --;
            pq.offer(max);
            
            n--;
        }
            
        // pq의 값을 제곱해서 합하면 됨
        long answer = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            
            if(num < 0) continue;
            answer += Math.pow(num, 2);
        }
        
        return answer;
    }
}