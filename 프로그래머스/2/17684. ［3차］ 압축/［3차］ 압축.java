import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 정답을 넣을 list answer
        ArrayList<Integer> answer = new ArrayList<>();
        // 사전 만들기(A~Z)
        int number = 1;
        HashMap<String, Integer> dict = new HashMap<>();
        for(int i=0; i<26; i++){
            String word = Character.toString('A' + i);
            dict.put(word, number++);
        }
        
        StringBuilder sb = new StringBuilder();
        int output = 0, idx = 0;
        // msg를 한글자씩 읽을 건데, idx가 msg 길이를 넘어설때까지
        while(idx < msg.length()){
            // 현재까지의 단어에 글자 붙이기
            sb.append(msg.substring(idx, idx+1));
            String cur = sb.toString();

            // 현재까지의 단어가 사전에 있다면
            if(dict.containsKey(cur)){
                // output에 저장
                output = dict.get(cur);
                // idx를 1 올리기
                idx ++;
            }
                
            // 없다면
            else{
                // output을 answer에 넣기
                answer.add(output);
                // 현재까지의 단어를 사전에 등록하기
                dict.put(cur, number++);
                // 단어 빈 문자열로 초기화
                sb = new StringBuilder();
            }
        }
        
        answer.add(output);
            
        
        // answer 배열로 변환해서 리턴
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}