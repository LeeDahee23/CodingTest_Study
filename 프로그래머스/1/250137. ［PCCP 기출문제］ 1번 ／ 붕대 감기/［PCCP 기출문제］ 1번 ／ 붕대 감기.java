class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curHealth = health;
        int attacksIdx = 0;
        int successTime = 0;
        
        // 1초씩 증가하면서 체력을 회복할건데
        for(int i=0; ; i++){
            // attacksIdx가 attacks 길이만해지면 끝
            if(attacksIdx == attacks.length) break;
            if(curHealth <= 0) break;
        
            // 현재 시간 == attacks 시간이 되면
            if(i == attacks[attacksIdx][0]){
                // 체력을 깎기
                curHealth -= attacks[attacksIdx][1];
                // 연속 성공 시간 = 0
                successTime = 0;
                attacksIdx ++;
            }
            // 아니라면
            else{
                // 최대 체력까지 체력 증가
                curHealth = Math.min(health, curHealth + bandage[1]);
                // 연속 성공 시간 ++
                successTime ++;
                // 연속 성공 시간이 t라면 체력 += y
                if(successTime == bandage[0]){
                    curHealth = Math.min(health, curHealth + bandage[2]);
                    successTime = 0;
                }
            }
        }
            
        
        // 체력이 0 이하라면 -1 return
        // 아니라면 남은 체력 return
        if(curHealth <= 0) return -1;
        return curHealth;
        
    }
}