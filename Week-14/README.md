# 14주차 문제풀이


## 우주신과의 교감

N : 우수신들의 개수 (황선자씨 포함)

M : 이미 연결된 신들과의 통로의 개수

우주신들과의 통로 길이 합이 최소가 되게 통로를 만들자

</br>

### 두 점 간의 거리 구하기

- ArrayList<int[]> list 에 우주신의 좌표 넣기

      list.get(1) <= [1,3]  번호 1의 좌표 [1,3]

- double[][] map 에 각 점간의 길이 구하기
- 만약 map[i][j]에 대해 i==j 이면, map[i][j] = -1
- 그리고 만약 이미 두 점 간에 연결이 되어있다면, map에 0 넣어주기

```java
// 두 점 간의 거리 구하는 코드
public static void cal_length(int n) {
		long xd;long yd;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) { //같으면, -1 넣어줌
					map[i][j]=-1;
					continue;
				}
				
				int[] a=list.get(i);
				int[] b=list.get(j);
				
				//거리 구하고 map에 넣어주기
				yd= (long)Math.pow((a[1]-b[1]), 2);
				xd= (long)Math.pow((a[0]-b[0]), 2);
				map[i][j]=Math.sqrt(yd+xd); 
			}
		}
	}
```

### **주의해야할 점**

- 좌표 x, y에 대해 (0<= X<=1,000,000), (0<=Y<=1,000,000) 이다.
- 거리를 구할 때 int로 선언하면 잘릴 수 있으므로 long으로 선언해주어야 한다.

 

### MST - PRIM 알고리즘 사용

- kruskal을 하려고 했는데, kruskal에서는 각 경로들에 대해 정렬을 해주어야 한다.
- 우주신의 개수가 1000개이면 가능한 통로의 개수는 1000*1000 개이고, 이를 정렬하는 것 보다 현재 볼 경로에 대해 우선순위 큐에 넣는게 더 낫다고 생각해 prim 알고리즘을 선택했다.

### prim 알고리즘이란?

- 우선순위 큐, 큐를 통해 구현 가능
- 큐에 우선 시작 노드를 넣는다.
- 큐에서 노드를 꺼내, 노드에 연결되어있는 방문하지 않은 간선들을 우선순위 큐에 넣는다.
- 우선순위 큐에서 넣을 때마다 간선 가중치 값이 작은 것부터 오름차순으로 정렬될 것
- 우선순위 큐에 담긴 간선 중 제일 작은 값을 꺼내 MST에 추가한다. 그리고 그 다음 간선을 선택하기 위해 큐에도 추가한다.

```java
//우선순위 큐에서 정렬을 위해선 클래스 Node에 compareTo 메서드가 필요하다.
class Node implements Comparable<Node>{
	int start;
	int end;
	double cost;
	
	Node(int start,int end,double cost){ //시작점, 도착점, 경로 길이를 저장
		this.start=start;
		this.end=end;
		this.cost=cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return o.cost >= this.cost ? -1:1;
	}
}

//prim 알고리즘
public static double prim(int n,int start) {
		double costs=0;
		boolean[] visited = new boolean[n];
		PriorityQueue<Node> pq= new PriorityQueue<Node>();
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		
		while(!q.isEmpty()) {
			int node =q.poll();
			visited[node]=true;
			
			for(int i=0;i<n;i++) {
				//점들을 보면서, 방문하지 않았고 0과 같거나 큰 경로가 있으면 우선순위큐에 추가
				if(!visited[i]&&map[node][i]>=0) {
					pq.add(new Node(node,i,map[node][i])); 
				}
			}
			
			while(!pq.isEmpty()) {
				Node e=pq.poll();
				
				//우선순위 큐에서 길이가 가장 최소값인 경로를 꺼내서 mst에 추가해준다.	
				if(!visited[e.end]) {
					visited[e.end]=true;
					q.add(e.end);
					costs+=e.cost; //이때 이미 연결된 경로의 길이는 0이므로 mst에는 추가되고, 총비용에는 추가되지 않는다.
					break;
				}
			}
			
		}
		
		return costs;
	}
```

</br>

## 줄 세우기

N명의 학생들 키 세우기

학생 → 정점

일부 학생들의 키를 비교한 결과 → 간선

- A 가 B 앞에 서야 한다. A → B 로 가는 간선 추가
- 다 연결되어 있지 않음. 연결이 끊길 수도 있다.

1. 현재 노드로 들어오는 간선의 개수 (진입차수) 를 배열에 저장한다.

```java
for(int i=0;i<m;i++) {
			str = br.readLine().split(" ");
			int a=Integer.parseInt(str[0]);
			int b=Integer.parseInt(str[1]);
			graph.get(a).add(b); // a -> b로 가는 간선 추가
			in_cnt[b]+=1; //진입차수 +1 증가
		}
```

2. 위상 정렬 시작 (tp_sort). 진입차수가 0인 노드를 큐에 넣어준다.

```java
//진입차수가 0인 노드를 큐에 삽입
		for(int i=1;i<n+1;i++) {
			if(in_cnt[i]==0)queue.add(i);
		}
```

3. queue가 빌 때까지, 노드를 꺼내 해당 노드와 연결된 다른 노드를 탐색한다.
4. 다른 노드를 꺼내 해당 노드의 진입차수를 -1 해주고 (연결된 간선 제거)
5. 진입차수가 0이면 queue에 넣는다.

```java
while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now+" "); //꺼낸 노드 출력
			
			//현재 노드와 연결된 다른 노드들 탐색
			for(int node:graph.get(now)) {
				//연결 제거
				in_cnt[node]-=1;
				
				//진입차수가 0 이면 queue 에 넣음
				if(in_cnt[node]==0)queue.add(node);
			}
			
		}
		System.out.println(sb);
```


</br>

## 최종 순위

확실한 순위를 정할 수 없는 경우 “?” 출력

- 진입차수 = 0 으로 queue에 들어오는 정점의 개수가 1개여야 함

데이터의 일관성이 없으면 “IMPOSSIBLE” 출력

- n개만큼 다 출력 못했는데 queue에 들어있는 노드가 없는 경우

</br>

시작노드와 도착노드를 저장하는 간선 배열은 필요없음.

진입차수 배열과 노드의 처음 순서 배열을 만든다.

순서가 5 → 4→ 3→ 2 → 1 이면, 노드 5에는 진입차수 0, 노드 4에는 진입차수 1 … 노드 1에는 진입차수 4가 된다.

| 노드 | 1 | 2 | 3 | 4 | 5 |
| --- | --- | --- | --- | --- | --- |
| 진입차수 | 4 | 3 | 2 | 1 | 0 |
| 처음 순서 | 5 | 4 | 3 | 2 | 1 |

</br>

그리고 a,b 의 등수가 바뀔 때, 진입차수를 바꿔준다.

1) a의 처음 순서 < b의 처음 순서

- a의 진입차수 +1 , b의 진입차수 -1

2) a의 처음 순서 ≥ b의 처음 순서

- a의 진입차수 -1, b의 진입차수 +1

</br>

### 위상정렬 함수 호출

1. 진입차수가 0인 노드를 queue에 넣어준다.
2. 만약 queue의 size가 1보다 크면, “?” 출력하고 return
3. for문을 n번만큼 돌면서, queue에서 노드를 꺼낸다.
4. 만약 n번만큼 도는 도중 queue가 비어있으면 “IMPOSSIBLE” 출력하고 return
5. queue에서 노드를 꺼낸 후, 노드들 중 진입차수가 0보다 큰 값이 있으면 -1 해주고, 빼고 난 후 진입차수가 0이 되면 queue에 추가해준다.
    
    ```java
    for(int j=1;j<=n;j++) {
    		if(in_cnt[j]>0) {
    			 in_cnt[j]--;
    				if(in_cnt[j]==0)queue.add(j); 
    		}
    	}
    ```
