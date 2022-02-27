package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String data=br.readLine();
			if(data.equals(".")) break;
			sb.append(balance(data)+"\n");
		}
		System.out.println(sb);
	}
	
	public static String balance(String data) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<data.length();i++) {
			char token=data.charAt(i);
			if(token=='('||token=='[') {
				stack.push(token);
			}
			else if(token==')') {
				if(stack.size()!=0&&stack.peek()=='(')stack.pop();
				else return "no";
			}
			else if(token==']') {
				if(stack.size()!=0&&stack.peek()=='[')stack.pop();
				else return "no";
			}
		}
		if(stack.size()==0)return "yes";
		else return "no";
	}
}
