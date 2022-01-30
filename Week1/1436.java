import java.util.*;
import java.io.*;


public class Main {	
	
	static int solution(int n) {
		int answer=0; int cnt=0;
		for(int i=666; i<=Integer.MAX_VALUE; i++) {
			if(Integer.toString(i).contains("666"))
				cnt++;
			if(n==cnt) {
				answer=i;
				break;
			}
		}
		return answer;
	}
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(solution(n));
	}
}