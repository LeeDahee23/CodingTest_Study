import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int i=0; i<s.length(); i++){
            // 괄호 회전하기
            sb.append(s.charAt(0));
            sb.deleteCharAt(0);
            s = sb.toString();
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