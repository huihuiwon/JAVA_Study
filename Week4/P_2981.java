import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/* 검문 */
public class P_2981 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num); // number 정렬
		 int g = num[1] -  num[0];
	        for(int i = 2; i < N; i++) {
	            g = gcd(g, num[i] - num[i - 1]);
	        }

	        for(int i = 2; i <= g; i++) {
	            if(g % i == 0)
	                bw.write(i + " ");
	        }
	        bw.flush();
			bw.close();
			br.close();
	    }

	    public static int gcd(int a, int b) {
	        if(b == 0)
	            return a;
	        return gcd(b, a % b);
	    }
}
