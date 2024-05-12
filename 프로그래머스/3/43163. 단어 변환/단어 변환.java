import java.util.*;

class Word{
    String word;
    int cnt;
    
    Word(String word, int cnt){
        this.word = word;
        this.cnt = cnt;
    }
}

class Solution {
    private int answer = 0;
    public int solution(String begin, String target, String[] words) {
        find(words, begin, target);
        return answer;
    }
    
    private void find(String[] words, String start, String target){
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        q.add(new Word(start, 0));
        
        while(!q.isEmpty()){
            Word now = q.poll();
            
            if(target.equals(now.word)){
                answer = now.cnt;
                break;
            }
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && isDiffOnlyOne(now.word, words[i])){
                    visited[i] = true;
                    q.add(new Word(words[i], now.cnt + 1));
                    
                }
            }
        }
        
    }
    
    private boolean isDiffOnlyOne(String word1, String word2){
        int cnt = 0;
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                cnt ++;
            }
        }
        
        return cnt == 1 ? true : false;
    }
}