import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*타임머신 */

class Bus{
	int u;
	int v;
	int val;
	public Bus(int u, int v, int val) {
		this.u= u;
		this.v= v;
		this.val= val;
	}
}
public class P_11657 {
	static int n,m;
	static  Bus[] e;
	static long[] dist;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		e= new Bus[m];
		dist = new long[n+1];
		for(int i = 1 ; i < n+1;i++) {
			dist[i]= INF;
		}
		for(int i = 0 ; i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			e[i]= new Bus(u,v,val);
		}
		if(bellmanford(1)) {
			bw.write("-1");
		}else {
			for(int i = 2;i<=n;i++) {
				if(dist[i] == INF) {
					bw.write("-1");
				}else {
					bw.write(dist[i]+"\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	static boolean bellmanford(int start) {
		dist[start] =0;
		
		for(int i = 1 ; i <= n;i++) {
			for(int j=0;j<m;j++) {
				int cur = e[j].u;
				int next = e[j].v;
				int cost = e[j].val;
				
				if(dist[cur]==INF) continue;
				if(dist[next]>(dist[cur]+ cost)) {
					dist[next]=dist[cur]+cost;
					
					if(i==n) return true;
				}
			}
		}
		return false;
	}

}
