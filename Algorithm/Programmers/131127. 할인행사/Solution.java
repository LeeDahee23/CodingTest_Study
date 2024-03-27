import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int m=0; m<number.length; m++){
            map.put(want[m], number[m]);
        }
        
        for(int i=0; i<10; i++){
            if(map.containsKey(discount[i])){
                map.put(discount[i], map.get(discount[i]) - 1);    
            }
        }
        
        if(isPossible(map)) answer ++;
        
        for(int i=10; i<discount.length; i++){
            String left = discount[i-10];
            String right = discount[i];
            
            // right는 개수에서 빼고
            if(map.containsKey(right)){
                map.put(right, map.get(right) - 1);
            }
            // left는 개수에서 추가함
            if(map.containsKey(left)){
                map.put(left, map.get(left) + 1);
            }
            
            // 모두 0이면 개수 ++
            if(isPossible(map)) answer ++;
        }

        return answer;
    }
    
    private boolean isPossible(HashMap<String, Integer> map){
        boolean isPossible = true;
        for(String key : map.keySet()){
            if(map.get(key) > 0){
                isPossible = false;
                break;
            }
        }
        
        return isPossible;
    }
}