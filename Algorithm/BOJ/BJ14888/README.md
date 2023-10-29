작성중

```
해결 ❓ - 이전 코드 참고
백트래킹 - 연산자 조합(만들 수 있는 식의 결과 중 최대, 최소 구하기)
```

# 문제
N개의 수와 N-1개의 연산자(+-*/)가 주어진다. 수의 순서를 바꾸지 않고, 연산자의 우선순위는 무시하고 앞에서부터 계산을 한다. 만들 수 있는 식의 결과의 최대값과 최소값을 구하시오.
- 2 ≤ N ≤ 11, 1 ≤ 수 ≤ 100

# 접근 방식
가지고 있는 연산자들로 만들 수 있는 `조합`을 모두 계산해봤을 때의 최댓값과 최솟값을 구하면 된다.<br/>
(가지고 있는 연산자들을 모두 사용하기 때문에 수학적으로는 `순열`)
ex) + 2개, - 1개, * 1개, / 0개<br/>
➡️ ++-*, ++*-, +-+*, +-*+, +*-+, +*+-, -++*, -++*, … 

# 풀이
연산자 배열을 돌면서, 개수가 0보다 크다면 사용하고 0보다 작거나 같아지면 다음으로 넘어가는 방식으로 작성했다.<br/>
```java
private static void find(int[] nums, int[] op, int result, int depth) {
  if(depth == nums.length) {
    max = Math.max(max, result);
    min = Math.min(min, result);
    return;
  }
  
  for(int i=0; i<op.length; i++) {
    if(op[i] > 0) {
      op[i] --;
      find(nums, op, calculate(result, nums[depth], i), depth + 1);
      op[i] ++;
    }
  }
  
}
```

