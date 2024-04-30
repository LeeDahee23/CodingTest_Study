class Solution {
    public int solution(int n, int k) {
        String[] arr = Integer.toString(n, k).split("0");
        
        int answer = 0;
        for(String str : arr){
            if(str.length() <= 0) continue;
            
            if(isPrime(Long.parseLong(str))){
                answer ++;
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(long n){
        if(n < 2) return false;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        
        return true;
    }
}