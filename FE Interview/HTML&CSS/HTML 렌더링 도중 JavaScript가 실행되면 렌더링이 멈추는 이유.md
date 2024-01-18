### HTML 렌더링 엔진과 JavaScript 엔진
- 렌더링 엔진: HTML, CSS 코드를 파싱해서 DOM, CSSOM을 생성
- JavaScript 엔진: JavaScript 코드를 파싱

### 이유
Javascript는 돔 트리를 변경할 수 있기 때문에 html 보다 javascript를 먼저 파싱을 하기 때문입니다.

렌더링 엔진은 HTML 코드를 한줄씩 파싱하며 DOM을 생성하다가 Javascript를 만나면 자바스크립트 코드를 파싱하기 위해 DOM 생성을 일시 중지합니다.<br/>
그리고 자바스크립트 엔진에게 제어권을 넘기게 되고 자바스크립트 파싱이 끝나면 다시 렌더링 엔진에게 제어권을 넘겨줘서 HTML 파싱을 이어나가게 됩니다.

### 꼬리 질문
- 이런 상황은 어떻게 하면 막을 수 있나요?
    - <script> 태그를 <body> 마지막에 두기
    - <script> 태그에 async 속성으로 비동기적으로 진행하게 하거나, defer 속성으로 html 파싱이 끝나고 자바스크립트 파싱이 진행되게 하기
