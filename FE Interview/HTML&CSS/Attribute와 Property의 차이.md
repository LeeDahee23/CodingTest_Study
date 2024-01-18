### 차이점
1. Attribute(속성)
    1. 정의: HTML 문서에서 태그에 정의된 속성, HTML 코드에 직접 작성됨
    2. 특징
        - HTML 초기 상태. 페이지가 처음 로드될 때의 값
        - getAttribute(), setAttribute()로 접근하고 수정할 수 있음
            - 이걸로 수정하지 않는 이상 초기값이 유지됨
2. Property(프로퍼티)
    1. 정의: HTML 요소에 대한 Javascript 객체의 속성
        - HTML를 파싱하여 생성한 DOM 트리의 각 노드가 Javascript 객체가 되는데 이 객체들의 속성이 프로퍼티임
        - 자바스크립트에서 querySelector로 선택 후 .value 하면 value 프로퍼티를 반환함
    2. 특징
        - 현재 상태를 의미, 사용자의 상호작용이나 자바스크립트에 의한 변경 사항이 반영됨
        - 자바스크립트를 통해 직접 접근, 수정 가능
      
### 꼬리 질문
- Attribute 접근과 Property 접근 중 어떤 게 성능이 더 좋은가요?
    - Property 접근
    - 별도의 프로퍼티가 없는 경우에만 메서드로 접근하고, 그 외에는 프로퍼티 접근이 이상적
- 사용자가 임의로 정의한 Attribute을 만들었을 때에도 프로퍼티가 되나요?
    - No, 엘리먼트에 임의로 지정한 사용자 정의 속성은 프로퍼티로 자동으로 표현되지 않는다. 실제로 자바스크립트로 접근해보면 값이 아닌 undefined 라는 결과값을 내뱉는다.
 
### 참고
[한방에 이해하는 attribute와 property 속성 차이](https://inpa.tistory.com/entry/%F0%9F%8C%90-attribute-property-%EC%B0%A8%EC%9D%B4)
