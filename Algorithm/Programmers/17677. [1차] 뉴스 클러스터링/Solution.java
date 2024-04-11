import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> map1 = findSubString(str1);
        HashMap<String, Integer> map2 = findSubString(str2);
        
        int union = 0, intersection = 0;
        
        for(String s : map1.keySet()){
            if(map2.containsKey(s)){
                intersection += Math.min(map1.get(s), map2.get(s));
                union += Math.max(map1.get(s), map2.get(s));
            }
            else{
                union += map1.get(s);
            }
        }
        for(String s : map2.keySet()){
            if(!map1.containsKey(s)) union += map2.get(s);
        }
        
        double jacad = (map1.size() == 0 && map2.size() == 0) ? 1 : (double)intersection / (double)union;
        int answer = (int)Math.floor(jacad * 65536);
        
        return answer;
    }
    
    private HashMap<String, Integer> findSubString(String str){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<str.length()-1; i++){
            String sub = str.toUpperCase().substring(i, i+2);
            if(sub.charAt(0) >= 65 && sub.charAt(0) <= 90 && sub.charAt(1) >= 65 && sub.charAt(1) <= 90){
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        
        return map;
    }
}