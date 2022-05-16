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
		
		//��������(.)�� ���� ������ �Է� ����
		String str = br.readLine();
		while (!str.equals(".")) {
			Stack<Character> s = new Stack<>();
			
			String result = "yes";
			
			char[] sarr = str.toCharArray();
			for (char c : sarr) {
				//���� ��ȣ�� ���ÿ� ����
				//�ݴ� ��ȣ�� ���ÿ��� ���� ��ȣ�� ���� ¦�� �´��� Ȯ��
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
			//������ ���ڱ��� Ȯ������ �� ���ÿ� ���� ���ڰ� �ִ��� Ȯ��
			//���ÿ� ������ ������ no/������ yes
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
