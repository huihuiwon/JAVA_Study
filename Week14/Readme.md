## 우주신과의 교감
Union-Find 를 이용해 연결되어있는지 아닌지를 확인하고 크루스칼 알고리즘을 이용해 최소 간선을 연결하는 문제

- 이미 연결된 좌표 Union-Find
```
for(int i=0; i<n; i++)
  parent[i]=i;
		
for(int i=0; i<m; i++) {
  int a=sc.nextInt(); int b=sc.nextInt();
  union(a-1, b-1);
}
```

- 좌표 간에 거리 구해서 넣기
```
for(int i=0; i<n-1; i++) {
  God tmp = god[i];
  for(int j=i+1; j<n; j++) {
    God tmp2 = god[j];
    double w = Math.sqrt(Math.pow(tmp.s-tmp2.s, 2)+Math.pow(tmp.e-tmp2.e, 2));
    arr.add(new God(i, j, w));
  }
}
```
- 정렬 후 연결되지 않은 좌표들은 연결하며 최단 길이 구하기
```
Collections.sort(arr);
double answer=0;
for(int i=0; i<arr.size(); i++) {
  God god = arr.get(i);
  if(find(god.s) != find(god.e)) {
    answer+=god.w;
    union(god.s, god.e);
  }
}
```


## 줄 세우기
위상 정렬의 시간 복잡도는 O(V+E)

순서가 정해져있는 정점들의 순서를 지키면서 모든 정점을 나열하는 알고리즘

1. 진입 차수가 0인 정점 큐에 add
2. 큐에서 poll 하고 그 정점의 진출 간선을 제거 (그 정점과 연결된 정점들의 진입 차수는 하나씩 감소됨)
3. 진입 차수가 0이 되는 정점이 있으면 다시 큐에 add
4. 위 과정을 정점의 수만큼 반복


```
Queue<Integer> q = new LinkedList<>();
for(int i=1; i<=n; i++)
  if(indegree[i]==0) q.add(i);

for(int i=0; i<n; i++) {
  int v=q.poll();
  System.out.print(v+" ");

  for(int nxt : graph.get(v)) {
    indegree[nxt]--;

    if(indegree[nxt]==0) q.add(nxt);
  }
}
```


## 최종 순위
역시 위상 정렬 문제

위의 문제와 풀이가 거의 비슷하나, 만약 순서가 5 -> 4 -> 3 -> 2 -> 1 이렇게 주어지면

5 -> 4, 3, 2, 1

4 -> 3, 2, 1

3 -> 2, 1

2 -> 1

이렇게 graph에 추가되어야한다

indegree 역시 한번만 plus 되고 끝나는 게 아니라 graph에 추가될 때마다 plus되어야함

```
for(int i=0; i<n-1; i++) {
 	for(int j=i+1; j<n; j++) {
   		graph[original[i]].add(original[j]);
   		indegree[original[j]]++;
   	}
}
```


***
- StringBuilder의 위치에 따라서도 오답 가능

처음에 main 함수에서 sb = new StringBuilder() 로 다시 정의해주고 main에서 출력하게끔 했는데 오답

함수 내에서 아예 새로 정의하고 출력까지 하니 틀렸습니다가 뜨지 않았다.


- graph.get(A).remove(B) 를 하는 과정에서 오답 발생

.remove() 타입으로는 .remove(Object o)와 .remove(int index) 가 가능

int index는 해당 인덱스의 값을 삭제, Object o 는 해당 Object 값을 제거

처음 구현할 때 graph.get(original[i]).remove(original[j]) 로 구현했는데,

이는 original[j] 번째 값을 삭제해달라는 뜻이 아니고 original[j] 값을 삭제해달라는 뜻!

original[j] 가 인덱스로 들어가면 IndexBound 에러 발생 가능

따라서 인덱스를 따로 안 구하고 싶다면 int 형이 아닌 Object 형인 Integer 형으로 선언해줘야 한다


- ?를 출력하는 경우
바뀐 순서가 모두 주어지고 원래의 순위도 주어지기 때문에 확실히 순위를 알 수 없는 경우는 없다
