import java.util.*;

public class BJ1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		
		int num = 1, sum = 0; //num은 그룹의 번호, sum은 그룹의 끝 번호
		int a = 1, b = 1; //a는 분자, b는 분모
		
		
		//X가 속하는 그룹의 번호 num 구하기
		while(true) {
			sum += num;
			if(X <= sum) 
				break;
			num++;
		}
	
		
		//num이 짝수일 때는 내려감
		if(num%2 == 0) {
			a = num - (sum - X);
			b = num - a + 1;
		}
		//num이 홀수일 때는 올라감
		else if(num%2 == 1){
			b = num - (sum - X);
			a = num - b + 1;
		}
		
		System.out.println(a + "/" + b);
		
		
		sc.close();
		
		
	}
	
	
}
