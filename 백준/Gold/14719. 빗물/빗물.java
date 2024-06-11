import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] board = new int[H][W];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<height; j++) {
				board[H-1-j][i] = 1;
			}
		}
		
		int total = 0, cnt = 0;
		boolean start = false;
		for(int i=H-1; i>=0; i--) {
			start = false;
			cnt = 0;
			
			for(int j=0; j<W; j++) {
				if(board[i][j] == 1) {
					if(!start)
						start = true;
					else {
						total += cnt;
						cnt = 0;
					}
				}
				else {
					if(start)
						cnt ++;					
				}
					
			}
		}
		
		System.out.println(total);
		
	}

}
