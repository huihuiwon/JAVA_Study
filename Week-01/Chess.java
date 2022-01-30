package bruteforce;

import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {
		int min=1000;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		
 		String[] str = new String[n];
		for(int i=0;i<n;i++) {
			str[i]= sc.next();	
		}
		
		//8개씩 잘라서 반복
		for(int i=0;i<n-7;i++) {
			for(int j=0;j<m-7;j++) {
				
				int a = color(i,j,str);
				if(a<min) min=a;
			}
		}
		System.out.println(min);
	}
	
	static int color(int start_x,int start_y,String[] str) {
		int w_start=0;
		int b_start=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if((i+j)%2==0) {
					if(str[i+start_x].charAt(start_y+j)=='W')b_start++;
					else w_start++;
				}
				else {
					if(str[i+start_x].charAt(start_y+j)=='W')w_start++;
					else b_start++;
				}
			}
		}
		
		if(b_start>w_start) return w_start;
		else return b_start;
	}
}
