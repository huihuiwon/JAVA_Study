import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
/*균형잡힌 세상 */
public class P_4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] string = new char[101];
		Stack<Character> stack = new Stack<>();
		while(true) {
			String temp = br.readLine();
			string =temp.toCharArray();
			if(string[0] == '.' ) {
				break;
			}
			stack.clear();
			for(int i = 0 ; i< string.length;i++) {
				
				if(string[i] == '(' || string[i] =='[') {
					stack.push(string[i]);
				}
				else if(string[i] == ')') {
					if(stack.empty()) {
						stack.push(string[i]);
						break;
					}
					if(stack.peek() == '(') stack.pop();
					else {
						stack.push(string[i]);
						break;
					}
				}
				else if(string[i] == ']') {
					if(stack.empty()) {
						stack.push(string[i]);
						break;
					}
					if(stack.peek() == '[') stack.pop();
					else {
						stack.push(string[i]);
						break;
					}
				}
			}
			if(stack.empty()) bw.write("yes\n");
			else bw.write("no\n");
			
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
