import java.util.*;
import java.io.*;

public class BJ1806 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
		
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
		
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Set<Integer> set = new HashSet<>(); // 부분합이 S보다 크거나 같은 구간의 길이
    int left = 0, right = 0;
    int sum = arr[0];
		
    while(true) {
      // right가 끝지점에 도착했는데, 합이 S보다 작으면 더이상 계산X
      // 어차피 부분합이 줄어들기 때문
      if(right == arr.length-1) {
        if(sum < S) break;
      }
      // 합이 S보다 크거나 같으면 left를 이동(값을 줄이기 위해)
      if(sum >= S) {
        set.add(right - left + 1);
        sum -= arr[left];
        left ++;
      }
      // 합이 S보다 작으면 right를 이동(값을 늘이기 위해)
      else {
        // 범위를 벗어나지 않도록
        if(right < arr.length - 1) {
          right ++;
          sum += arr[right];
        }
      } 
    }

    // set에 아무것도 없으면 S 이상인 부분합을 만들 수 없는 것
    if(set.size() == 0) {
      System.out.println(0);
    }
    // 길이 중 최소 길이를 구함
    else {
      int min = Integer.MAX_VALUE;
      for(int num : set) {
        min = Math.min(min, num);
      }
			
      System.out.println(min);
    }
  }
}
