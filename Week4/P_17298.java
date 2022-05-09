import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//ã�� ������ index�� ���ÿ� ����
		//0->N ���� ��ġ(i)�� ���� ������ ���麸�� ū �� ��
		//ũ�� �ش� index�� ��ū���� ���� ������ ���
		//������ ���ÿ� �ٽ� ���ܵ�
		int[] NGE = new int[N];
		Stack<Integer> s = new Stack<>();
		s.push(0);
		for (int i=1; i<N; i++) {
			while (!s.isEmpty()) {
				int index = s.pop();
				if (A[index] < A[i]) {
					NGE[index] = A[i];
				}
				else {
					s.push(index);
					break;
				}
			}
			s.push(i);
		}
		
		//���ÿ� ���� index�� ��ū���� -1
		while (!s.isEmpty()) {
			NGE[s.pop()] = -1;
		}
		
		for (int i : NGE) {
			bw.write(i + " ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
