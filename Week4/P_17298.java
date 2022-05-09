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
		
		//찾을 수열의 index를 스택에 저장
		//0->N 현재 위치(i)의 값이 스택의 값들보다 큰 지 비교
		//크면 해당 index의 오큰수를 현재 값으로 기록
		//작으면 스택에 다시 남겨둠
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
		
		//스택에 남은 index의 오큰수는 -1
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
