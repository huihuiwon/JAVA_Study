## 트리의 지름


> 임의의 한 점에서 DFS를 한 번 돌리면 그 점에서 가장 먼 곳을 찾을 수 있고,(이하 nxt라 지칭)
그 점에서 DFS를 돌리면 또 그 점에서 가장 먼 곳을 찾을 수 있다
그러면 결국 그래프 안에서 가장 먼 두 점을 찾을 수 있다는 뜻

​

이 문제는 무방향 그래프이기 때문에 arr[p].add(new Edge(c, w)) 와 arr[c].add(new Edge(p, w)) 모두 해줘야 함

**ArrayList 배열을 이용한 트리 만드는 법을 익혀두기**

​

DFS를 돌면서 방문하지 않은 점을 방문하며, sum을 갱신해나가는데,

이렇게 구한 sum이 max보다 크다면, max=sum 으로 갱신하고 nxt=p 로 갱신한다

```java
static void dfs(int p, int sum) {
  if(max<sum) {
    max=sum;
    nxt=p;
  }

  for(Edge edge : arr[p]) {
    if(!visited[edge.node]) {
      visited[edge.node]=true;
      dfs(edge.node, sum+edge.weight);
    }
  }
}

// main
visited=new boolean[v+1];
visited[1]=true;
dfs(1, 0);

visited=new boolean[v+1];
visited[nxt]=true;
dfs(nxt, 0);
```

​

​

## 트리 순회
lc와 rc 배열을 두고 m의 왼쪽 자식 노드가 비어있지 않다면 lc[m] = l 해줌

오른쪽 자식 노드의 경우도 마찬가지

```java
static void preorder(int cur) {
  System.out.print((char)(cur+'A'-1));
  if(lc[cur]!=0) preorder(lc[cur]);
  if(rc[cur]!=0) preorder(rc[cur]);
}
static void inorder(int cur) {
  if(lc[cur]!=0) inorder(lc[cur]);
  System.out.print((char)(cur+'A'-1));
  if(rc[cur]!=0) inorder(rc[cur]);
}
static void postorder(int cur) {
  if(lc[cur]!=0) postorder(lc[cur]);
  if(rc[cur]!=0) postorder(rc[cur]);
  System.out.print((char)(cur+'A'-1));
}

```
​

**기억하기**

character형으로 받은 수를 정수로 나타내기 위해

-'A'+1 을 해주고

정수로 변환했던 결과를 다시 char형으로 돌리기 위해

+'A'-1 을 해줌

​

​

## 다리 만들기2
각 섬 (n개) 에서 연결할 수 있는 다리들 중에, n-1개를 골라야 섬을 모두 이을 수 있다

이때 n-1개가 섬을 모두 이을 수 있는 최소 개수


> n개의 노드가 있을 때 n-1개의 간선을 선택하여 거리의 최솟값 구하는 문제 -> 최소 신장 트리

​

<순서>
1. 각 섬에 번호 붙임 (BFS)
2. 다리 만들어 우선 순위 큐에 넣음
3. 크루스칼 알고리즘으로 최소 간선 합 구함 (Union-Find)



```
static void bfs(Dot d) {
  Queue<Dot> q = new LinkedList<>();
  visited[d.x][d.y]=true;
  map[d.x][d.y]=island;
  q.add(d);

  while(!q.isEmpty()) {
    Dot cur=q.poll();
    for(int dir=0; dir<4; dir++) {
      int nx=cur.x+dx[dir];
      int ny=cur.y+dy[dir];

      if(nx<0 || ny<0 || nx>=n || ny>=m || map[nx][ny]==0 || visited[nx][ny]) continue;
      q.add(new Dot (nx, ny));
      map[nx][ny]=island;
      visited[nx][ny]=true;
    }
  }
}
```

```
public static void make(Dot d, int num) {
  int x=d.x; int y=d.y;
  int len=0;
  for(int dir=0; dir<4; dir++) {
    while(true) {
      x=x+dx[dir];
      y=y+dy[dir];

      // 좌표 안 넘은 경우
      if(x>=0 && x<n && y>=0 && y<m) {
        // 같은 섬이면
        if(map[x][y] == num) {
          len=0;
          x=d.x; y=d.y;
          break;
        }
        // 바다면
        else if(map[x][y]==0)
          len++;
        else {
          if(len>1)
            pq.add(new Edge(num, map[x][y], len));

          len=0;
          x=d.x;
          y=d.y;
          break;
        }
      }
      else {
        len=0;
        x=d.x; y=d.y;
        break;
      }
    }
  }
}
```
