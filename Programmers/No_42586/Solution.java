import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
                
        // 1. 남은 작업 진도를 저장할 큐
        Queue<Integer> queue = new LinkedList<>();
        
        // 2. 큐에 남은 작업 진도 저장하기
        for(int i=0; i<progresses.length; i++){
            queue.add((100-progresses[i])/speeds[i] + ((100-progresses[i])%speeds[i] == 0 ? 0 : 1));
        }
        
        // 3. 남은 작업 진도 두 개를 비교하여 앞이 더 큰 경우의 수를 cnt에 저장하기
        int cnt = 1;
        int a = queue.poll();
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int b = queue.poll();
            if(a>=b)
                cnt ++;
            else{
                arr.add(cnt);
                a = b;
                cnt = 1;
            }
        }
        arr.add(cnt);
        
        // 4. arr을 배열로 변환하기
        int[] answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
