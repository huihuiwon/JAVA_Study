import java.util.*;
import java.io.*;

public class Main {	
	
	public static String[] solution(String[] arr, int n) {
		Arrays.sort(arr, new Comparator<String>(){
			public int compare(String o1, String o2) {
				if(o1.length()<o2.length())
					return o1.length()-o2.length();
				else if(o1.length()==o2.length())
					return o1.compareTo(o2);
				else
					return o1.length()-o2.length();
				
			}
		});
		return arr;
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		HashSet<String> hs = new HashSet<>();
		for(int i=0; i<n; i++)
			hs.add(sc.next());
		
		int k=0;
		n=hs.size();
		String arr[]=new String[n];
		
		for(String x: hs)
			arr[k++]=x;
	
		for(String x : solution(arr, n))
			System.out.println(x);
	}
}