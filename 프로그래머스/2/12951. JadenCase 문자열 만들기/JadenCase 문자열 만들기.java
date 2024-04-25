class Solution {
    public String solution(String s) {
        s = s.substring(0,1).toUpperCase() + s.substring(1, s.length());
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        
        for(int i=1; i<s.length(); i++){
            char c = s.charAt(i);
            c = Character.toLowerCase(c);
            
            if(s.charAt(i-1) == ' '){
                c = Character.toUpperCase(c);
            }
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}