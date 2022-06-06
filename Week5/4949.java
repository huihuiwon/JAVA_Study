import java.util.*;
import java.io.*;


public class Main {	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) break;
			
			Stack<Character> st = new Stack<>();
			boolean flag=false;
			for(char c : str.toCharArray()) {
				if(c=='(') st.push(c);
				else if(c=='[') st.push(c);
				else if(c==')') {
					if(st.isEmpty() || st.pop()=='[') {
						sb.append("no\n");
						flag=true;
						break;
					}
				}
				else if(c==']') {
					if(st.isEmpty() || st.pop()=='(') {
						sb.append("no\n");
						flag=true;
						break;
					}
				}
			}
			if(!st.isEmpty() && !flag)
				sb.append("no\n");
			else if(st.isEmpty() && !flag)
				sb.append("yes\n");
		}
		System.out.println(sb);
	}
	
}