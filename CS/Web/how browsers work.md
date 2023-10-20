# 브라우저

### 브라우저의 주요 기능

- 사용자가 선택한 자원을 `서버에 요청`하고 `브라우저에 표시`함. (HTML 문서, PDF, 이미지 등)
- 종류 : 크롬, 사파리, 파이어폭스 등

## 브라우저의 기본 구조
![browses structure](https://github.com/LeeDahee23/Study/assets/82389864/2d9071da-5020-419f-8570-a765436855ab)

1.  **사용자 인터페이스**
    - URI를 입력할 수 있는 주소 표시 줄
    - 이전 버튼과 다음 버튼
    - 북마크
    - 새로 고침 버튼과 현재 문서의 로드를 중단할 수 있는 정지 버튼
    - 홈 버튼
 
<img width="1511" alt="user interface" src="https://github.com/LeeDahee23/Study/assets/82389864/97f935c4-1209-4169-90b8-aa54b0606918">


2. **브라우저 엔진** : 사용자 인터페이스와 렌더링 엔진 사이의 동작을 제어
3. ✨**렌더링 엔진✨** : 요청한 콘텐츠를 표시함
4. **통신** : HTTP 요청과 같은 네트워크 호출에 사용됨. 
5. **자바스크립트 엔진** : 자바스크립트 코드를 해석하고 실행
6. **UI 백엔드** : 콤보 박스와 창 같은 기본적인 위젯을 그림
7. **자료 저장소** : 쿠키, local storage와 같은 자료를 local에 저장함

## 렌더링 엔진

- `요청한 자원을 브라우저 화면에 표시`함 (HTML, CSS, JavaScript, PDF, 이미지 등)
- 종류: 웹킷(Webkit) - 사파리, 게코(Gecko) - 파이어폭스, 블링크(Blink) - 크롬
- 참고: 크로스 브라우징
    - 모든 브라우저가 동일한 소스를 화면에 동일하기 그려주지 X, 엔진마다 읽을 수 있는 코드의 버전도 다름
    - ➡️ 동등한 수준의 정보, 기능 제공!

### 렌더링 엔진 동작 과정

![rendering engine](https://github.com/LeeDahee23/Study/assets/82389864/09e17444-35fe-48a8-892d-71ae491fc4a0)


1. HTML 파싱 & CSS 파싱
    - `파싱` : 브라우저가 코드를 이해하고 사용할 수 있는 구조로 변환하는 것
    - HTML 파싱 ⇒ HTML 마크업을 DOM 트리로 만듦

        <img src="https://github.com/LeeDahee23/Study/assets/82389864/738732f8-9fd3-4bd2-a708-00fbf21d0d92" width="500" />
      
        출처: [https://developer.mozilla.org/ko/docs/Web/Performance/How_browsers_work#응답response](https://developer.mozilla.org/ko/docs/Web/Performance/How_browsers_work#%EC%9D%91%EB%8B%B5response)
        
    - CSS 파싱 ⇒ CSS 코드를 CSSOM 트리로 만듦
    - 참고: **JavaScript 파싱**
        - JavaScript 는 `자바스크립트 엔진`이 파싱함
        - 렌더링 엔진이 HTML을 읽다가 **<script> 태그를 읽으면** `DOM 생성을 일시 중지`, `제어권을 자바스크립트 엔진에게 넘김`
        - 자바스크립트 파싱이 끝나 렌더링 엔진으로 다시 제어권을 넘기면 **DOM 생성을 이어나감**
        - 생성되지 않은 DOM을 조작한다면 에러가 발생할 수 있음 
        ⇒ <body> 요소 아래에 <script> 를 두거나 
        ⇒ DOM 생성이 완료된 시점에 자바스크립트 실행하게 함(defer 속성).

2. 렌더 트리 구축
    - 렌더트리 : `DOM과 CSSOM을 결합`한 것, 보여지는 요소만 나타냄 (display: none 같이 안보이는 것은 제외시킴)
3. 렌더 트리 배치(Layout or Reflow)
    - 뷰포트 내에서 렌더 트리의 노드가 정확한 `위치와 크기`를 계산, px 단위로 변환
    - **Layout** : 처음 노드의 사이즈와 위치가 결정되는 것
    - **Reflow** : 이후에 노드의 크기와 위치를 다시 계산하는 것
4. 렌더 트리 그리기(Paint)
    1. 브라우저 화면에 UI가 나타나게 됨
    2. Layout 단계에서 계산된 각 박스를 실제 화면의 픽셀로 변환
- **Reflow 와 Repaint**
    - **Reflow** : 특정 이벤트나 액션에 따라 HTML 요소의 크기나 위치 등의 레이아웃 수치가 변하면 해당 요소의 영향을 받는 자식노드, 부모 노드들을 포함해 Layout 과정을 다시 수행하는 것
    - **Repaint** : Reflow된 렌더 트리를 다시 화면에 그려줌
    - 만약 HTML 요소의 크기나 위치가 변하면, Reflow → Repaint
    - `Reflow 과정을 최소화` 하는 것이 성능에 좋음!

## Google.com 을 쳤을 때 일어나는 일

```
⏰ 사전 정보

1. IP 주소(IP Address) : 컴퓨터의 주소 (ex. 192.168.0.1)
2. 도메인 주소(Domain Address) : 기억하고 입력하기 쉽도록 문자(영문, 한들 등)로 만든 인터넷 주소
3. DNS(Domain Name Server) : IP 주소 ↔ 도메인 주소
    - 웹 브라우저에 URL을 입력하면, 도메인 이름에 해당하는 IP 주소를 DNS에 요청, DNS는 IP주소를 응답
```

1. 탐색 (Navigation)
   1. DNS 조회
        - 해당 페이지의 자원이 어디에 위치하는지 찾기
        - https://google.com 을 탐색한다면 HTML 페이지는 IP 주소가 93.184.216.34 와 같은 서버에 위치하고 있음
   2. TCP 핸드셰이크 (TCP Handshake) : 브라우저 - 서버 연결
   3. TLS 협상 (TLS Negotiation)
        - HTTPS를 이용하기 위해서 필요한 또 다른 핸드셰이크
        - 통신 암호화에 쓰일 암호를 결정, 서버 확인, 실제 데이터 전송 전에 안전한 연결이 이뤄지도록 함.
2. 응답 (Response)
    1. 웹 서버와 연결이 끝나면, 브라우저는 초기 HTTP GET Request를 보냄. 대체로 HTML 파일을 요청
    2. 서버는 요청을 받고, 관련 응답 헤더와 HTML 내용을 응답
3. 파싱
    1. 브라우저가 네트워크를 통해 받은 데이터를 DOM이나 CSSOM으로 바꾸는 단계
4. 렌더 (Render)
    - 렌더 트리 합성 : CSSOM과 DOM 트리는 렌더 트리로 합성
    - Layout
    - Paint
    

### 참고

[https://velog.io/@thyoondev/웹-브라우저의-동작원리를-알아보자#브라우저의-기본-구조](https://velog.io/@thyoondev/%EC%9B%B9-%EB%B8%8C%EB%9D%BC%EC%9A%B0%EC%A0%80%EC%9D%98-%EB%8F%99%EC%9E%91%EC%9B%90%EB%A6%AC%EB%A5%BC-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90#%EB%B8%8C%EB%9D%BC%EC%9A%B0%EC%A0%80%EC%9D%98-%EA%B8%B0%EB%B3%B8-%EA%B5%AC%EC%A1%B0)

https://d2.naver.com/helloworld/59361

[https://developer.mozilla.org/ko/docs/Web/Performance/How_browsers_work#응답response](https://developer.mozilla.org/ko/docs/Web/Performance/How_browsers_work#%EC%9D%91%EB%8B%B5response)

[https://inpa.tistory.com/entry/백엔드-로드맵-🌐-브라우저와-동작-원리](https://inpa.tistory.com/entry/%EB%B0%B1%EC%97%94%EB%93%9C-%EB%A1%9C%EB%93%9C%EB%A7%B5-%F0%9F%8C%90-%EB%B8%8C%EB%9D%BC%EC%9A%B0%EC%A0%80%EC%99%80-%EB%8F%99%EC%9E%91-%EC%9B%90%EB%A6%AC)
