import java.util.*;
import java.io.*;

public class BJ14888 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] op = new int[4]; // 연산자
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<op.length; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		find(nums, op, nums[0], 1);
		
		System.out.println(max);
		System.out.println(min);
		
	}

  // nums:숫자 배열, op:연산자 배열, result:계산 결과, depth:계산 몇개 했는지
	private static void find(int[] nums, int[] op, int result, int depth) {
		if(depth == nums.length) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i=0; i<op.length; i++) {
			if(op[i] > 0) { // 연산자 갯수가 남아있으면
				op[i] --;
				find(nums, op, calculate(result, nums[depth], i), depth + 1);
				op[i] ++;
			}
		}
		
	}
	
	private static int calculate(int num1, int num2, int opIdx) {
		int result = Integer.MIN_VALUE;
		if(opIdx == 0) {
			result = num1 + num2;
		}else if(opIdx == 1) {
			result = num1 - num2;
		}else if(opIdx == 2) {
			result = num1 * num2;
		}else if(opIdx == 3) {
			result = num1 / num2;
		}
	
		return result;
	}
	
}
