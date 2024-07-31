import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> name_rank = new HashMap<>();
        Map<Integer, String> rank_name = new HashMap<>();
        for(int i=0; i<players.length; i++){
            String player = players[i];
            name_rank.put(player, i);
            rank_name.put(i, player);
        }
        
        for(String calling : callings){
            int rank = name_rank.get(calling);
            
            // 앞 순서 선수의 이름
            String prePlayer = rank_name.get(rank-1);
            
            // 앞 선수와 현재 선수의 순위를 변경
            name_rank.put(calling, rank-1);
            name_rank.put(prePlayer, rank);
            rank_name.put(rank-1, calling);
            rank_name.put(rank, prePlayer);
        }
        
        ArrayList<Integer> key = new ArrayList<>(rank_name.keySet());
        Collections.sort(key);
        String[] answer = new String[players.length];
        for(int i=0; i<key.size(); i++){
            answer[i] = rank_name.get(key.get(i));
        }
        
        return answer;
    }
}