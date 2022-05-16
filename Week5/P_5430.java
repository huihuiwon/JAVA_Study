import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class P_5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			char[] p = br.readLine().toCharArray();
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), ",[]");
			Deque<Integer> dq = new ArrayDeque<>();
			for (int j=0; j<n; j++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean front = true;
			boolean error = false;
			for (char func : p) {
				if (func == 'R') {
					front = !front;
				}
				else if (func == 'D') {
					if (dq.isEmpty()) {
						error = true;
						break;
					}
					if (front) {
						dq.remove();
					}
					else {
						dq.removeLast();
					}
				}
			}
			
			if (error) {
				bw.write("error\n");
			}
			else {
				Iterator<Integer> iter;
				iter = front ? dq.iterator(): dq.descendingIterator();
				bw.write("[");
				if (iter.hasNext()) {
					bw.write(String.valueOf(iter.next()));
					while (iter.hasNext()) {
						bw.write(","+String.valueOf(iter.next()));
					}
				}
				bw.write("]\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
