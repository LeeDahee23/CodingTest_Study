import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 길이가 짧은 순으로 정렬
        s = s.substring(2, s.length()-2).replace("},{", " ");
        String[] strArr = s.split(" ");
        Arrays.sort(strArr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<strArr.length; i++){
            // strArr를 배열로 만든 다음
            String[] arr = strArr[i].split(",");
            
            // strArr 배열을 돌면서
            for(String str : arr){
                // 숫자가 lsit에 포함되어 있지 않으면 list에 추가
                if(!list.contains(Integer.parseInt(str))) {
                    list.add(Integer.parseInt(str));
                    break;
                }
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}