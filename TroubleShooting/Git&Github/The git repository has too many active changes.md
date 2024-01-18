## 에러
[vscode] 
```
The git repository at "경로" has too many active changes, only a subset of Git features will be enabled.
```

해당 경로에 있는 git repository에 변경사항이 너무 많아서, git 기능의 일부만 사용가능하다는 말이다. git changes에 10k+ 라고 생기면서 commit message 입력하는 곳이 노란 border 된다 (vscode 기준)

## 원인
해당 경로에 .git 파일이 생겼기 때문이다. 다수의 폴더나 파일이 있는 위치에서 `git init` 명령어를 쳤을 때 발생한다.

## 해결 방법
1. git repository root 찾기
    터미널에 다음과 같이 입력해서 git repository의 root 위치를 찾는다.
   
   ```
   git rev-parse --show-toplevel
   ```
2. 해당 경로로 이동한다.
   ```
   cd 경로
   ```
3. .git 파일이 있는지 확인하고, .git 파일을 삭제한다.
   ```shell
   ls -a  # 해당 경로에 있는 모든 파일 확인
   rm -r -f .git  # .git 파일 삭제
   ```


## 참고
https://m.blog.naver.com/dnfla420/221822716866
https://seanlion.github.io/blog/25
