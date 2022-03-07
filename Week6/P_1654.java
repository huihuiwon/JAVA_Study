import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/*랜선길이 */

public class P_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		long N = Long.parseLong(st.nextToken());
		int [] length = new int[K];
		
		for(int i = 0 ; i < K ; i ++) {
			length[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(length);
		long max = length[K-1];
		long min =1 ; // 랜선 길이는 자연수기 때문 1로 초기화
		long mid = 0;
		
		while(max>= min) {
			mid = (max+min)/2;
			long cnt = 0;
			for(int i= 0 ; i < length.length;i++) {
				cnt += length[i]/mid;
			}
			if(cnt >= N) {
				min = mid+1;
			}else {
				max = mid-1;
			}
		}
		bw.write(max+"\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
