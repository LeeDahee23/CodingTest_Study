```
해결🔺, dp
```

# 문제

포도주 잔이 n개 주어지고 최대 연속 3잔까지만 마실 수 있을 때, 최대로 마실 수 있는 포도주의 양을 구하시오.

### 제한사항

- 1 <= n <= 10,000
- 포도주의 양은 1,000 이하의 음이 아닌 정수

# 풀이

연속 3잔까지는 안되고 포도주의 최대량을 구해야하기 때문에 아래 경우가 가능하다. i번째 잔까지의 최대 포도주량은 아래 중 최댓값이 된다.

1. i번째 포도주를 마시려면
   1. i-1번째 O, i-2번째 X, i-3번째까지의 최대 포도주
   2. i-1번째 X, i-2번째까지의 최대 포도주
2. i번째 포도주를 안마신다면
   1. i-1번째까지의 최대 포도주

위 내용을 점화식으로 나타내면

> dp[i] = Math.max(Math.max(dp[i-3] + wines[i-1], dp[i-2]) + wines[i], dp[i-1])

### 시도1

n 크기의 배열 wines에 0부터 순서대로 입력 받고, `dp[0]=wines[0]`, `dp[1] = wines[0] + wines[1]`로 한다. n이 1부터 가능하기 때문에 n이 1이라면 인덱스는 0까지, n이 2라면 인덱스는 1, n이 3일 때 인덱스는 2까지 가능하다.

따라서 dp[1]는 n이 2 이상일 때, dp[2]는 n이 3 이상일 때 가능하게 된다.
(처음에는 n이 2 이상이면 dp[1], dp[2]로 구했다가 틀렸다.)

dp[2]는 2번 포도주를 마실 경우인 wines[2] + dp[0], wines[2] + wines[1]와 2번 포도주를 안마시는 dp[1] 총 3개 중 최댓값이 된다.

```java
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] wines = new int[n];
		int[] dp = new int[n];

		for(int i=0; i<n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = wines[0];

		if(n >= 2) {
			dp[1] = wines[0] + wines[1];
		}
		if(n >= 3) {
			dp[2] = Math.max(Math.max(dp[0]+wines[2], dp[1]), wines[1]+wines[2]);
		}

		for(int i=3; i<n; i++) {
			dp[i] = Math.max(Math.max(dp[i-2], dp[i-3] + wines[i-1]) + wines[i], dp[i-1]);
		}

		System.out.println(dp[n-1]);

	}

}
```

### 시도2

시도1 방법으로도 풀 수는 있지만 배열의 길이와 인덱스가 맞지 않아서 복잡하다. 그래서 두번째 방법으로 배열의 크기를 1씩 증가시켜서 n+1 크기로 생성하고 값도 인덱스 1부터 넣었다. dp[0]은 wines[0], dp[1]은 wines[1]이고 dp[2]는 wines[1] + wines[2]가 된다. 마찬가지로 dp[2]는 n>1일 때 가능하다. 그리고 dp[3]부터 dp[n]까지 점화식을 통해 값을 구하면 된다.
