import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            long number = numbers[i];
            String bit = Long.toBinaryString(number);
            String result = "";
            
            for(int j=bit.length()-1; j>=0; j--){
                if(bit.charAt(j) == '0'){
                    // 마지막 위치에서 0을 만났음
                    if(j == bit.length()-1){
                        // 마지막 위치만 1로 바꿔줌
                        result = bit.substring(0, bit.length()-1) + "1";
                    }
                    // 마지막이 아닌 위치에서 0을 만났음
                    else{
                        // 0~i-1까지 그대로, i는 1로, i+1은 0으로 i+2~는 그대로
                        result = bit.substring(0, j) + "10" + bit.substring(j+2, bit.length()); 
                    }
                    break;
                }
            }
            
            // 0이 없었음(1밖에 없음)
            if(result.equals(""))
                // 앞에 10을 붙이고 1~을 붙임
                result = "10" + bit.substring(1, bit.length());
            
            answer[i] = Long.valueOf(result, 2);
        }

        
        return answer;
    }
}