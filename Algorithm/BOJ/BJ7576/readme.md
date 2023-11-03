```
해결 ⭕️
bfs - 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수
😵‍💫 한 번에 여러개의 익은 토마토가 퍼져야 함
```

# 문제
M x N 크기의 격자모양 상자에 익은 토마토, 익지 않은 토마토가 있다. 익은 토마토의 상하좌우 4방향에 있는 토마토는 하루만에 익는다. 토마토들이 모두 익는 최소 일수를 구하시오. 토마토가 모두 익지 못하는 상황이면 -1을 출력한다. <br/>
익은 토마토는 1, 익지 않은 토마토는 0, 토마토가 없는 칸은 -1 <br/>
- 2 <= M, N <= 1,000

# 접근 방식
익은 토마토 주변의 토마토가 하루만에 익고, 모두 익는 최소일수를 구해야 하기 때문에 bfs

# 풀이
익은 토마토가 하나만 있는게 아니기 때문에 각 depth마다 토마토를 익혀야 한다<br/>
그래서 큐에 토마토의 좌표, depth를 같이 저장했다.<br/>

일단 처음 단계에 익은 토마토를 모두 큐에 넣어준다. 이 때 depth는 0이다.
```java
for(int i=0; i<arr.length; i++) {
  for(int j=0; j<arr[0].length; j++) {
    if(arr[i][j] == 1) {
      q.offer(new int[] {i, j, 0});
    }
  }
}
```

4방향을 모두 확인하면서 새로운 좌표와 새로운 depth를 구해준다. 새로운 depth는 +1 해주면 된다.
```java
while(!q.isEmpty()) {
  int[] cur = q.poll();
  depth = cur[2];
  
  for(int i=0; i<dx.length; i++) {
    int nx = cur[0] + dx[i];
    int ny = cur[1] + dy[i];
    int nd = cur[2] + 1;
    
    if(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length && arr[nx][ny] == 0) {
      arr[nx][ny] = 1;
      q.offer(new int[] {nx, ny, nd});
    }
  }
}
```

while문이 끝나고 나서도 익지 않은 토마토가 있다면 토마토가 모두 익지 못하는 상황이므로 -1을 출력하고,<br/>
아니라면 depth를 출력한다.
