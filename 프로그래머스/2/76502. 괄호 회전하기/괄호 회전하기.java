import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            s = s.substring(1, s.length()) + s.substring(0, 1);
            if(isRight(s)){
                answer ++;
            }
        }
        
        return answer;
    }
    
    private boolean isRight(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            // 열린 괄호
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            }
            // 닫힌 괄호
            else {
                if(stack.isEmpty()) 
                    return false;
                else if(c == ']' && stack.peek() == '['){
                    stack.pop();
                }else if(c == '}' && stack.peek() == '{'){
                    stack.pop();
                }else if(c == ')' && stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
}