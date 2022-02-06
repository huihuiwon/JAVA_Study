package backtracking;

import java.util.Scanner;

public class NandM4 {
	static StringBuilder res = new StringBuilder();
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			backtracking(i,m,"");
		}
		
		System.out.println(res);
	}
	
	static void backtracking(int now,int m,String rr) {
		if(m<=1) {
			rr+=now+"\n";
			res.append(rr);
		}
		else {
			rr+=now+" ";
			for(int i=now;i<=n;i++) {
				backtracking(i,m-1,rr);
			}
		}
	}

}
