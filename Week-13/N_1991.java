package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Node {
	String data;
	Node left;
	Node right;
	
	public Node(String data) {
		this.data = data;
		this.left=null;
		this.right=null;
	}
	
	public void addLeft(Node left) {
		this.left=left;
	}
	
	public void addRight(Node right) {
		this.right=right;
	}
	
}

public class N_1991 {
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Node> map = new HashMap<String,Node>();
		
		int n= Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		
		for(int i=0;i<n;i++) {
			String[] str=br.readLine().split(" ");
			
			if(map.get(str[0])==null) map.put(str[0], new Node(str[0]));
			
			Node now=map.get(str[0]);
			
			if(!str[1].equals(".")) {
				map.put(str[1], new Node(str[1]));
				now.addLeft(map.get(str[1]));
			}
			if(!str[2].equals(".")) {
				map.put(str[2], new Node(str[2]));
				now.addRight(map.get(str[2]));
			}			
		}
		Node start=map.get("A");
		preorder(start);
		System.out.println(sb);
		sb.setLength(0);
		
		inorder(start);
		System.out.println(sb);
		sb.setLength(0);
		
		postorder(start);
		System.out.println(sb);
	}
	
	public static void preorder(Node node) {
		sb.append(node.data);
		if(node.left!=null)preorder(node.left);
		if(node.right!=null)preorder(node.right);
	}
	public static void inorder(Node node) {
		if(node.left!=null)inorder(node.left);
		sb.append(node.data);
		if(node.right!=null)inorder(node.right);
	}
	
	public static void postorder(Node node) {
		if(node.left!=null)postorder(node.left);
		if(node.right!=null)postorder(node.right);
		sb.append(node.data);
	}

}
