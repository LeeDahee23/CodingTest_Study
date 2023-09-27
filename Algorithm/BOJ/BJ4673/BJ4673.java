public class BJ4673 {
	public static void main(String[] args) {
		boolean[] check = new boolean[10001];

		for(int i=1; i<10001; i++){
			int k = dnum(i);

			if(k < 10001)
				check[k] = true;
		}

		StringBuilder sb = new StringBuilder();

		for(int i=1; i<10001; i++){
			if(!check[i]){
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);

	}

	public static int dnum(int num){
		int sum = num;

		while(num != 0){
			sum = sum + (num%10);
			num = num/10;
		}

		return sum;

	}
}
