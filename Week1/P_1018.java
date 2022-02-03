import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*체스판 다시 칠하기 */
public class P_1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int min = 64;
		String s= br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int a = Integer.parseInt(st.nextToken());//세로 
		int b = Integer.parseInt(st.nextToken()); //가로
		Boolean[][] color = new Boolean[a][b];
		
		for(int i = 0 ; i<a;i++) {
			String str = br.readLine();
			for(int j = 0 ; j < b;j++) {
				if(str.charAt(j)== 'W') {
					color[i][j] = true; //w일때는 true
				}
				else color[i][j]=false; //b일때는 false
			}
		}
		for(int i =0;i<a-7;i++) {
			for(int j =0;j<b-7;j++) {
				int countW=0; 	/* 첫번째가 흰색일 경우*/ 
				int countB=0; 	/*첫번째가 검은색일 경우*/ 
				for(int k = i;k<i+8;k++) { 	/*세로 8개 하나씩 확인*/  
					for(int t=j;t<j+8;t++) { /*가로 8개 하나씩 확인*/ 
						if((k+t)%2 ==0) { //짝수면 첫번째 색과 같아야함 
							if(color[k][t]==true) countB++;
							else countW++;
						}else { //홀수면 첫번째 색과 달라야함. 
							if(color[k][t]==true) countW++;
							else countB++;
						}
					}
				}
				min = Math.min(min, countB);
				min = Math.min(min, countW);
			}
		}
		bw.write(min+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
