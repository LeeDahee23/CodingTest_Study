class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int number = 0;
        // 문자열의 길이가 t*m보다 커질 때까지
        while(sb.toString().length() <= t*m){
            // 숫자를 n진법으로 바꿔서 문자열에 붙임
            sb.append(Integer.toString(number++, n));
        }
        

        // 0부터 t까지 m씩 커지면서 문자 붙이기
        String str = sb.toString();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<t*m; i+=m){
            int order = i+p-1;
            
            result.append(str.charAt(order));
        }
        
        return result.toString().toUpperCase();
    }
}