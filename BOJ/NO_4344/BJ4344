import java.util.*;

public class BJ4344 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt(); //테스트 케이스의 개수
		int[] arr_N; //N명의 점수
		

		for(int i=0; i<C; i++){
			int N = sc.nextInt(); //학생의 수
			arr_N = new int[N];
			int sum = 0; //점수의 합계
			double cnt = 0;

			for(int j=0; j<N; j++){
				arr_N[j] = sc.nextInt(); //N명의 점수 입력
				sum += arr_N[j];
			}
			
			for(int k=0; k<N; k++){
				if(arr_N[k] > sum/N){
					cnt ++;
				}
			}
			
			System.out.println(String.format("%.3f", cnt/N * 100)+"%");
		}

		sc.close();
	}
}
