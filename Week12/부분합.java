import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*부분*/
public class P_1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] num = new int[n+1];
		int sum =0;
		int right =0;
		int left =0; 
		int length = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		while(true) {
			if(sum>= s) {
				sum -= num[left];
				left++;
				length = Math.min(length, (right-left)+1);
			}else if(right == n) break;
			else {
				sum += num[right++];
			}
		}
		if(length == Integer.MAX_VALUE) {
			bw.write(0+"\n");
		}else {
			bw.write(length + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	

}
