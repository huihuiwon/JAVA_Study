import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* 영화감독 슘 */
public class P_1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 시리즈 번호 
		int result=1;
		int a = 666;
		
		while(true) {
			if(result == N) break;
			a++;
			if(String.valueOf(a).contains("666")){
				result++;
			}
		}
		bw.write(a+"\n");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
