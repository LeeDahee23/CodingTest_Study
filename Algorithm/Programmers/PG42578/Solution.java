import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        
        // 종류, 의상 개수
        HashMap<String, Integer> map = new HashMap<>();
        
        // hashmap에 종류 별 의상 개수 넣기
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        
        // 모든 조합
        Iterator<Integer> itr = map.values().iterator();
        int answer = 1;
        
        while(itr.hasNext()){
            answer *= itr.next().intValue() + 1;
            
        }
        
        // 모두 입지 않는 경우 제외하기        
        return answer - 1;
    }
}
