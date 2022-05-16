import java.util.*;
 
class Node implements Comparable<Node> {
	int e;
	int dist;
	Node(int e, int dist){
		this.e=e;
		this.dist=dist;
	}
	
	public int compareTo(Node o) {
		return this.dist-o.dist;
	}
}
public class Main {

	static int v, s;
	static ArrayList<Node>[] graph;
	public static int dijkstra(int start, int end) {
		int dist[]=new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
	    PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start]=0;
        
        while(!pq.isEmpty()) {
        	Node cur = pq.poll();
        	if(dist[cur.e] < cur.dist) continue;
        	for(Node nxt : graph[cur.e]) {
        		if(dist[nxt.e] > dist[cur.e]+nxt.dist) {
        			dist[nxt.e]=dist[cur.e]+nxt.dist;
        			pq.add(new Node(nxt.e , dist[nxt.e]));
        		}
        	}
        }
        
        return dist[end];
	}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();
	     
    	int tc=sc.nextInt();
    	
    	while(tc-->0) {
	    	v=sc.nextInt(); int e=sc.nextInt(); int t=sc.nextInt();
	    	s=sc.nextInt(); int g=sc.nextInt(); int h=sc.nextInt();
	    	
	    	graph = new ArrayList[v+1];
	    	for(int i=1; i<=v; i++)
	    		graph[i]=new ArrayList<>();
	    	
	    	for(int i=0; i<e; i++) {
	    		int a=sc.nextInt(); int b=sc.nextInt(); int c=sc.nextInt();
	    		graph[a].add(new Node(b, c));
	    		graph[b].add(new Node(a, c));
	    	}
	    	
	    	ArrayList<Integer> arr = new ArrayList<>();
	        for(int i=0; i<t; i++) {
	        	int end=sc.nextInt();
	        	int dist1=dijkstra(s, g)+dijkstra(g, h)+dijkstra(h, end);
	        	int dist2=dijkstra(s, h)+dijkstra(h, g)+dijkstra(g, end);
	        	int dist3=dijkstra(s, end);
	        	
	        	if(Math.min(dist1, dist2)==dist3) {
	        		arr.add(end);
	        	}
	        }
	        Collections.sort(arr);
	        for(int i : arr)
	        	sb.append(i+" ");
	        sb.append("\n");
    	}
    	System.out.println(sb);
    }
 

 
}