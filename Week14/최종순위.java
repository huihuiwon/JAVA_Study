import java.io.*;
import java.util.*;

public class Main {
    
	static StringBuilder sb;
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int tc = sc.nextInt();
    	while(tc-->0) {
    		int n = sc.nextInt();
    		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    		for(int i=0; i<=n; i++)
    			graph.add(new ArrayList<Integer>());
    			
    		int indegree[]=new int[n+1];
    		
    		int original[]=new int[n];
    		for(int i=0; i<n; i++)
    			original[i]=sc.nextInt();

    		for(int i=0; i<n-1; i++) {
    			for(int j=i+1; j<n; j++) {
    				graph.get(original[i]).add(original[j]);
    				indegree[original[j]]++;
    			}
    		}
    		
    		int m=sc.nextInt();
    		for(int i=0; i<m; i++) {
    			Integer ca=sc.nextInt(); Integer cb=sc.nextInt();
    			if(graph.get(cb).contains(ca)) {
	    			graph.get(ca).add(cb);
	    			graph.get(cb).remove(ca);

	    			indegree[ca]--;
	    			indegree[cb]++;
    			}
    			else {
	    			graph.get(cb).add(ca);
	    			graph.get(ca).remove(cb);

	    			indegree[cb]--;
	    			indegree[ca]++;
    			}
    		}
    		
    		topologicalSort(graph, indegree, n);
    		
    	}
    }

	private static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] indegree, int n) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++)
			if(indegree[i]==0) q.add(i);

		for(int i=0; i<n; i++) {
			if(q.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				return;
			}
			
			int v=q.poll();
			sb.append(v+" ");
			for(int nxt : graph.get(v)) {
				indegree[nxt]--;
				if(indegree[nxt]==0) q.add(nxt);
				
			}
		}
		
		System.out.println(sb);
		
	}
}
 
