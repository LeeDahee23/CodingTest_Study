class Solution {
    private String[] alphabet = {"A", "E", "I", "O", "U"};
    private int answer = 0;
    private boolean isDone = false;
    
    public int solution(String word) {
        findDict("", word);
        return answer;
    }
    
    private void findDict(String word, String target){
        if(word.equals(target)){
            isDone = true;
            return;
        }
        
        if(word.length() >= 5){
            return;
        }
        
        for(int i=0; i<alphabet.length; i++){
            findDict(word + alphabet[i], target);
            answer ++;
            if(isDone) break;
        }
        
        
    }
}