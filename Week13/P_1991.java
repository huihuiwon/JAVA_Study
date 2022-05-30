import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P_1991 {
	static BufferedWriter bw;
	
	static class Node {
		char data;
		Node left;
		Node right;
		
		public Node(char data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public Node(char data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	static class Tree {
		Node root;
		
		public Tree() {
			this.root = null;
		}
		
		public Tree(Node root) {
			this.root = root;
		}
		
		public void preOrder(Node cur) throws IOException {
			if (cur != null) {
				bw.write((char)cur.data);
				preOrder(cur.left);
				preOrder(cur.right);
			}
		}
		
		public void inOrder(Node cur) throws IOException {
			if (cur != null) {
				inOrder(cur.left);
				bw.write((char)cur.data);
				inOrder(cur.right);
			}
		}

		public void postOrder(Node cur) throws IOException {
			if (cur != null) {
				postOrder(cur.left);
				postOrder(cur.right);
				bw.write((char)cur.data);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Node[] node = new Node[N];
		for (int i=0; i<N; i++) {
			node[i] = new Node((char)(65+i));
		}
		
		Tree tree = new Tree(node[0]);
		
		for (int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			Node n = node[s[0].charAt(0)-65];
			if (!s[1].equals("."))
				n.left = node[s[1].charAt(0)-65];
			if (!s[2].equals("."))
				n.right = node[s[2].charAt(0)-65];
		}
		
		tree.preOrder(tree.root);
		bw.write("\n");
		tree.inOrder(tree.root);
		bw.write("\n");
		tree.postOrder(tree.root);
		
		br.close();
		bw.flush();
		bw.close();
	}

}