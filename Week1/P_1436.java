import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		br.close();
		
		int i = 1;
		int m = 666;
		while (N != i) {
			m++;
			if (String.valueOf(m).contains("666")) {
				i++;
			}
		}
		
		System.out.println(m);
		
	}

}
