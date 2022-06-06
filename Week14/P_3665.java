import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*최종순위*/
public class P_3665 {

	static int n;
	static int[] indegree;
	static boolean[][] edges;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = Integer.parseInt(br.readLine());
        for(int t = 0;t<num;t++) {
        	n = Integer.parseInt(br.readLine());
        	indegree = new int[n+1];
        	edges = new boolean[n+1][n+1];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i = 0 ; i < n;i++ ) {
        		int a = Integer.parseInt(st.nextToken());
        		indegree[a] = i;
        		
        		for(int j =1;j<= n;j++) {
        			if(j!=a && !edges[j][a]) edges[a][j] = true;
        		}
        	}
        	int m = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < m;i++){
            	st = new StringTokenizer(br.readLine());
            	int n1 = Integer.parseInt(st.nextToken());
            	int n2 = Integer.parseInt(st.nextToken());
            	if(!edges[n1][n2]) {
            		edges[n1][n2] = true;
            		edges[n2][n1] = false;
            		indegree[n1]--;
            		indegree[n2]++;
            	}else {
            		edges[n1][n2] = false;
            		edges[n2][n1] = true;
            		indegree[n1]++;
            		indegree[n2]--;
            	}
            }
            bw.write(topologicalSort()+"\n");
        
        }
        
        bw.flush();
        bw.close();
        br.close();
	}
	private static String topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i =1;i<= n;i++) {
			if(indegree[i]==0) q.offer(i);
		}
		for(int i =1; i<=n;i++) {
			if(q.size() == 0) return "IMPOSSIBLE";
			if(q.size()>1) return "?";
			int cur = q.poll();
			sb.append(cur+" ");
			
			for(int j=1;j<=n;j++) {
				if(edges[cur][j]) {
					edges[cur][j] = false;
					if(--indegree[j]==0) q.add(j);
				}
			}
			
		}
		return sb.toString();
		
	}

	
}
