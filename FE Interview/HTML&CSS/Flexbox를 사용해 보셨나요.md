## Flexbox

- 세세한 레이아웃 조정할 때(정렬 등) 주로 사용
- 많이 사용하는 flex 관련 속성
  ```css
  .container {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    gap: 1rem;
  }
  ```
  - flex-direction: 수직(column) / 수평(row) 정렬 선택
  - justify-content: 주 축 정렬
  - align-items: 교차 축 정렬
  - gap: .container 하위 item 간 간격
- flex 속성
  - flex-grow, flex-shrink, flex-basis를 한번에 설정 가능
    - `flex: 1`
  - `flex-grow`: 컨테이너 내에서 추가 공간을 얼마나 차지할지(default: 0)
  - `flex-shrink`: 컨테이너가 충분한 공간을 갖지 못할 때 아이템이 어떻게 축소될지(default: 1)
  - `flex-basis`: flex 아이템의 초기 크기
