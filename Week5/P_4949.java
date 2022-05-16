import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P_4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//종료조건(.)이 들어올 때까지 입력 받음
		String str = br.readLine();
		while (!str.equals(".")) {
			Stack<Character> s = new Stack<>();
			
			String result = "yes";
			
			char[] sarr = str.toCharArray();
			for (char c : sarr) {
				//여는 괄호면 스택에 넣음
				//닫는 괄호면 스택에서 여는 괄호를 꺼내 짝이 맞는지 확인
				if (c == '(' || c == '[') {
					s.push(c);
				}
				else if (c == ')') {
					if (s.isEmpty() || (s.pop() != '(')) {
						result = "no";
						break;
					}
				}
				else if (c == ']') {
					if (s.isEmpty() || (s.pop() != '[')) {
						result = "no";
						break;
					}
				}
			}
			//마지막 문자까지 확인했을 때 스택에 남은 문자가 있는지 확인
			//스택에 남은게 있으면 no/없으면 yes
			if (result.equals("yes") && !s.isEmpty()) {
				result = "no";
			}
			
			bw.write(result+"\n");
			
			str = br.readLine();
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
