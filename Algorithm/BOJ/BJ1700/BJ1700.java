import java.util.*;
import java.io.*;

public class BJ1700 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] names = new int[K];
		int cnt = 0; // 뽑은 플러그 개수
		List<Integer> multiTap = new ArrayList<>(); // 멀티탭에 꽂혀있는 플러그 번호
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			names[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<names.length; i++) {
			int name = names[i];
			
			// 이미 멀티탭에 꽂혀있는 전기용품일 때
			if(multiTap.contains(name)) {
				continue;
			}
			// 멀티탭에 꽂혀있지 않는 전기용품일 때
			else {
				// 멀티탭 자리가 다 찼으면 하나를 뽑아야 함
				if(multiTap.size() >= N) {
					int idx = findFarthest(multiTap, names, i);
					multiTap.remove(idx);
					cnt ++;
					
					multiTap.add(name);
				}
				// 멀티탭 자리가 있으면 바로 꽂음
				else {
					multiTap.add(name);
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
	// list 중 arr의 k번째에서 가장 멀리 떨어져 있는 전기용품의 인덱스 구하기
	private static int findFarthest(List<Integer> list, int[] arr, int k) {
		
		// 끝 인덱스(arr.length-1)에서 떨어진 거리
		int[] distance = new int[list.size()];
		
		for(int i=0; i<list.size(); i++) {
			for(int j=arr.length - 1; j>k; j--) {
				if(list.get(i) == arr[j]) {
					distance[i] = arr.length - j;
				}
			}
		}
		
		// distance가 가장 짧으면 k번째에서 가장 멀리 떨어져 있는 것
		int min = Integer.MAX_VALUE;
		int minIdx = Integer.MAX_VALUE;
		
		for(int i=0; i<distance.length; i++) {
			if(min > distance[i]) {
				minIdx = i;
				min = distance[i];
			}
		}
		
		return minIdx;
		
	}

}
