import java.util.*;

class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int[] arr = {1, -1};
        ArrayList<Integer> ops = new ArrayList<>();
        
        findNum(arr, ops, numbers.length, numbers);
        for(int num : list){
            if(num == target) answer ++;
        }
        
        return answer;
    }
    
    private void findNum(int[] arr, ArrayList<Integer> ops, int N, int[] numbers){
        if(ops.size() == N){
            int sum = 0;
            
            for(int i=0; i<N; i++){
                sum += ops.get(i) * numbers[i];
            }
            
            list.add(sum);
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            ops.add(arr[i]);
            findNum(arr, ops, N, numbers);
            ops.remove(ops.size()-1);
        }
    }
}