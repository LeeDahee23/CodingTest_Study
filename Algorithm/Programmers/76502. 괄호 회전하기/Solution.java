import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = s;
        for(int i=0; i<s.length(); i++){
            // 문자 회전하기
            str = str.substring(1, str.length()) + str.substring(0, 1);
            
            // 회전한 문자가 올바른 괄호라면 개수 ++
            if(isRight(str)) answer++;
        }
        return answer;
    }
    
    private boolean isRight(String str){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                if(c == ']' && stack.peek() == '[' || c == '}' && stack.peek() == '{' || c == ')' && stack.peek() == '('){
                    stack.pop();
                }else return false;
            }
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
}