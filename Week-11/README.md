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
