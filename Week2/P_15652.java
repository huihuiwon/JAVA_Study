import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* N과 M */


public class P_15652 {
	
	public static int[] arr;
	public static BufferedReader br;
	public static BufferedWriter bw; 
	public static int N;
	public static int M;
	
	public static void dfs(int num,int depth ) throws IOException {
		if(depth ==M) {
			for(int var : arr) {
				bw.write(var+" ");
			}
			bw.write("\n");
		}else {
			for(int i =num ;i<=N;i++) {
					arr[depth] = i;
					dfs(i,depth+1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s= br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		dfs(1,0);
		

		bw.flush();
		bw.close();
		br.close();

	}

}
 
