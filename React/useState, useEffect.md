# useState

- 컴포넌트의 상태를 관리
- `const [value, setValue] = useState(0);`
  - useState의 파라미터: 상태의 default 값
  - useState는 배열을 반환
    - 첫번째 원소는 상태 값
    - 두번째 원소는 상태를 설정하는 함수(set~)
- useState 함수 하나는 하나의 상태값만 관리 => 여러 상태를 관리하려면 useState를 여러 개 쓰면 됨

# useEffect

- 컴포넌트가 렌더링될 때마다 특정 작업을 수행하도록 설정
- 클래스형 컴포넌트의 `compomentDidMount`와 `componenetDidUpdate`를 합친 형태가 유사

```react
useEffect(() => {
    console.log('렌더링 완료');
}, []);
```

- useEffect 내부 내용이 2번 실행❓
  - React.StrictMode가 적용된 개발 환경에서 발생
  - useEffect를 사용한 코드에 문제가 있는지 없는지 감지하기 위해서 두번 실행

### 마운트 될 때만 실행하고 싶을 때

- useEffect의 두 번째 파라미터에 **빈 배열** 넣기

### 특정 값이 업데이트될 때만 실행하고 싶을 때

- useEffect의 두 번째 파라미터에 **검사하고 싶은 값** 넣기

### 뒷 정리하기(cleanup)

- 컴포넌트 언마운트 전, 업데이터 직전에 어떤 작업을 수행하고 싶다면 cleanup 함수 return

  ```react
  useEffect(() => {
      console.log('렌더링 완료');
      return () => {
          console.log('clean up!');
      }
  }, []);
  ```

- (추후 추가) effect, cleanup, effect가 출력되는 이유❓
