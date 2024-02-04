# 상황

어떤 div를 클릭했을 때 라우터를 이동해주려고 useRouter로 router를 생성해서 push로 이동시키려고 함.

# 원인

Next.js application 외부에서 useRouter를 사용하거나 렌더링된 구성요소이기 때문.

1. 아직 라우팅 컨텍스트 초기화가 제대로 완료되기 전에 useRouter를 호출할 때 발생함. (라우팅 컨텍스트 초기화는 Next.js 애플리케이션을 시작할 때 라우터 객체를 생성하고 애플리케이션의 모든 페이지와 라우트가 어떻게 연결되는지 정의하는 과정)
2. app 디렉토리 내에서 next/router의 useRouter를 사용하려고 할 때 발생함. app 디렉토리 내에서 App Router의 useRouter를 사용하는 것은 'next/navigation'에서 제공하는 것. (Page 안에서 사용하는 useRouter와 다르게 동작)
   - next.js 12 버전부터 도입된 App Directory 내에서 사용될 때 최적화되기 때문

<br/>
공식 홈페이지 원문

```plain text
A component used useRouter outside a Next.js application, or was rendered outside a Next.js application. This can happen when doing unit testing on components that use the useRouter hook as they are not configured with Next.js' contexts.

This can also happen when you try to use the useRouter hook from next/router inside the app directory, as the App Router's useRouter from next/navigation has different behavior to the useRouter hook in pages.
```

# 해결 방법

1. 테스트 환경에서는 useRouter 부분을 모의 함수로 대체
2. app 디렉토리에서 사용 시, 'next/navigation'에서 import 하기

# 참고

[[next.js 공식 홈페이지] `NextRouter` was not mounted](https://nextjs.org/docs/messages/next-router-not-mounted)
