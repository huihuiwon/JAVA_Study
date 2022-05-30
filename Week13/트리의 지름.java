import java.util.*;
import java.io.*;
class Edge {
	int node;
	int weight;
	
	public Edge(int node, int weight) {
		this.node=node;
		this.weight=weight;
	}
}

public class Main {

	static boolean visited[];
	static int max=-1;
	static int nxt=-1;
	static ArrayList<Edge>[] arr;
	
	static void dfs(int p, int sum) {
		if(max<sum) {
			max=sum;
			nxt=p;
		}
		
		for(Edge edge : arr[p]) {
			if(!visited[edge.node]) {
				visited[edge.node]=true;
				dfs(edge.node, sum+edge.weight);
			}
		}
	}
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int v = Integer.parseInt(br.readLine());
    	arr = new ArrayList[v+1];
    	for(int i=0; i<=v; i++)
    		arr[i]=new ArrayList<Edge>();
    	
    	for(int i=0; i<v-1; i++) {
    		String tmp[]=br.readLine().split(" ");
    		int p=Integer.parseInt(tmp[0]);
    		int c=Integer.parseInt(tmp[1]);
    		int w=Integer.parseInt(tmp[2]);
    		
    		arr[p].add(new Edge(c, w));
    		arr[c].add(new Edge(p, w));
    	}
    	
    	visited=new boolean[v+1];
    	visited[1]=true;
    	dfs(1, 0);
    	
    	visited=new boolean[v+1];
    	visited[nxt]=true;
    	dfs(nxt, 0);
    	
    	System.out.println(max);
    }
}