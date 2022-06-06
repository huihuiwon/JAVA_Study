import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*줄세우기*/
public class P_2252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] indegree = new int[n+1]; //자신을 가르키고 있는 화살표의 개수 
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i= 1;i<= n;i++) {
        	list[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int x= Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	list[x].add(y);
        	indegree[y]++;
        	
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i =1;i<= n;i++) {
        	if(indegree[i] ==0 ) { // 자신을 가르키고 있는 화살표가 없다면 즉 내 앞에 아무도 없으면 
        		q.add(i);
        	}
        }
        while(!q.isEmpty()) {
        	bw.write(q.peek()+" ");
        	int current = q.poll();
        	for(int i=0;i<list[current].size();i++) {
        		int next = list[current].get(i);
        		indegree[next]--;
        		if(indegree[next]==0) {
        			q.add(next);
        		}
        	}
        }
        
        bw.flush();
        bw.close();
        br.close();

	}

}
