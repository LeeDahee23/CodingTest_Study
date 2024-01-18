1. React.FC
    1. FC(Function Component): React + Typescript 개발 시 사용하는 타입, 함수형 컴포넌트 사용 시 타입 선언
        - props와 children을 자동으로 타입 체킹 함
    2. 예시
        ```tsx
        const MyComponent: FC<MyComponentProps> = ({ title }) => <div>{title}</div>;
        ```
2. ReactElement
    1. React 요소
    2. JSX로 작성된 컴포넌트의 반환 타입으로 자주 사용
    3. 예시
        ```tsx
        const element: ReactElement = <div>Hello</div>;
        ```
3. ReactNode
    1. 더 넓은 범위의 React 노드, 문자열, 숫자, 배열, Fragment 등을 포함
    2. 컴포넌트의 자식이나 렌더링 결과를 타입화할 때 유용
4. Props 타입
    1. 컴포넌트의 props를 위한 사용자 정의 인터페이스 또는 타입. 이는 컴포넌트가 받을 수 있는 props의 형태를 정의합니다.
    2. 예시
       ```tsx
        interface MyComponentProps { title: string; }
       ```
