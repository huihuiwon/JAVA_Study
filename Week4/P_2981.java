import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class P_2981 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//a1, a2는 어떤 수 M(>1)으로 나눴을 때 나머지가 r로 같음
		//a1 = A1 * M + r, a2 = A2 * M + r
		//a1-a2= M(A1-A2)
		//M: a1-a2의 약수 & a2-a3의 약수 & => 최대공약수의 약수
		int gcdM = Math.abs(arr[0]-arr[1]);
		for (int i=2; i<N; i++) {
			gcdM = gcd(gcdM, Math.abs(arr[i-1]-arr[i]));
		}
		
		//1을 제외한 약수 구하기
		ArrayList<Integer> M = new ArrayList<Integer>();
		for (int i=2; i<=Math.sqrt(gcdM); i++) {
			if (i*i == gcdM) {
				M.add(i);
			}
			else if (gcdM % i == 0) {
				M.add(i);
				M.add(gcdM/i);
			}
		}
		M.add(gcdM);
		
		Collections.sort(M);
		for (int i : M) {
			bw.write(i+ " ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}

}
