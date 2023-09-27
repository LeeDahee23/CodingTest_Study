import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // participant 이름, 명 수 구하기
        int i;
        int number = 0;
        for(i=0;i<participant.length;i++){
            if(map.containsKey(participant[i])){
                
                number = map.get(participant[i]); 
                number++;
                map.put(participant[i], number);
            }
                
            else
                map.put(participant[i], 1);
        }
       
        // completion 한 명씩 빼기
        for(i=0; i<completion.length;i++){
            map.put(completion[i], map.get(completion[i])-1);
                          
        }
        
        // map 돌면서 value값이 0보다 큰 사람 이름 return
        for(String name : map.keySet()){
            if(map.get(name)>0)
                answer = name;
        }
        
        
        return answer;
    }
}
