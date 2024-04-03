import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
              
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            int remain = 100 - progresses[i];
            int day = (remain % speeds[i] == 0 ? remain / speeds[i] : remain / speeds[i] + 1);
            
            queue.add(day);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt = 1, last = queue.poll();
        while(!queue.isEmpty()){
            int next = queue.poll();
            
            if(next > last){
                answer.add(cnt);
                cnt = 1;
                last = next;
            }else cnt++;
        }
        
        answer.add(cnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}