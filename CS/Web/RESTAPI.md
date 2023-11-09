# REST (Representational State Transfer)
자원을 정의하고 자원에 대한 주소를 지정하는 방법 전반의 모음. 서비스가 이러한 제약 조건을 준수하면 RESTful로 간주함.

웹 상의 자료를 HTTP 위에서 별도의 전송 계층(SOAP이나 쿠키를 통한 세션 트랙킹) 없이 전송하기 위한 아주 간단한 인터페이스

## REST의 요소
**Resource (자원)** : URI
  
**Verb (자원에 대한 행위)** : HTTP Method (GET, POST, PUT, DELETE 등)
  
**Representation (자원에 대한 행위의 내용)** : HTTP Message Pay Load

## 💡 REST의 핵심 규칙
1. URI는 정보의 자원을 표현해야 함. 리소스명은 동사보다는 명사로!
   ```
    # bad
    GET /getTodos/1
    GET /todos/show/1
    
    # good
    GET /todos/1
    ```
2. 자원에 대한 행위는 HTTP Method로 표현한다.
    ```
    # bad
    GET /todos/delete/1
    
    # good
    DELETE /todos/1
    ```

## REST 특징
- Uniform Interface
    - HTTP 표준만 맞는다면, 어떤 기술도 가능한 인터페이스 스타일
    - 특정 언어나 기술에 종속받지 않고, 모든 플랫폼에 사용 가능한 Loosely Coupling 구조
- Stateless
    - HTTP Session 과 같은 컨텍스트 저장소에 상태 정보 저장 안함.
    - Request만 Message로 처리하면 되고, 컨텍스트 정보를 신경쓰지 않아도 되므로, 구현이 단순해짐
    - 따라서 REST API 실행중 실패가 발생한 경우, Transaction 복구를 위해 기존의 상태를 저장할 필요가 있다. (POST Method 제외)
- Cacheable
    - http를 비롯한 네트워크 프로토콜에서 제공하는 캐싱 기능을 적용 가능함.
    - 대량의 요청을 효율적으로 처리 가능함.
- Client-Server
    - client와 server 구조로 분리되어서 서로 의존성이 없어야 함
- Layered System
    - 요청된 정보를 검색하는데 있어 계층 구조로 분리되어야 함
- Code on Demand (optional)

## REST API
REST를 준수하는 API

### REST API의 작동 방식
HTTP 요청을 통해 통신함으로써 리소스 내에서 CRUD 등의 표준 데이터베이스 기능을 수행함.
- GET : 검색, 읽기(Read)
- POST : 작성(Create)
- PUT : 업데이트(Update)
- DELETE : 삭제(Delete)


## 참고
https://www.restapitutorial.com/lessons/whatisrest.html#

https://poiemaweb.com/js-rest-api

https://www.ibm.com/kr-ko/topics/rest-apis
