import java.util.*;

class Solution {
    private int defaultMin, defaultFee, unitMin, unitFee;
    public int[] solution(int[] fees, String[] records) {
        // 주차 시간 저장할 map
        HashMap<String, String> in = new HashMap<>(); // 입차시간 기록
        HashMap<String, Integer> map = new HashMap<>(); // 주차시간 저장
        
        defaultMin = fees[0];
        defaultFee = fees[1];
        unitMin = fees[2];
        unitFee = fees[3];
        
        for(String record : records){
            String[] arr = record.split(" ");
            String time = arr[0];
            String carNum = arr[1];
            String inOut = arr[2];
            
            // 입차
            if(inOut.equals("IN")){
                in.put(carNum, time);
            }
            // 출차
            else{
                // carNum에 해당하는 입차시간 가져오기
                String inTime = in.get(carNum);
                // 주차시간 구하기
                int parkingMin = getParkingMin(inTime, time);
                // map에 찾아서 더하기
                map.put(carNum, map.getOrDefault(carNum, 0) + parkingMin);
                // 입차시간 삭제하기
                in.remove(carNum);
            }
        }
        
        // 입차했는데 출차 못한 차량 시간 구하기
        for(String key : in.keySet()){
            int parkingMin = getParkingMin(in.get(key), "23:59");
            map.put(key, map.getOrDefault(key, 0) + parkingMin);
        }
        
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int[] answer = new int[keys.size()];
        
        for(int i=0; i<keys.size(); i++){
            String key = keys.get(i);
            answer[i] = getParkingCost(map.get(key));
        }
        
        return answer;
    }
    
    // 주차 시간 구하기
    private int getParkingMin(String start, String end){
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        
        int startMin = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
        int endMin = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
        
        return endMin - startMin;
    }
    
    // 주차 요금 구하기
    private int getParkingCost(int minute){
        if(minute <= defaultMin){
            return defaultFee;
        }
        else{
            int extraFee = (minute - defaultMin) % unitMin == 0 ? 0 : 1;
            return defaultFee + ((minute - defaultMin) / unitMin + extraFee) * unitFee;
        }
    }
}