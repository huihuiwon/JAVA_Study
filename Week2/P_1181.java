import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class P_1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] word = new String[N];
		for (int i=0; i<N; i++) {
			word[i] = br.readLine();
		}
		
		Arrays.sort(word, new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				int len1 = arg0.length();
				int len2 = arg1.length();
				
				if (len1 == len2) {
					return arg0.compareTo(arg1);
				}
				return (len1 < len2) ? -1 : 1;
			}
		});
		
		bw.write(word[0]);
		for (int i=1; i<N; i++) {
			if (!word[i].equals(word[i-1])) {
				bw.write('\n'+word[i]);
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
}
