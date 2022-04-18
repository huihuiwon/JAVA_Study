import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P_11729 {
	static StringBuilder seq = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf((int)Math.pow(2, N)-1));
		hanoi(N, 1, 2, 3);
		bw.write(String.valueOf(seq));
		
		br.close();
		bw.flush();
		bw.close();
	}

	public static void hanoi(int n, int s, int m, int e) {
		//n>1 n-1을 s->m
		//n번째 원판을 s->e
		//n>1 n-1을 m->e
		if (n > 1) {
			hanoi(n-1, s, e, m);
		}
		
		seq.append("\n" + s + " " + e);
		
		if (n > 1) {
			hanoi(n-1, m, s, e);
		}
	}
}
