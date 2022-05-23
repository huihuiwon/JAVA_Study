import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String tmp[]=br.readLine().split(" ");
    	int n=Integer.parseInt(tmp[0]); int k=Integer.parseInt(tmp[1]);
    	int dist[]=new int[100001];
    	int record[]=new int[100001];
    	
    	if(n==k) {
    		bw.write(0+"\n");
    		bw.write(n+"\n");
    		bw.flush();
    		return;
    	}
    	Queue<Integer> q = new LinkedList<>();
    	Stack<Integer> st = new Stack<>();
    	q.add(n);
    	
    	Arrays.fill(dist, -1);
    	Arrays.fill(record, -1);
 
    	dist[n]=0; record[n]=0;
    	
    	int dx[]= {1,-1,0};
    	while(!q.isEmpty()) {
    		int cur=q.poll();
    		dx[2]=cur;
    		for(int dir=0; dir<3; dir++) {
    			int nx=cur+dx[dir];
    			if(nx==k) {
    				record[k]=cur;
    				StringBuilder sb = new StringBuilder();
    				sb.append(dist[cur]+1+"\n");
    							
    				st.push(k);
    				
    				while(k!=n) {
    					st.push(record[k]);
    					k=record[k];	
    					if(record[k]==-1) break;
    				}
    				
    				while(!st.isEmpty())
    					sb.append(st.pop()+" ");
    				bw.write(sb+"\n");
    		    	bw.flush();
    				return;
    				
    			}
    			if(nx<0 || nx>=100001) continue;
    			if(dist[nx]!=-1) continue;
    			q.offer(nx);
    			dist[nx]=dist[cur]+1;
    			record[nx]=cur;
    		}
    	}

    }
}