import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> subBelt = new Stack<>();
        Queue<Integer> mainBelt = new LinkedList<>();
        int cnt = 0;
        
        for(int i=0; i<order.length; i++){
            subBelt.push(i+1);
            
            while(!subBelt.isEmpty()){
                if(subBelt.peek() == order[cnt]){
                    mainBelt.offer(subBelt.pop());
                    cnt ++;
                }else{
                    break;
                }
            }
        }
        
        
        return mainBelt.size();
        
    }
}