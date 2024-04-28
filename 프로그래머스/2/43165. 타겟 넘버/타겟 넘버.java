import java.util.*;

class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        findNum(numbers, 0, target, 0);
        
        return count;
    }
    
    private void findNum(int[] numbers, int idx, int target, int sum){
        if(idx == numbers.length){
            if(sum == target){
                count ++;
            }
            return;
        }
        
        findNum(numbers, idx + 1, target, sum + numbers[idx]);
        findNum(numbers, idx + 1, target, sum - numbers[idx]);
    }
}