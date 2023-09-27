import java.util.*;
import java.io.*;

public class BJ14719 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<height; j++) {
				map[(H-1)-j][i] = 1;
			}
		}
		
		// 왼쪽 줄부터 하나씩 위에서 살펴볼 거
		for(int i=0; i<W; i++) {
			int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
			
			// 현재값이 1인 것에서 오른쪽으로 살펴볼 것. 
			// 현재 1인 위치에서 다음 1인 위치까지 2로 바꾸기
			for(int j=0; j<H; j++) {
				// 1을 처음으로 마주친 가로 위치가 left
				if(map[j][i] == 1) {
					left = i;
					
					// left 이후로 처음 마주친 1의 가로 위치가 right
					for(int k=left+1; k<W; k++) {
						if(map[j][k] == 1) {
							right = k;
							break;
						}
					}
					
					// left와 right 사이를 2(빗물)로 바꿔줌
					for(int k=left+1; k<right; k++) {
						map[j][k] = 2;
					}
				}
			}
		}
		
		// 2의 개수 count
		int cnt = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j] == 2) {
					cnt ++;
				}
			}
		}
		
		System.out.println(cnt);

	}

}
