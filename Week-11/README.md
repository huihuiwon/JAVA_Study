# 11주차 문제 풀이

## 1753. 최단 경로
<br/>

- 다익스트라 문제
- 정점 개수 V 에 대해 1≤V≤20,000 이고, 간선 개수 E에 대해 1≤E≤300,000 이다.
- 정점 개수 만큼 new int[V][V] 로 간선 배열 생성하면, 메모리 초과가 뜰 수 있기 때문에 리스트를 사용해야 함.
    → ArrayList 사용
- 다익스트라에서 `정점의 개수-1` 만큼 반복하면서, 최소 distance 를 골라 그와 인접한 distance들을 계속 업데이트한다.

<br/>
Node 클래스

```java
class Node{
	int v, weight;
	
	public Node(int v,int weight) {
		this.v=v;
		this.weight=weight;
	}
}
```

도착지 v 노드와 가중치 w를 저장

<br/>

ArrayList <Node> maps[] 를 선언해, 현재 정점 u인 경우 u에서 출발해 다른 정점 v로 가는 간선을 maps[u] 에 추가함.

`maps[u].add( new Node(v, w));`

<br/>
다익스트라 코드

```java
class Graph{
	private int n; //노드들의 수
	//private int maps[][]; //노드들간의 가중치 저장할 변수
	private ArrayList<Node> maps[]; 
	
	public Graph(int n) {
		this.n=n;
		maps =new ArrayList[n+1];
		for(int i=1;i<n+1;i++)maps[i]=new ArrayList<Node>();
	}
	
  //간선 추가 메소드
	public void input(int i,int j,int w) {
		maps[i].add(new Node(j,w));
	}
	
	public void dijkstra(int v) {
		int distance[]=new int[n+1];//최단거리 저장
		boolean[] check=new boolean[n+1]; //해당 노드를 방문했는지 체크
		
		//distance 값 초기화
		for(int i=1;i<n+1;i++)distance[i]=Integer.MAX_VALUE;
		
		//시작노드값 초기화
		distance[v]=0;
		check[v]=true;
		
		//연결노드 distance 갱신
		for(Node node:maps[v]) {
			if(!check[node.v]) {
				distance[node.v]=Math.min(node.weight,distance[node.v]);
			}
		}
		
		//n-1 번 반복. 노드가 n개 있을 때 다익스트라를 위해서 반복하는 횟수는 n-1번이면 된다.
		for(int a=0;a<n-1;a++) {
			int min=Integer.MAX_VALUE;
			int min_index=-1;
			
			//최소값 찾기
			for(int i=1;i<n+1;i++) {
				if(!check[i]&&distance[i]!=Integer.MAX_VALUE) {
					if(distance[i]<min) {
						min=distance[i];
						min_index=i;
					}
				}
			}

			if(min_index==-1)continue;
			
			check[min_index]=true;
			
			//최소값 distance를 거쳐가는 다른 경로들에 대해 업데이트
			// min_index에서 다른 정점으로 가는 경우만 확인하면 된다.
			for(Node node:maps[min_index]) {
				if(!check[node.v]&&distance[node.v]>distance[min_index]+node.weight) {
					distance[node.v]=distance[min_index]+node.weight;
				}
			}
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<n+1;i++) {
			if(distance[i]==Integer.MAX_VALUE)sb.append("INF\n");
			else sb.append(distance[i]+"\n");
		}
		System.out.print(sb);
	}
	
	
}
```

→ 시간을 줄이기 위해, for문을 통해 최소 distance 값을 찾는 대신 우선순위 큐를 이용해 최소 distance를 바로 뽑아낼 수도 있다.
				     

## 9370. 미확인 도착지
				   
- 예술가 한 쌍이 출발지 s 지점에서 어디로 이동했는지 찾아내라.
- 예술가들은 목적지까지 최단거리로 이동.
- g, h 교차로 사이에 있는 도로를 지나갔음.
				       
<br/>

- 다익스트라를 두 번 진행
1. 입력받은 그래프 그대로
2. g — h 사이의 도로 길이가 0일 때
<br/>
<br/>	
	
**풀이**

1번 2번 경우를 다익스트라를 통해 최단 길이 (distance[])를 구한 후, 

`1번 distance = 2번 distance + (g — h 간의 도로 길이)`  이면 

최단거리에 g — h  사이의 도로를 지날 때 최단거리가 되는 것이다.

```java
			int[] data1 = ga.dijkstra(s); //1번 다익스트라 호출
			
			//g,h 간 도로의 길이 0으로 업데이트.
			ga.input(g, h, 0);
			
			int[] data2 = ga.dijkstra(s); //2번 다익스트라 호출
			
			//목적지 후보 end에 입력받음
			int[] end=new int[t];
			for(int j=0;j<t;j++) {
				end[j]=Integer.parseInt(br.readLine());
			}
			Arrays.sort(end); //오름차순 정렬
			
			// data1 == data2 + g-h 길이 이면 출력
			for(int j=0;j<t;j++) {
				if(data1[end[j]]==data2[end[j]]+w) sb.append(end[j]+" ");
			}
			sb.append("\n");
```				       

<br/>
	
## 11657. 타임머신

<br/>
	
N개의 도시, 한 도시에 출발해서 다른 도시에 도착하는 버스 M개.
<br/>


각 버스 → A, B, C

A : 시작도시

B : 도착도시

C : 버스를 타고 이동하는데 걸리는 시간

 (C=0 → 순간 이동을 하는 경우 , C<0 → 타임머신으로 시간을 되돌아가는 경우)

- 1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간 구하기
- 만약 1번 도시에서 출발해 어떤 도시로 가는 과정에서 시간을 무한히 오래 전으로 되돌릴 수 있다면 첫째 줄에 -1을 출력
    
    → 음의 가중치가 있는 엣지가 사이클을 형성할 경우

<br/>

### 벨만 포드

- 음수의 가중치가 나오는 경우 사용 가능
- `간선의 가중치 + 시작점에서 정점까지의 거리 < 정점의 기존 거리`  이면 거리 업데이트
- 이 과정을 정점의 수 - 1 번 만큼 반복한다.
- 만약 정점의 수 보다 많이 반복해서 더 작은 경로를 찾아낸다면, cycle이 존재한다는 뜻이다.

→ 원래 벨만 포드는 cycle이 없는 경우를 전제로 하므로 정점의 수 - 1 만큼 반복하면 되지만, 정점의 수 만큼 반복하면서 마지막 n번째에서 cycle을 체크함

<br/>
				 
`distance[T] = Math.min(distance[T] , distance[S] + w(S,T))`

- T : 해당 간선이 도달하고자 하는 정점
- S : 해당 간선의 시작점
- w : 해당 간선의 가중치

	
주의) distance 가 최대 6,000 * 10,000 이므로, distance는 long으로 선언해줘야 한다.

<br/>

**벨만포드 코드 일부**

```java
			long[] distance = new long[n+1]
			//distance에 max 값으로 채워줌
			for(int i=1;i<n+1;i++)distance[i]=Integer.MAX_VALUE;
			
			distance[start]=0;
			
			//cycle 체크를 위해 n번 반복. 
			for(int i=0;i<n;i++) {
				for(int j=0;j<maps.length;j++) {

					Node a=maps[j];
					
					//distance가 MAX_VALUE보다 생길 수 있기 때문에 MAX_VALUE 이면 continue 해줌
					if(distance[a.u]==Integer.MAX_VALUE)continue;
					
					// 더 짧은 경로가 존재한다면 업데이트
					if(distance[a.v]>distance[a.u]+a.weight) {
						if(i==n-1) { //n번째 반복했다면, 음수 순환이 존재한다는 뜻.
							System.out.println(-1);
							return false;
						}
						distance[a.v]=distance[a.u]+a.weight;
					}
				}
			}
```
