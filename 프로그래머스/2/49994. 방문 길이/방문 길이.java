import java.util.*;
class Solution {
    private int[][] board = new int[11][11];
    public int solution(String dirs) {
        HashMap<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{-1, 0});
        map.put('D', new int[]{1, 0});
        map.put('L', new int[]{0, -1});
        map.put('R', new int[]{0, 1});
        
        HashSet<String> set = new HashSet<>();
        
        int x = 5, y = 5;
        for(int i=0; i<dirs.length(); i++){
            char c = dirs.charAt(i);
            int[] dir = map.get(c);
            
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if(nx>=0 && nx<board.length && ny>=0 && ny<board.length){
                set.add(x + " " + y + " " + nx + " " + ny);
                set.add(nx + " " + ny + " " + x + " " + y);
                x = nx;
                y = ny;
            }
        }
        
        return set.size() / 2;
    }
}