import java.util.*;
import java.io.*;


public class Main {	
	
	static int solution(int n, int m, boolean board[][]) {
		int answer=64;
		for(int i=0; i<n-7; i++) {
			for(int j=0; j<m-7; j++) {
				int tmp=0; boolean chk=true;
				for(int ii=i; ii<i+8; ii++) {
					for(int jj=j; jj<j+8; jj++) {
						if(chk!=board[ii][jj]) tmp++;
						chk=!chk;
					}
					chk=!chk;
				}
				tmp=Math.min(tmp, 64-tmp);
				if(tmp<answer) answer=tmp;
			}
		}
		return answer;
	}
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); int m=sc.nextInt();
		boolean board[][]=new boolean[n][m];
		for(int i=0; i<n; i++) {
			String tmp=sc.next();
			for(int j=0; j<m; j++) {
				if(tmp.charAt(j)=='W')
					board[i][j]=true;
				else
					board[i][j]=false;
			}
		}
		System.out.println(solution(n,m,board));
	}
}