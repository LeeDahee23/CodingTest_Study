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

- effect, cleanup, effect가 출력되는 이유❓
  - 리액트 18부터는 strict mode일 때 컴포넌트가 처음으로 마운트될 때마다 자동으로 언마운트 했다가 다시 마운트해서 두번째 마운트에서 이전 상태를 복원함
  - 이유는 재사용 가능한 상태를 보장하기 위해서임
    - 예를 들어 사용자가 화면에서 뒤로 탭하면 이전 화면을 바로 보여주기 위해서
  - 트리를 여러 번 언마운트하고 다시 마운트하는 과정에서 오류가 나지 않게 useEffect를 두번 실행하는 것
    - 컴포넌트 순수성(purity): 컴포넌트는 렌더링 전에 존재했던 객체나 변수를 변경해서는 안된다. (동일한 입력 -> 항상 동일한 결과)
  - strict mode를 해제하면 이러한 현상이 없어짐
  - 도서 199p 예제
  - 참고: [[React] react 18 useEffect 두 번 실행되는 이슈](https://velog.io/@newsilver1028/React-react-18%EC%97%90%EC%84%9C-%EB%A0%8C%EB%8D%94%EB%A7%81%EC%9D%B4-%EB%91%90-%EB%B2%88%EB%90%98%EB%8A%94-%EC%9D%B4%EC%8A%88)

# 참고 자료

[도서] 리액트를 다루는 기술 - 김민준 (길벗)

[[REACT] 두 번 렌더링되는 현상? (unmount가 중복 실행되는 현상) (react strict)](https://s-ryung.tistory.com/1)
