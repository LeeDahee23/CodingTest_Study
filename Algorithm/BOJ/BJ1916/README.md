```
해결 ⭕️
다익스트라 - A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화
```

# 문제
N개의 도시와 M개의 버스가 주어질 때, A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 구하기. 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.
- 1 <= N <= 1,000
- 1 <= M <= 100,000

# 접근 방식
A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 구하라고 했으므로 `다익스트라`

# 풀이
1. 인접리스트로 그래프
   - Node: end까지 가는 비용 weight
   - ArrayList<ArrayList<Node>> graph
   - graph.get(s).add(new Node(e, w))
2. dijkstra(ArrayList<ArrayList<Node>> graph, int start, int end, int N)
   - graph : 인접리스트 그래프
   - start : 시작 도시
   - end : 도착 도시
   - N : 도시의 개수
   - visited[] : 방문처리
   - distance[] : start부터의 거리
   - PriorityQueue<Node> : 우선순위큐
   <br/>
   
   ```
   1. 시작노드 초기화
   2. 현재 노드가 방문한적이 없다면
      - 방문 처리
      - 현재노드에서 갈 수 있는 노드 중 방문한적 없는 노드 node
      - 현재 노드를 거쳐가는게 더 비용이 적다면 갱신, pq에 갱신된 비용으로 넣기
   ```

   - return distance[end]
