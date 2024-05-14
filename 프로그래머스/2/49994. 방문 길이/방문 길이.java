import java.util.*;

class Dir{
    int x, y;
    Dir(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    private int[][] board = new int[11][11];
    public int solution(String dirs) {
        HashMap<Character, Dir> map = new HashMap<>();
        map.put('U', new Dir(-1, 0));
        map.put('D', new Dir(1, 0));
        map.put('L', new Dir(0, -1));
        map.put('R', new Dir(0, 1));
        
        HashSet<String> set = new HashSet<>();
        
        int x = 5, y = 5;
        for(int i=0; i<dirs.length(); i++){
            char c = dirs.charAt(i);
            Dir dir = map.get(c);
            
            int nx = x + dir.x;
            int ny = y + dir.y;
            
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