import java.util.*;

class Solution {
    
    long max = Integer.MIN_VALUE;
    
    public long solution(String expression) {
        String[] priority = {"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};
        
        // 연산자와 피연산자를 나눠서 리스트에 저장
        List<Long> operand = new ArrayList<>();
        List<Character> operator = new ArrayList<>();
        
        int idx = 0;
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            
            // 지금 보고 있는게 숫자라면
            if(c-'0' >= 0 && c-'0' <= 9){
                continue;
            }
            else{
                operand.add(Long.parseLong(expression.substring(idx, i)));
                operator.add(c);
                idx = i + 1;
            }
        }
        
        operand.add(Long.parseLong(expression.substring(idx, expression.length())));
           
        // 모든 우선순위에 대해 연산하기
        for(String str : priority){
            List<Long> arr1 = new ArrayList<>(operand);
            List<Character> arr2 = new ArrayList<>(operator);
            calculate(str, arr1, arr2);
        }
        
        return max;
    }
    
    // 우선순위에 따라 연산을 해주는 함수
    // priority: 연산자 우선순위, operand: 피연산자, operator: 연산자
    private void calculate(String priority, List<Long> operand, List<Character> operator){
        char[] priArr = priority.toCharArray();
        
        // 연산자 우선순위 높은 것부터 연산
        for(char op : priArr){
            for(int i=0; i<operator.size();){
                // 현재 우선순위의 연산자라면 -> 계산하기
                if(operator.get(i) == op){
                    long num1 = operand.get(i);
                    long num2 = operand.get(i+1);
                    
                    // 연산한 결과를 피연산자로 바꾸기
                    long result = operation(num1, num2, operator.get(i));
                    operand.set(i, result);
                    
                    operand.remove(i+1);
                    operator.remove(i);
                    
                }
                // 현재 우선순위의 연산자가 아니라면 -> 다음으로 넘어가기
                else{
                    i ++;
                    continue;
                }
            }
        }
        
        // 연산이 다 끝나고 나면 피연산자에 값이 하나 남아있음 -> 전체 연산 결과
        max = Math.max(max, Math.abs(operand.get(0)));
    }
    
    // 연산
    private long operation(long num1, long num2, char operator){
        if(operator == '+'){
            return num1 + num2;
        }
        else if(operator == '*'){
            return num1 * num2;
        }
        else if(operator == '-'){
            return num1 - num2;
        }
        return 0;
    }
}
