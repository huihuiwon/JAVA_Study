# 14주차 문제풀이


## 우주신과의 교감

N : 우수신들의 개수 (황선자씨 포함)

M : 이미 연결된 신들과의 통로의 개수

### 두 점 간의 거리 구하기

- ArrayList<int[]> list 에 우주신의 좌표 넣기

      list[1] <= [1,3]  번호 1의 좌표 [1,3]

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

###
