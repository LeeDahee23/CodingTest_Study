class Solution {
    public int[] solution(String s) {
        int total = 0, cnt = 0;
        while(s.length() > 1){
            // 0 제거
            String noZero = deleteZero(s);
            int oneCnt = noZero.length();
            total += (s.length() - oneCnt);
            
            // s길이를 2진법으로 표현한 문자열로 s 바꾸기
            s = Integer.toBinaryString(oneCnt);
            cnt ++;
        }
        
        int[] answer = {cnt, total};
        return answer;
    }
    
    private String deleteZero(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1') {
                sb.append("1");
            }
        }
        
        return sb.toString();
    }
}