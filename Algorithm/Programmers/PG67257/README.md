# 풀이

### 접근 방법

- 연산자가 최대 3개이기 때문에 우선순위 경우의 수는 최대 6가지이다 (3! = 6)
    
    ⇒ **모든 우선순위**에 대한 연산 결과 중 `절댓값이 최대`가 되는 경우를 찾으면 됨!
    
- 연산자 우선순위에 따른 연산
    - List<Long> operand: 피연산자
    List<Character> operator: 연산자
    - operator를 돌면서 현재 연산자가 현재 우선순위 연산자라면 → 연산
    - 아니라면 → 다음 연산자로 넘어감
    - ex) operand: [1, 5, 3, 7], operator: [*, +, *] ⇒ (수식 = 1 * 5 + 3 * 7)
        - 연산자 우선순위 : *+- , 현재 우선순위 연산자: *
        1. [`*`, +, *] : 현재 연산자 == 현재 우선순위 연산자 → (연산) 1 * 5 = 5
            - operand: [5, 3, 7], operator: [+, *]
        2. [`+`, *] : 현재 연산자 ≠ 현재 우선순위 연산자 → 넘어감
            - operand: [5, 3, 7], operator: [+, *]
        3. [+, `*`] : 현재 연산자 == 현재 우선순위 연산자 → (연산) 3 * 7 = 21
            - operand: [5, 21], operator: [+]

### 풀이

- priority: 연산자 우선순위의 모든 경우
- expression을 피연산자, 연산자로 나눠서 따로 리스트에 저장
    - List<Long> operand: 피연산자
    List<Character> operator: 연산자
    - 숫자가 아니라면 연산자니까 **바로 전까지** `피연산자`, **현재는** `연산자`
- priority 전부에 대해 연산하기 → `결과의 절댓값`의 최댓값 찾기
    - 함수 calculate(String priority, List<Long> operand, List<Character> operator)
    - priority: 연산자 우선순위, operand: 피연산자, operator: 연산자
    - priority 순서대로
        - 현재 연산자(i) == 현재 우선순위 연산자
            - 연산 ⇒ result = operand.get(i) (operator.get(i)) operand.get(i+1)
            - operand의 i번째를 result 로 바꾸고
            - operand의 i+1번째는 지우기
            - operator의 i번째도 지움(연산 끝났으니까)
        - 현재 연산자(i) ≠ 현재 우선순위 연산자
            - i ++ (다음 연산자 확인)
    - max 갱신
        - 연산이 모두 끝나고 나면 operand에는 숫자 하나가 남게 됨 == 연산의 최종 결과
        - 결과의 절댓값으로 max 갱신
