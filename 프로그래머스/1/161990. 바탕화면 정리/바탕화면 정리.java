class Solution {
    public int[] solution(String[] wallpaper) {
        final int MAX = Integer.MAX_VALUE;
        final int MIN = Integer.MIN_VALUE;
        int minRow = MAX, maxRow = MIN, minCol = MAX, maxCol = MIN;
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                char c = wallpaper[i].charAt(j);
                
                if(c == '#'){
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        
        int[] answer = {minRow, minCol, maxRow+1, maxCol+1};
        return answer;
    }
}