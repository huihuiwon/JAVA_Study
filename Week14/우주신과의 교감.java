import java.util.*;
import java.io.*;


class God implements Comparable<God> {
    int s;
    int e;
    double w;
    
    public God(int s,int e,double w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
 
    @Override
    public int compareTo(God o) {
        return Double.compare(this.w, o.w);
    }
}
public class Main {	

	static int parent[];
	static God[] god;
	static int find(int a) {
		if(parent[a]==a)
			return a;
		else return parent[a]=find(parent[a]);
	}
	
	static void union(int a, int b) {
		if(find(a)!=find(b))
			parent[find(a)]=b;
		else
			return;
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); int m=sc.nextInt();
		
		parent=new int[n];
		god=new God[n];
		
		for(int i=0; i<n; i++)
			parent[i]=i;
		
		ArrayList<God> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			god[i]=new God(x, y, 0);
		}
		
		for(int i=0; i<m; i++) {
			int a=sc.nextInt(); int b=sc.nextInt();
			union(a-1, b-1);
		}
		
		for(int i=0; i<n-1; i++) {
			God tmp = god[i];
			for(int j=i+1; j<n; j++) {
				God tmp2 = god[j];
				double w = Math.sqrt(Math.pow(tmp.s-tmp2.s, 2)+Math.pow(tmp.e-tmp2.e, 2));
				arr.add(new God(i, j, w));
			}
		}
		
		Collections.sort(arr);
		double answer=0;
		for(int i=0; i<arr.size(); i++) {
			God god = arr.get(i);
			if(find(god.s) != find(god.e)) {
				answer+=god.w;
				union(god.s, god.e);
			}
		}
		
		System.out.println(String.format("%.2f", answer));
		
	}
	
}