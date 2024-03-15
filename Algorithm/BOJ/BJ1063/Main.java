import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String kingStr = st.nextToken();
		String rockStr = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		// 열 행: 1부터 시작
		int[] king = {kingStr.charAt(0) - 'A' + 1, kingStr.charAt(1) - '0'};
		int[] rock = {rockStr.charAt(0) - 'A' + 1, rockStr.charAt(1) - '0'};
		
		HashMap<String, int[]> map = new HashMap<>();
		map.put("B", new int[]{0, -1});
		map.put("R", new int[]{1, 0});
		map.put("L", new int[]{-1, 0});
		map.put("T", new int[]{0, 1});
		map.put("RT", new int[]{1, 1});
		map.put("LT", new int[]{-1, 1});
		map.put("RB", new int[]{1, -1});
		map.put("LB", new int[]{-1, -1});
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			int[] move = map.get(s);
			
			// king 이동시 넘어선다면
			if(king[0]+move[0] <= 0 || king[0]+move[0] > 8 || king[1]+move[1] <= 0 || king[1]+move[1] > 8) {
				continue;
			}
			// king 이동과 rock 위치가 같고 rock 이동이 범위 벗어나면
			else if(king[0]+move[0] == rock[0] && king[1]+move[1] == rock[1] &&
					(rock[0]+move[0] <= 0 || rock[0]+move[0] > 8 || rock[1]+move[1] <= 0 || rock[1]+move[1] > 8)) {
				continue;
			}
			// 둘다 안벗어나면
			else {
				king[0] += move[0];
				king[1] += move[1];
				
				// king 이동한 위치, rock 위치가 같다면 rock을 move 방향으로 한칸 이동
				if(king[0] == rock[0] && king[1] == rock[1]) {
					rock[0] += move[0];
					rock[1] += move[1];
				}
			}
		}
		// 열도 1부터 시작했으니까 'A'부터 시작하기 위해 1 빼줌
		System.out.println((char)(king[0] + 'A' -1) + "" + king[1]);
		System.out.println((char)(rock[0] + 'A' -1) + "" + rock[1]);

	}
}
