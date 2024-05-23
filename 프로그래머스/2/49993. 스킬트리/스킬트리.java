import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0; i<skill.length(); i++){
            list.add(skill.charAt(i));
        }
        
        int count = 0;
        for(String skillTree : skill_trees){
            if(isPossible(list, skillTree)){
                count ++;
            }
        }
        
        return count;
    }
    
    private boolean isPossible(ArrayList<Character> list, String skillTree){
        boolean[] studied = new boolean[list.size()];
        for(int i=0; i<skillTree.length(); i++){
            char c = skillTree.charAt(i);
            
            if(!list.contains(c)) continue;
            
            // c의 선행 스킬을 배웠는지 확인함
            for(int j=0; j<list.indexOf(c); j++){
                // 선행 스킬 안배웠으면 return false
                if(!studied[j]){
                    return false;
                }
            }
            
            studied[list.indexOf(c)] = true;
            
        }
        
        return true;
    }
}