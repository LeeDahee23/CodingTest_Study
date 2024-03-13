import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        set.add(words[0]);
        // 배열 돌면서
        for(int i=1; i<words.length; i++){
            String cur = words[i];
            String prev = words[i-1];
            // 이전에 나온적 있거나
            // 앞단어의 끝 글자랑 현재단어의 앞 글자가 다르면 끝남
            if(set.contains(cur) || prev.charAt(prev.length()-1) != cur.charAt(0)){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            else{
                set.add(words[i]);
            }
        }
        return answer;
    }
}