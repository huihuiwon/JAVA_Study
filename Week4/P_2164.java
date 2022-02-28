import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
/*카드2*/
public class P_2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1;i<=n;i++) {
			queue.add(i);
		}
		while(queue.size()!=1) {
			queue.remove();
			int a =queue.poll();
			queue.add(a);
		}
		bw.write(queue.poll()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
