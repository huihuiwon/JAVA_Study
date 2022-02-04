package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WordSort {

	public static void main(String[] args) {
		StringBuilder res = new StringBuilder();
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		sc.nextLine();
		
		String[] arr = new String[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2); //s1가 s2보다 사전적으로 순서가 앞인지, 뒤인지를 상수로 반환
				}
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
		
		for(int i=0;i<n;i++) {
			if(i!=0 && arr[i].equals(arr[i-1])) {
				continue;
			}
			res.append(arr[i]+"\n");
		}
		System.out.println(res);
	}

}
