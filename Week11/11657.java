import java.util.*;
 
//int dist 했더니 출력초과
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
    	
    	ArrayList<Node>[] graph = new ArrayList[v+1];
    	for(int i=1; i<=v; i++)
    		graph[i]=new ArrayList<>();
    	
    	for(int i=0; i<e; i++) {
    		int a=sc.nextInt(); int b=sc.nextInt(); int c=sc.nextInt();
    		graph[a].add(new Node(b, c));
    	}
    	
        long dist[]=new long[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);  
        dist[1]=0;
        
        for(int i=1; i<=v; i++) { //음수 사이클 찾기 위해
        	for(int j=1; j<=v; j++) {
        		// j 노드에서 방문 가능한 모든 간선
        		for(Node nxt : graph[j]) {
        			// j 노드에서 방문한 적 있는가? 갱신 가능한가?
        			if(dist[j]!=Integer.MAX_VALUE && dist[nxt.e]> dist[j]+nxt.dist) {
        				if(i==v) {
        					// 갱신 가능한 최대 횟수는 V-1! V번 이상 갱신하려고 하면 -> 음수 사이클
        					System.out.println(-1);
        					return;
        				}
        				dist[nxt.e]=dist[j]+nxt.dist;
        			}
        		}
        	}
        	
        }
        
        for(int i=2; i<=v; i++) {
        	if(dist[i]==2147483647) System.out.println(-1);
        	else System.out.println(dist[i]);
        }
    }
 

 
}