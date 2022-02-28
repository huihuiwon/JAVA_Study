import java.util.*;
import java.io.*;


public class Main {	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int ti=0; ti<t; ti++) {
			String p=br.readLine();
			int n=Integer.parseInt(br.readLine());
			boolean order=false;
			boolean flag=false;
			StringTokenizer st = new StringTokenizer(br.readLine(), "[|]|,");
			Deque<Integer> dq = new LinkedList<>();
			while(st.hasMoreTokens()) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			
			for(char c : p.toCharArray()) {
				if(c=='R') {
					order=!order;
				}
				else {
					if(dq.isEmpty()) {
						sb.append("error\n");
						flag=true;
						break;
					}
					else {
						if(order)
							dq.pollLast();
						else
							dq.pollFirst();
					}
				}
			}
			if(!flag) {
				if(dq.size()==0)
					sb.append("[]\n");
				else {
					sb.append("[");
					if(order) {
						while(!dq.isEmpty())
							sb.append(dq.pollLast()+",");
					}
					else {
						while(!dq.isEmpty()) {
							sb.append(dq.pollFirst()+",");
						}
					}
					sb.replace(sb.length()-1, sb.length(),"]\n");
				}
			}
		}
		System.out.println(sb);
	}
	
}