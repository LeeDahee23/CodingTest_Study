# 상황

### 목적

검색엔진 최적화, 성능을 위해 https을 적용하기로 했습니다.

### 상황

**nginx**

- 배포 단계에서 포트포워딩을 위해 nginx를 사용했습니다. nginx를 이미 사용하고 있었기 때문에 https도 nginx를 활용해서 적용하기로 했습니다. 또한 nginx를 사용한 ssl 설정 레퍼런스가 많아 nginx 방식을 채택했습니다.

**도메인**

- 가비아에서 구매한 도메인으로 배포를 진행했습니다.

# 방법

### nginx 설치

- 아래 명령어를 통해 nginx를 설치하고 실행합니다.
- 저희 팀은 이미 nginx가 설치되어 있었기 때문에 실행 & 확인만 하고 다음으로 넘어갔습니다.
  ```bash
  sudo apt install nginx # nginx 설치
  sudo service nginx start # nginx 실행
  sudo service nginx status # nginx 실행 확인
  ```

### 인증서 발급

- certbot을 사용해 인증서를 발급했습니다. 아래 명령어로 certbot을 설치합니다.
  ```bash
  sudo snap install certbot --classic
  ```
- 사용하는 도메인에 대해 인증서를 발급합니다. 또한 자동으로 nginx에 인증서 관련 설정을 해줍니다.
  ```bash
  sudo certbot --nginx -d {도메인}
  ```
  - 인증서 발급 시 위 명령어에서 사용하는 도메인을 입력하고, 이메일을 추가로 입력합니다.
  - 우여곡절 1: 저희 팀은 도메인이 www.stelligence.site와 stelligence.site로 두 개 존재합니다. 이럴 경우 두 도메인에 대해 인증서를 모두 발급받아야 합니다!

### nginx SSL 설정

- 아래 경로로 들어가면 default라는 설정 파일이 존재합니다. 이 파일은 certbot이 생성한 nginx 관련 ssl 설정 파일입니다. 저희는 이 default 파일을 삭제하고 새로운 파일에 설정했습니다. 주의할 점은 해당 파일은 `/etc/nginx/sites-available` 경로에 생성해야 합니다.
  저희 팀은 `stelligence-ssl.conf` 라는 이름으로 생성했습니다.
  `bash
cd /etc/nginx/sites-available # 경로 이동
ls # 존재하는 파일 목록 확인, default 파일이 있는지 확인합니다.
sudo rm default # default 파일 삭제
sudo vi {새_파일_이름} # 새로운 파일 생성
`
- .conf 파일을 아래와 같이 작성했습니다.

  ```
  server {
      # 해당 도메인으로 들어오는 443 요청에 대해
      listen 443 ssl;
      server_name stelligence.site www.stelligence.site;

      # http://localhost:3000으로 실행중인 서비스로 전달
      location / {
             proxy_pass http://localhost:3000;
      }

      # ssl 관련 설정
      ssl_certificate /etc/letsencrypt/live/stelligence.site/fullchain.pem;
      ssl_certificate_key /etc/letsencrypt/live/stelligence.site/privkey.pem;
      include /etc/letsencrypt/options-ssl-nginx.conf;
      ssl_dhparam /etc/letsencrypt/ssl-dhparams.pem;

  }
  ```

  - 참고한 블로그에서는 location에 빌드 파일 위치, 렌더링할 html 파일 이름 등을 지정해줬습니다. 처음에는 저희도 동일하게 설정했지만, next는 index.html이 없기 때문에 위처럼 리버스 프록시 설정을 했습니다.

### 설정 확인

- 아래 명령어를 통해 nginx 문법이 올바른지 테스트할 수 있습니다.
  ```bash
  sudo nginx -t
  ```

### sites-available과 sites-enabled 심볼릭링크 설정

- 아래 명령어로 sites-available과 sites-enable에 심볼릭 링크를 설정합니다.
- sites-available에서는 nginx 설정을 해주고, 실제로 nginx 실행 시 sites-enable에서 nginx 설정을 읽습니다.
- sites-enable에 있던 default 파일도 삭제했습니다.

```bash
cd /etc/nginx/sites-enabled # sites-enabled로 이동
ls # default 파일 있는지 확인
sudo rm default # default 파일 삭제
sudo ln /etc/nginx/sites-available/stelligence-ssl.conf /etc/nginx/sites-enabled/ # 심볼릭링크 설정
```

### 기존 nginx 설정 수정

- etc/nginx/nginx.conf 파일에 nginx 설정이 되어 있는데 ssl 설정과 충돌을 해결하기 위해 설정을 수정했습니다.
- 해당 내용은 참고만 하시고, 본인 애플리케이션 nginx 설정에 맞춰 작성하시면 될 것 같습니다.

```
# etc/nginx/nginx.conf

server {
    server_name {ip 주소} stelligence.site www.stelligence.site;
    listen 80;
    return 301 https://www.stelligence.site$request_uri;
}
```

- 기존에는 첫번째 server 블록에서 ip주소를 통한 접근에 대해 http://www.stelligence.site로 이동되도록 설정했습니다. ssl 설정을 위해 http에서 https로 변경했습니다.
- 또한 도메인으로 들어오는 요청 중복처리를 해결하기 위해 이전에 작성했던 설정도 삭제하고 하나의 서버블록으로 작성했습니다.

### nginx 재시작

- nginx를 재시작해주면 https 설정 성공입니다!

```bash
sudo nginx -s reload
# or
sudo service nginx restart
```
