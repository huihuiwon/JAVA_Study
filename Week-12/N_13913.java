package dp_easymean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class N_13913 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] a=br.readLine().split(" ");
		int n = Integer.parseInt(a[0]);
		int k = Integer.parseInt(a[1]);
		
		bfs(n,k);
		
	}
	
	//bfs
	public static int bfs(int n,int k) {
		boolean[] visited=new boolean[100001];
		StringBuilder sb =new StringBuilder();
		int[] dp = new int[100001];
		Stack<Integer> stack = new Stack<>();
		Queue<int[]> queue=new LinkedList<int[]>();
		
		int answer=-1;
		visited[n]=true;
		queue.add(new int[] {n,0});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			
			if(now[0]==k) { //도착
				answer=now[1];

				//경로의 길이와 경로를 출력한다.
				sb.append(answer+"\n");
				int z=now[0];
				while(z!=n) {
					stack.add(z);
					z=dp[z];
				}
				stack.add(z);
				while(!stack.isEmpty()) sb.append(stack.pop()+" ");
				
				System.out.println(sb);
				break;
			}
			
			if(now[0]-1>=0&&visited[now[0]-1]==false) {
				queue.add(new int[] {now[0]-1,now[1]+1});
				visited[now[0]-1]=true;
				dp[now[0]-1]=now[0];
			}
			if(now[0]+1<=100000&&visited[now[0]+1]==false) {
				queue.add(new int[] {now[0]+1,now[1]+1});
				visited[now[0]+1]=true;
				dp[now[0]+1]=now[0];
			}
			if(now[0]*2<=100000&&visited[now[0]*2]==false) {
				queue.add(new int[] {now[0]*2,now[1]+1});
				visited[now[0]*2]=true;
				dp[now[0]*2]=now[0];
			}
		}
		return answer;
	}

}
