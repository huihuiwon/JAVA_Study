package bruteforce;
import java.util.Scanner;

public class Shom {

	public static void main(String[] args) {
		int num = 666;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		while(n>0) {
			if(Integer.toString(num).contains("666")) {
				n-=1;
			}
			num+=1;
		}
		System.out.println(num-1);
	}
	
	
}
