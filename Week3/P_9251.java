import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a = br.readLine();
		String b = br.readLine();
		
		int[][] lcs = new int[a.length()+1][b.length()+1];
		
		for (int i=1; i<=a.length(); i++) {
			for (int j=1; j<=b.length(); j++) {
				if (a.charAt(i-1) == b.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1]+1;
				}
				else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}

		bw.write(String.valueOf(lcs[a.length()][b.length()]));
		
		br.close();
		bw.flush();
		bw.close();
	}

}
