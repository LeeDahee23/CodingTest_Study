import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        answer[n-1] = -1;
        
        Stack<Integer> s = new Stack<>();
        s.push(numbers[n-1]);
        
        for(int i=n-1; i>=0; i--){
            int number = numbers[i];
            answer[i] = -1;
            
            while(!s.isEmpty()){
                int top = s.pop();
                
                if(top > number){
                    answer[i] = top;
                    s.push(top);
                    break;
                }
            }
            
            s.push(number);
        }
        
        
        return answer;
    }
}