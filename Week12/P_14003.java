import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_14003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> LIS = new ArrayList<>(); //LIS ����
		int[] index = new int[N]; //������ LIS������ ��ġ ���
		
		//LIS ���� ���ϱ�
		for (int i=0; i<N; i++) {
			//LIS�� ����ų� ���� ���ڰ� LIS ������ ���ں��� ũ�� �ڿ� �ٷ� �߰�
			//�ƴϸ� �̺�Ž������ ��ġ ã�Ƽ� �ֱ�
			if (LIS.isEmpty() || A[i]>LIS.get(LIS.size()-1)) {
				LIS.add(A[i]);
				index[i] = LIS.size()-1;
			}
			else {
				int idx = binarySearch(A[i], LIS);
				LIS.set(idx, A[i]);
				index[i] = idx;
			}
		}
		bw.write(String.valueOf(LIS.size())+"\n");
		
		//LIS ������ ���ں��� �������� ã�� ������ �̿��Ͽ� ���
		int idx = LIS.size()-1;
		Stack<Integer> s= new Stack<>();
		for (int i=N-1; i>=0; i--) {
			if (index[i] == idx) {
				s.push(A[i]);
				idx--;
			}
		}
		
		while (!s.isEmpty()) {
			bw.write(String.valueOf(s.pop())+" ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int binarySearch(int key, ArrayList<Integer> arr) {
		int mid;
		int left = 0;
		int right = arr.size()-1;
		
		while (left < right) {
			mid = (left + right) / 2;
			if (key <= arr.get(mid)) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		return left;
	}

}
