import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
/*AC*/
public class P_5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int t = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		for(int i = 0 ; i < t; i++) {
			char[] p =  (br.readLine()).toCharArray(); 
			int n = Integer.parseInt(br.readLine()); //배열 개수 
			String[] separatedStrings = br.readLine().replaceAll("\\[","").replaceAll("]", "").split(",");
			Deque<Integer> deq = new ArrayDeque<>();
			boolean error = false;
			for(int j = 0 ; j < n ; j++) {
				deq.add(Integer.parseInt(separatedStrings[j]));	
			}
			boolean isRight = false;
			for(int j =0 ; j < p.length;j++) {
				if(p[j] == 'R') {
					isRight = !isRight;
					
				}
				else if(p[j] =='D') {
					if(deq.size()==0) {error = true; break;}
					if(isRight) {
						deq.removeLast();
					}
					else {
						deq.removeFirst();
					}
				}
			}
			
			if(!error) {
				if(deq.size()==0) bw.write("[]\n");
				else {bw.write("[");
					if(isRight) {
						bw.write(deq.pollLast().toString());
						while(!deq.isEmpty()) {
							bw.write(","+deq.pollLast());
						}
					}else {
						bw.write(deq.pollFirst().toString());
						while(!deq.isEmpty()) {
							bw.write(","+deq.pollFirst());
						}
					}
					bw.write("]\n");
				}
			}
			else bw.write("error\n");

		
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
