## P_1967. 트리의 지름

트리 정보 ArrayList<ArrayList<>>로 저장

 -자식→부모 노드로 탐색 가능 : 양방향으로 간선 저장

**1. 트리의 루트 노드에서 가장 먼 노드를 찾기**

 _int node = bfs(1)[0];_

**2. 해당 노드에서 가장 먼 노드까지 거리 구하기**

 _bfs(node)[1]_

* **bfs**

return {시작 노드에서 가장 먼 노드 번호, 시작 노드에서 해당 노드까지 거리}

visited 배열 : 방문 기록, 시작 노드부터 각 노드까지의 거리 저장

1. visited 배열 -1로 초기화 ⇒ 방문하지 않은 노드 -1
2. 시작 노드 큐에 추가
3. 시작 노드 visited 값 0으로 설정
4. bfs로 각 노드 방문하면서 시작 노드부터의 거리 기록
```
q.add(start);
visited[start] = 0;
while (!q.isEmpty()) {
	int cur = q.remove();	
	for (Node nxt : tree.get(cur)) {
		if (visited[nxt.data] == -1) {
			visited[nxt.data] = visited[cur] + nxt.weight;
			q.add(nxt.data);
		}
	}
}
```
5. visited 배열에서 값이 가장 큰(거리가 가장 먼) 노드와 거리를 리턴


## P_1991. 트리 순회
1. 이진 트리 생성
- 노드 N개 생성

  _node[i] = new Node((char)(65+i));_

- 트리의 루트 'A'로 설정
- 각 노드마다 왼쪽과 오른쪽 자식 노드 정보 저장
```
static class Node {
	char data;
	Node left;
	Node right;
...
}
```

2. 트리 순회 - 재귀 이용

* 전위 순회 - 현재 노드 출력 -> 왼쪽 자식 탐색 -> 오른쪽 자식 탐색
```
public void preOrder(Node cur) throws IOException {
	if (cur != null) {
		bw.write((char)cur.data);
		preOrder(cur.left);
		preOrder(cur.right);
	}
}
```
* 중위 순회 - 왼쪽 자식 탐색 -> 현재 노드 출력 -> 오른쪽 자식 탐색
```
public void inOrder(Node cur) throws IOException {
	if (cur != null) {
		inOrder(cur.left);
		bw.write((char)cur.data);
		inOrder(cur.right);
	}
}
```
* 후위 순회 - 왼쪽 자식 탐색 -> 오른쪽 자식 탐색 -> 현재 노드 출력
```
public void postOrder(Node cur) throws IOException {
	if (cur != null) {
		postOrder(cur.left);
		postOrder(cur.right);
		bw.write((char)cur.data);
	}
}
```


## P_17472. 다리 만들기2

**1. int[][] map에 정보 저장**

**2. bfs로 섬마다 번호 부여 & 섬의 개수 세기**

**3. 섬마다 연결 가능한 (길이 2이상인) 다리 찾기 - 우선순위 큐에 저장**

```
class Bridge implements Comparable<Bridge> {
	int from;
	int to;
	int weight;
...
}
```
```
for (int i=0; i<map.length; i++) 
	for (int j=0; j<map[0].length; j++) 
		if (map[i][j] != 0) 
			//섬에서 가로세로(상하좌우)로 다른 섬과 연결되는지 확인
			for (int k=0; k<4; k++) {
				int x = j;
				int y = i;
				int dist = -1;
				while (true) {
					x += dx[k];
					y += dy[k];
					dist++;
					//맵 범위를 벗어나거나 같은 섬이면 X
					if (x < 0 || x >= map[0].length || y < 0 || y >= map.length || map[y][x] == map[i][j])
						break;
					//다른 섬과 연결되는 길이 2이상인 다리 저장
					if (map[y][x] != 0) {
						if (dist >= 2)
							pq.add(new Bridge(map[i][j], map[y][x], dist));
						break;
					}
				}
			}
```

**4. 모든 섬을 연결하는 가장 짧은 다리 만들기**

⇒ 최소 신장 트리 만들기 : 크루스칼 알고리즘
- 우선순위 큐에서 거리가 짧은 순으로 (섬의 개수-1)개 다리 고르기
- 사이클이 생기지 않도록 선택함 (Union-Find)
- 가능한 다리로 모든 섬을 연결할 수 없으면 -1 ( if (len==0) )
 - 우선순위 큐에 저장된 다리로 (섬의 개수-1)개 선택되는지 확인
```
//자기자신을 parent로 설정
parent = new int[landCnt+1];
for (int i=0; i<=landCnt; i++) {
	parent[i] = i;
}
//(섬의 개수-1)개 다리 만들기
while (!pq.isEmpty()) {
	Bridge n = pq.remove();
	//사이클 생기지 않도록 다리 선택
	if (find(n.from) != find(n.to)) {
		len += n.weight;
		union(n.from, n.to);
		landCnt--;
	}
	if (landCnt == 1) 
		break;
}
return (landCnt == 1) ? len : 0;
```
