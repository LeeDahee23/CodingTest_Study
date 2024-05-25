import java.util.*;
import java.io.*;

public class Main {
	private static int[][] laptop;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		laptop = new int[N][M];
		int total = 0;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[R][C]; // 스티커: 1, 스티커x: 0

			for (int a = 0; a < R; a++) {
				st = new StringTokenizer(br.readLine());
				for (int b = 0; b < C; b++) {
					sticker[a][b] = Integer.parseInt(st.nextToken());
				}
			}

			// 0, 90, 180, 270도 확인
			rotate:
			for (int j = 0; j < 4; j++) {
				if(j != 0) {
					sticker = rotate(sticker);
				}
				
				// laptop에 해당 스티커를 붙일 수 있는 위치를 위쪽 왼쪽에서 찾기
				for (int a = 0; a <= N - sticker.length; a++) {
					for (int b = 0; b <= M - sticker[0].length; b++) {
						// 다른 스티커와 겹치거나 범위를 벗어나면 끝
						if (isOverlap(a, b, sticker)) {
							continue;
						}

						// 붙일 수 있는 곳이 있다면 laptop에 붙이기
						// 개수 ++
						// 회전 반복문 탈출
						int cnt = attach(a, b, sticker);
						total += cnt;
						break rotate;
					}
				}
				// 붙일 수 있는 곳이 없다면 90도 회전
			}
		}
		
		System.out.println(total);
	}

	private static int attach(int x, int y, int[][] sticker) {
		int row = sticker.length;
		int col = sticker[0].length;
		int cnt = 0;

		for (int i = x; i < x + row; i++) {
			for (int j = y; j < y + col; j++) {
				if (sticker[i - x][j - y] == 1) {
					laptop[i][j] = 1;
					cnt++;
				}
			}
		}

		return cnt;
	}

	// 90도 회전하는 함수
	private static int[][] rotate(int[][] sticker) {
		int row = sticker.length;
		int col = sticker[0].length;

		int[][] newSticker = new int[col][row];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				newSticker[j][row - 1 - i] = sticker[i][j];
			}
		}

		return newSticker;
	}

	// 맨왼쪽위 칸이 x,y일 때 스티커가 겹치는지 확인하는 함수
	private static boolean isOverlap(int x, int y, int[][] sticker) {
		int row = sticker.length;
		int col = sticker[0].length;

		for (int i = x; i < x + row; i++) {
			for (int j = y; j < y + col; j++) {
				if (sticker[i - x][j - y] == 1 && laptop[i][j] == 1) {
					return true;
				}
			}
		}

		return false;
	}
}
