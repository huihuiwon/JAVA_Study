import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
/*오큰수 */
public class P_17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] NGE = new int[N];
		String s= br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		for(int i = 0 ; i <N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack= new Stack<>();
		stack.push(0);
		
		for(int i = 1; i<N;i++) {
			while(!stack.empty()&&A[stack.peek()]<A[i]) {
				NGE[stack.pop()] = A[i];
			}
			stack.push(i);
		}
		while(!stack.empty()) {
			NGE[stack.pop()]= -1;
		}
		for(int i =0 ; i< N;i++) {
			bw.write(NGE[i]+" ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
