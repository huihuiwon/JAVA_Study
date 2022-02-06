package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Nqueen {
	static int cnt=0;
	static int n;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int arr[]= new int[n];
			arr[0]=i;
			queen(1,arr);
		}
		System.out.println(cnt);
	}
	
	static void queen(int now,int arr[]) {
		if(now>=n) {
			cnt++;
		}
		else {
			//ArrayList<Integer> rr= new ArrayList<>();
			
			/*for(int i=0;i<now;i++) {
				rr.add(arr[i]);
				int a=now-i;
				rr.add(arr[i]+a);
				rr.add(arr[i]-a);
			}*/
			
			for(int i=0;i<n;i++) {
				int chk=0;
				for(int j=0;j<now;j++) {
					int a=now-j;
					if(arr[j]==i) {
						chk=1;
						break;
					}
					else if(arr[j]+a==i || arr[j]-a==i) {
						chk=1;
						break;
					}
				}
				if(chk==0) {
					arr[now]=i;
					queen(now+1,arr);
				}
				
			}
		}
		
	}

}
