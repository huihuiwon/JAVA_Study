## P_1774. 우주신과의 교감

**1. 각 노드의 좌표 저장**

**2. 이미 연결된 통로 처리**
- 만들어야 할 최소 통로 개수 체크 => (cnt-1)개 간선 생성
- 통로로 연결된 각 노드 집합 합치기 - union

```
int cnt = N;
for (int i=0; i<M; i++) {
	st = new StringTokenizer(br.readLine());
	int n1 = Integer.parseInt(st.nextToken());
	int n2 = Integer.parseInt(st.nextToken());
	if (find(n1) != find(n2))
		cnt--;
	union(n1, n2);
}
```

**3. 연결 가능한 모든 통로(무방향) 찾기**
- 기존 통로와 사이클을 이루지 않는 간선을 찾아 우선순위 큐에 추가
- 각 좌표간의 거리 구하기 : getDistance()
  - Math.sqrt(Math.pow(node[n1].x - node[n2].x, 2) + Math.pow(node[n1].y - node[n2].y, 2));

```
for (int i=1; i<node.length; i++) {
	for (int j=i+1; j<node.length; j++) {
		if (find(i) != find(j)) {
			pq.add(new Channel(i, j, getDistance(i, j)));
		}
	}
}
```

**4. 모든 신들과 연결되는 통로 만들기 (Kruskal 알고리즘)**
- 우선 순위 큐에서 거리가 짧은 순으로 꺼냄
- 사이클을 이루지 않도록 cnt-1개 선택
- 소수점 둘째 자리까지 출력

    System.out.printf("%.2f", Kruskal(cnt));

```
while (!pq.isEmpty()) {
	Channel ch = pq.remove();
	if (find(ch.u) != find(ch.v)) {
		len += ch.dist;
		union(ch.u, ch.v);
		cnt--;
	}
	if (cnt == 1) 
		break;
}
```


## P_2252. 줄 세우기

**1. 그래프 생성 - 인접 리스트 이용**
- 키를 비교한 정보 : A가 B 앞에 섬 => 간선 A→B 방향
- 각 노드의 진입 차수(int[] in_degree) 계산

**2. 위상정렬**

```
//진입차수 0인 노드를 큐에 추가
for (int i=1; i<in_degree.length; i++) {
	if (in_degree[i] == 0)
		q.add(i);
}

while (!q.isEmpty()) {
	int cur = q.remove();
	order.append(cur).append(" ");
	//현재 노드에서 연결된 간선 제거 후 진입 차수 0이 된 노드 찾기
	for (int nxt : graph.get(cur)) {
		if (--in_degree[nxt] == 0)
			q.add(nxt);
	}
}
```

- order : 줄 세운 결과


## P_3665. 최종 순위

**1. 그래프 생성 - 인접 행렬 이용**

**2. 높은 순위->낮은 순위 모든 간선 생성**
- 기존 그래프의 진입 차수 계산

```
for (int i=1; i<n; i++) {
	for (int j=i+1; j<=n; j++) {
		graph[t[i]][t[j]] = true;
		in_degree[t[j]]++;
	}
}
```

**3. 변동된 순위 반영**
- 기존 방향 간선<u, v> 삭제, 반대 방향 간선<v, u> 생성

    graph[u][v] = false;
    
    graph[v][u] = true;
    
- 각 진입 차수 갱신

    in_degree[v]--;
    
    in_degree[u]++;

**4. 위상정렬로 순위 구하기**
- 확실한 순위를 찾을 수 없는 경우 : "?" 
-> 순서가 여러 가지 가능(큐에 여러 노드가 들어감) //test case에서 X
- 순위를 정할 수 없는 경우 : "IMPOSSIBLE" 
-> 사이클이 있는 경우(n개 순서가 정해지기 전에 종료됨)

>(1) 진입차수 0인 노드 큐에 추가
>
>(2) 큐가 빌 때까지 다음을 반복
> - 큐 안에 노드가 2개 이상 있으면 "?" 리턴
> - 큐에서 현재 노드를 꺼내서 순서에 붙이고 cnt 증가
> - 현재 노드에서 연결된 간선 삭제 후 진입 차수 0인 노드 큐에 추가
> 
>(3) n개의 순위가 다 정해지지 않았으면 "IMPOSSIBLE" 리턴
> - cnt<n인데, 큐에 아무것도 없는 경우
> 
>(4) n개의 순위를 모두 찾았으면 order.toString() 리턴

```
int cnt = 0;
while (!q.isEmpty()) {
	if (q.size() > 1) {
		return "?";
	}
	int cur = q.remove();
	order.append(cur).append(" ");
	cnt++;
	for (int i=1; i<=n; i++) {
		if (graph[cur][i]) {
			if (--in_degree[i] == 0) {
				q.add(i);
			}
		}
	}
}

if (cnt != n) {
	return "IMPOSSIBLE";
}

return order.toString();
```
