import java.io.*;

public class P_11729 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void hanoi(int n,int start, int end , int mid) throws IOException{
		if(n==1) {
			bw.write(start+" "+end+"\n");
		}
		else {
			hanoi(n-1,start,mid,end);// 1번에서 n-1개를 3번을 거쳐서 2번으로 옮기는 작업 
			bw.write(start+" "+end+"\n");//남아있는 원반하나를 3번으로 옮기는 작업
			hanoi(n-1,mid,end,start); // 2번에서 n-1개를 1번을 거쳐서 3번으로 옮기는 작업 
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int k= (int) (Math.pow(2, N)-1); //옮긴 횟수
			bw.write(k+"\n");
			hanoi(N,1,3,2); //1번에서 3번으로 가는데 2번을 경유하겠다.
			br.close();
			bw.flush();
			bw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}

}
