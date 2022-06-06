## 최단경로

다익스트라로 풀이</br>
다익스트라 중에 PriorityQueue 를 쓰는 것이 O(ElogE) 로 시간 복잡도 가장 낮음</br></br>

``` java
ArrayList<Node> [] graph = new ArrayList[v+1];
for(int i=1; i<=v; i++)
  graph[i] = new ArrayList<>();
```

이렇게 ArrayList 배열을 사용할 때는</br>
배열 마다 객체 생성을 또 해줘야한다</br></br>


<다익스트라 구현하는 법></br>
우선 시작점을 큐에 넣고, 현재 구해놓은 최단거리보다 거리가 더 짧다면</br>
그 노드와 연결된 노드를 모두 살펴보면서 최단 거리를 갱신</br></br>


```java
while(!pq.isEmpty()) {
  Node cur=pq.poll();
  if(dist[cur.e] < cur.dist) continue;
  for(Node nxt : graph[cur.e]) {
    if(dist[nxt.e]>dist[cur.e]+nxt.dist) {
      dist[nxt.e]=dist[cur.e]+nxt.dist;
      pq.add(new Node(nxt.e, dist[nxt.e]));
    }
  }
}
```

</br></br></br>
## 미확인 도착지
목적지 후보들이 주어지면 목적지를 들러도 최단 거리와 같은지 확인</br></br>

s -> g -> h -> d  혹은</br>
s -> h -> g -> d  이</br>
s -> d 와 같은지 비교해본다</br></br>

a, b, d 가 주어질 때 a와 b 사이 길이 d의 양방향 도로가 있다는 뜻이므로,</br>
``graph[a].add(new Node(b, c));``</br>
``graph[b].add(new Node(a, c));``</br>
를 두 개 다 해줘야함</br></br></br>


## 타임머신
음수 간선이 있기 때문에 다익스트라로 못 풀고 벨만 포드로 풀어야함</br></br>

음수 사이클이 있는지는, 거리를 갱신할 수 있는 최대 횟수는 V-1 인데, V번 이상 갱신을 하려고 하냐를 확인</br>
만약 V번 이상 갱신하려고 하면 음수 사이클이 있다는 뜻</br>

```java
for(int i=1; i<=v; i++) { //음수 사이클 찾기 위해
  for(int j=1; j<=v; j++) {
    // j 노드에서 방문 가능한 모든 간선
    for(Node nxt : graph[j]) {
      // j 노드에서 방문한 적 있는가? 갱신 가능한가?
      if(dist[j]!=Integer.MAX_VALUE && dist[nxt.e]> dist[j]+nxt.dist) {
        if(i==v) {
          // 갱신 가능한 최대 횟수는 V-1! V번 이상 갱신하려고 하면 -> 음수 사이클
          System.out.println(-1);
          return;
        }
        dist[nxt.e]=dist[j]+nxt.dist;
      }
    }
  }
}
```
