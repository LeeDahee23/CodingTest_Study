import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;
        // map으로 사람들의 번호를 지정(이름, 번호)
        HashMap<String, Integer> numbers = new HashMap<>();
        for(int i=0; i<friends.length; i++){
            numbers.put(friends[i], i);
        }
        
        // 사람 수만큼의 크기인 이차원 배열 생성 -> 주고받은 선물 개수(row가 col에게 준 선물 개수)
        int[][] count = new int[N][N];
        // 선물 지수 배열 만들기
        int[][] giftIdx = new int[N][2]; // give, get
        
        for(String gift : gifts){
            String[] input = gift.split(" ");
            // input[0]이 give input[1]이 get
            int give = numbers.get(input[0]);
            int get = numbers.get(input[1]);
            
            // 선물 개수 올리기
            count[give][get] += 1;
            // 선물 지수 구하기
            giftIdx[give][0] += 1;
            giftIdx[get][1] += 1;
        }
        
        int[] nextCount = new int[N];
        // friends 돌면서
        for(int i=0; i<friends.length; i++){
            for(int j=i; j<friends.length; j++){
                // 개수가 큰 사람 다음달 받을 선물 ++
                if(count[i][j] > count[j][i]){
                    nextCount[i] += 1;
                }else if(count[i][j] < count[j][i]){
                    nextCount[j] += 1;
                }
                // 개수가 같으면 선물 지수 비교해서 큰 사람 선물 ++
                else{
                    int giftIdx_i = giftIdx[i][0] - giftIdx[i][1];
                    int giftIdx_j = giftIdx[j][0] - giftIdx[j][1];
                    
                    if(giftIdx_i > giftIdx_j) nextCount[i] += 1;
                    else if(giftIdx_i < giftIdx_j) nextCount[j] += 1;
                }
                
            }
        }
        
        int max = 0;
        for(int i=0; i<nextCount.length; i++){
            max = Math.max(nextCount[i], max);
        }
        
        return max;
            
        
    }
}