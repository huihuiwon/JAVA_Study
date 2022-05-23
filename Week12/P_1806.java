import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P_1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lo = 0;
		int hi = 0;
		int min_len = N+1; //초깃값:수열 길이+1
		int sum = 0; //lo-hi전까지 수열 합(=arr[lo]+...+arr[hi-1])
		
		while (true) {
			if (sum >= S) {
				sum -= arr[lo++];
			}
			else {
				if (hi == N) { //hi가 범위를 넘어서면 끝냄
					break;
				}
				sum += arr[hi++];
			}
			if (sum >= S)
				min_len = Math.min(hi-lo, min_len);
		}
		
		if (min_len == N+1) {
			bw.write("0");
		}
		else {
			bw.write(String.valueOf(min_len));
		}
			
		br.close();
		bw.flush();
		bw.close();
	}

}
