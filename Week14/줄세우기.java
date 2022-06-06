import java.io.*;
import java.util.*;

public class Main {
    
	static int n, m;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String tmp[]=br.readLine().split(" ");
    	n=Integer.parseInt(tmp[0]); m=Integer.parseInt(tmp[1]);
    	int indegree[]=new int[n+1];
    	
    	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    	for(int i=0; i<n+1; i++) {
    		graph.add(new ArrayList<Integer>());
    	}
    	
    	for(int i=0; i<m; i++) {
    		tmp=br.readLine().split(" ");
    		int a = Integer.parseInt(tmp[0]); int b = Integer.parseInt(tmp[1]);
    		graph.get(a).add(b);
    		indegree[b]++;
    	}
    	
    	topologicalSort(graph, indegree);
    }

	private static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] indegree) {
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
	}
}
