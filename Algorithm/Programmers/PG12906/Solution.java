import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 1. arr를 저장할 큐
        Queue<Integer> queue = new LinkedList<>();
        
        // 2. arr을 큐에 저장하기
        for(int i=0; i<arr.length; i++){
            queue.add(arr[i]);
        }
        
        // 3. 큐에서 두 개씩 비교하면서 서로 다른 값일 때 arraylist에 넣기
        ArrayList<Integer> arr2 = new ArrayList<>();
        int a = queue.poll();
        while(!queue.isEmpty()){
            int b = queue.poll();
            if(a != b)
                arr2.add(a);
            a = b;
        }
        arr2.add(a);
        
        // 4. arraylist를 배열로 변환
        int[] answer = new int[arr2.size()];        
        for(int i=0; i<arr2.size(); i++){
            answer[i] = arr2.get(i);
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        
        
        return answer;
    }
}
