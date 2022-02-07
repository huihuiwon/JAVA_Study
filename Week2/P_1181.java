import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/* 단어 정렬 */
public class P_1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 단어 개수 
		String[] word = new String[N];
		for(int i =0;i<N;i++) {
			word[i] = br.readLine();
		}
		word = Arrays.stream(word).distinct().toArray(String[]::new);  //중복 제거를 위해 string -> stream으로 변경후 toArray를 통해 String으로 변환
		for(int i = 0 ; i < word.length;i++) {
			for(int j=i+1;j<word.length;j++) {
				if(word[i].length() == word[j].length()) { // 단어 길이가 같을 경우 
					if(word[i].compareTo(word[j])>0) {
						String temp = word[i];
						word[i] = word[j];
						word[j] = temp;
					}
				
				}
				else if(word[i].length()> word[j].length()) { // 단어 길이가 앞에거보다 짧을 경우 
					String temp = word[i];
					word[i] = word[j];
					word[j] = temp;
				}
				
			}
		}
		 
		
		for(int i =0;i<word.length;i++) {
			bw.write(word[i]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
