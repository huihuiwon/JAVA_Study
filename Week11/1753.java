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

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int v=sc.nextInt(); int e=sc.nextInt();
    	int s=sc.nextInt();
    	
    	ArrayList<Node>[] graph = new ArrayList[v+1];
    	for(int i=1; i<=v; i++)
    		graph[i]=new ArrayList<>();
    	
    	for(int i=0; i<e; i++) {
    		int a=sc.nextInt(); int b=sc.nextInt(); int c=sc.nextInt();
    		graph[a].add(new Node(b, c));
    	}
    	
        int dist[]=new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s]=0;
        
        while(!pq.isEmpty()) {
        	Node cur=pq.poll();
        	if(dist[cur.e] < cur.dist) continue;
        	for(Node nxt : graph[cur.e]) {
        		if(dist[nxt.e]>dist[cur.e]+nxt.dist) {
        			dist[nxt.e]=dist[cur.e]+nxt.dist;
        			pq.add(new Node(nxt.e, dist[nxt.e]));
        		}
        	}
        }
        
        for(int i=1; i<=v; i++) {
        	if(dist[i]==2147483647) System.out.println("INF");
        	else System.out.println(dist[i]);
        }
    }
 

 
}