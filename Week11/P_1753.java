import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;
/*최단 경로 */
public class P_1753 {
	private static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		public Node(int vertex,int weight) {
			this.vertex=vertex;
			this.weight= weight;
		}
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
	static ArrayList<Node>[] list;
	private static int v;
	private static int e;
	private static int start;
	private static int[] d;
	private static int INF = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e =Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		d= new int[v+1]; //최단 거리 저장할 배열
		list = new ArrayList[v+1]; //정점 인접 리스트 
		
		for(int i = 1; i <=v;i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(d,INF);
		d[start]=0;
		for(int i = 0 ; i < e ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); //출발 
			int v = Integer.parseInt(st.nextToken()); // 도착지 
			int w = Integer.parseInt(st.nextToken());// 가중치 
			list[u].add(new Node(v,w));
		}
		dijkstra();
		for(int i = 1; i <= v;i++) {
			if(d[i]==INF) bw.write("INF\n");
			else bw.write(d[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	private static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start,0));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int vertex = node.vertex;
			int weight = node.weight;
//			if(d[vertex]<weight) { // 지금 것이 더 가중치가 크면 갱신 안함  
//				continue;
//			}
			for(int i = 0 ; i < list[vertex].size();i++) {
				int v = list[vertex].get(i).vertex;
				int w = list[vertex].get(i).weight + weight;
				if(d[v]>w) {
					d[v] = w;
					queue.add(new Node(v,w));
				}
			}
		}
	}
}
