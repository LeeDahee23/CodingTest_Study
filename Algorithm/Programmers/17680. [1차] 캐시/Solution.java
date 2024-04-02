import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        HashMap<String, Integer> cache = new HashMap<>();
        
        if(cacheSize == 0){
            return 5 * cities.length;
        }
        
        for(String cityStr : cities){
            String city = cityStr.toUpperCase();

            if(cache.containsKey(city)){
                answer ++;
                cache.put(city, 0);
            }
            else{
                if(cache.size() >= cacheSize){
                    int maxValue = -1;
                    String maxKey = "";
                    for(String key : cache.keySet()){
                        if(cache.get(key) > maxValue){
                            maxValue = cache.get(key);
                            maxKey = key;
                        }
                    }
                    cache.remove(maxKey);
                }
                
                cache.put(city, 0);
                answer += 5;
            }
            
            for(String key : cache.keySet()){
                cache.put(key, cache.get(key) + 1);
            }
        }
        
        return answer;
    }
}