# OAuth란?

### What?

**O**pen **Auth**orization

인터넷 사용자들이 비밀번호를 제공하지 않고 **다른 웹사이트 상의 자신들의 정보에 대해 웹사이트나 애플리케이션의 접근 권한을 부여**할 수 있는 공통적인 수단으로서 사용되는, **접근 위임**을 위한 개방형 표준

- Authentication(인증) vs Authorization(인가)
    1. Authentication: 사용자가 누구인지를 확인
    2. **Authorization**: 사용자의 요청이 권한이 있는지를 확인

### When?

외부 소셜 계정으로 간편 회원가입 및 로그인

연동되는 외부 웹 어플리케이션에서 제공하는 기능을 간편하게 사용할 수 있음

### Why?

- OAuth가 사용되기 전에는 인증방식의 표준이 없었기 때문에 기존의 기본인증인 아이디와 비밀번호 사용 
→ 보안상 취약한 구조일 가능성 ⬆️
- 기본 인증이 아닐 경우는 각 애플리케이션들이 각자가 개발한 방법대로 사용자를 확인

⇒ 제각각인 인증 방식을 표준화 함

OAuth를 사용하면, **이 인증을 공유하는 애플리케이션끼리는 별도의 인증이 필요없고**, **여러 애플리케이션을 통합**하여 사용하는 것이 가능함.

# OAuth 구성요소

### OAuth 2.0

| 이름 | 설명 |
| --- | --- |
| Resource Owner  | 웹 서비스를 이용하려는 유저, 자원(개인정보)를 소유하는 자, 사용자 |
| Client | 자사 또는 개인이 만든 애플리케이션 서버 |
| Authorization Server | 권한을 부여해주는(=인증에 사용할 아이템을 제공하는) 서버 <br/>사용자는 이 서버로 ID, PW를 넘겨 Authorization Code를 발급받을 수 있음<br/>Client는 이 서버로 Authorization Code를 넘겨 Token을 발급받을 수 있음 |
| Resource Server | 사용자의 개인정보를 가지고 있는 애플리케이션 회사 서버 (Google, Kakao 등)<br/>Client는 Token을 이 서버로 넘겨 개인정보를 응답받을 수 있음 |
| Access Token | 자원에 대한 접근 권한을 Resource Owner가 인가하였음을 나타내는 자격 증명 |
| Refresh Token | Client는 Authorization Server로 부터 Access Token과 Refresh Token을 함께 부여받음<br/>Access Token이 만료될 때 Refresh Token을 통해 Access Token을 재발급 받아 재로그인 할 필요 없게 끔 함 |


### ⭐️ **OAuth 1.0 과 2.0의 차이점**

| 구분 | OAuth 1.0 | OAuth 2.0 | 
| -- | -- | -- |
| 보안 메커니즘 | 보안을 위해 서명된 요청 | HTTPS를 통한 보안 통신 |
| 흐름 및 복잡성 | | 더 유연하고 간단함. 다양한 시나리오에 적용 |
| 토큰 | 요청 토큰, 액세스 토큰 | 액세스 토큰 |
| 성능 | | 더 가볍고 우수함 |
| 사용성 | | 더 쉽게 사용 |


# OAuth 과정

`Client가` 사용자의 로그인 정보/자원을 Resource Server에 요청해 `대신 로그인` 하는 것!

- Client는 Resource Owner를 대신해 로그인하는데, 이때 필요한 정보를 Resource Server에서 얻어 서로 비교해 유효성을 판단함.
- 최종 목적은 `Access Token을 발급`하는 것!

**Client가 해야하는 단계**

1. Resource Owner로부터의 동의(허용) : 나의 정보를 활용할 수 있게 해줄게
2. Resource Server로부터의 Client 신원확인: 너가 유저의 일을 대신해주는 그 client가 맞아? code로 확인할거야.

### 과정
1. 클라이언트를 리소스 서버에 등록함
2. 사용자가 클라이언트의 로그인 페이지에 접근
   - 로그인 정보가 리소스 서버로 전달됨.
   - 리소스 서버가 확인이 완료되면 사용자는 리소스 서버의 로그인 페이지로 이동하고, ID/PW로 로그인을 함.
   - 사용자의 신원이 확인되면 리소스 서버는 사용자에게 Authorization code를 보냄.
3. 사용자는 받은 Authorization code를 클라이언트에게 보냄.
   - 클라이언트는 Authorization code, 클라이언트 아이디, 클라이언트 시크릿, 리다이렉트 주소를 리소스 서버로 보냄.
4. 리소스 서버는 자신이 가지고 있던 정보와 클라이언트에게 받은 정보를 비교하고 일치하면 클라이언트에게 Access Token, Refresh Token을 발급함.
   - 클라이언트는 access token을 가지고 사용자의 정보에 접근할 수 있고, access token의 기간이 만료되면 refresh token으로 access token을 재발급 받을 수 있음.
