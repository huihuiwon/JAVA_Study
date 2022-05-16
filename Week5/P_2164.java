import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.LinkedList;
//import java.util.Queue;

public class P_2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		/*
		 *      N = 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
		 * result = 1 2 2 4 2 4 6 8 2  4  6  8 10 12 14 16
		 * N���� ũ�ų� ���� 2�� ������ �ּڰ�: 2^i
		 * result = 2^i - 2*(2^i-N) = 2N-2^i
		 */
		double i = 0;
		while (Math.pow(2, i) < N) {
			i++;
		}
		
		int result = 2*N - (int)(Math.pow(2, i));
		bw.write(String.valueOf(result));
		
		/* 
		 * ť ����ؼ� Ǯ��
		Queue<Integer> q = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			q.add(i);
		}
		//�� �� ���� ������ ���� �� ���� ����+���� ���� �� �ڷ� �ݺ�
		while (q.size() > 1) {
			q.remove();
			int front = q.remove();
			q.add(front);
		}
		bw.write(String.valueOf(q.remove()));
		*/
		
		br.close();
		bw.flush();
		bw.close();
	}

}
