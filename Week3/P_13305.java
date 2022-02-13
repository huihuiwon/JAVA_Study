import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* 주유소 */
public class P_13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // N
		long[] pay = new long[N];
		long[] street = new long[N];
		long result =0;
		long now ;
		
		String s= br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		for(int i =0;i<N-1;i++) {
			street[i] = Long.parseLong(st.nextToken());
		}
		s= br.readLine();
		st = new StringTokenizer(s);
		for(int i =0;i<N;i++) {
			pay[i] = Long.parseLong(st.nextToken());
		}
		now = pay[0];
		result = pay[0] * street[0];
		
		for(int i = 1 ; i < N ; i++){
			if(now <pay[i]) {
				result += now * street[i];
			}
			else {
				now = pay[i];
				result += now * street[i];
			}
		}
		bw.write(result+"\n");
		
		bw.flush();
		bw.close();
		br.close();

	}

}
