package recursive;
import java.util.Scanner;

public class HanoiTop {
	public static int k=0;
	public static StringBuilder res = new StringBuilder();
		
	public static void main(String[] args) {
		int n;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		hanoi(n,1,2,3);
		System.out.println(k);
		System.out.println(res);
	}
	static void hanoi(int n, int start, int via, int end) {
		if(n==1) {
			k++;
			res.append(start+" "+end+"\n");
		}
		else {
			hanoi(n-1,start,end,via);
			k++;
			res.append(start+" "+end+"\n");
			hanoi(n-1,via,start,end);
		}
	}
	

}
