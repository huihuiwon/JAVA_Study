import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*트리순회 */
class Node{
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
    }
}

class Tree {
    public Node root;

    public void createNode(char data, char leftData, char rightData) {
        if(root == null) {
            root = new Node(data);
            root.left = leftData != '.' ? new Node(leftData) : null;
            root.right = rightData != '.' ? new Node(rightData) : null;
        }else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public void searchNode(Node node, char data, char leftData, char rightData) {
        if(node == null) {
            return;
        }else if(node.data == data) {
            node.left = leftData != '.' ? new Node(leftData) : null;
            node.right = rightData != '.' ? new Node(rightData) : null;
        }else {
            searchNode(node.left, data, leftData, rightData);  // 오른쪽 재귀 탐색
            searchNode(node.right, data, leftData, rightData);  // 왼쪽 재귀 탐색
        }
    }

    // 전위순회 Preorder : Root -> Left -> Right
    public void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data);
            if(node.left != null) {preOrder(node.left);}
            if(node.right != null) {preOrder(node.right);}
        }
    }

    // 중위순회 Inorder : Left -> Root -> Right
    public void inOrder(Node node) {
        if(node != null) {
            if(node.left != null) {inOrder(node.left);}
            System.out.print(node.data);
            if(node.right != null) {inOrder(node.right);}
        }
    }

    // 후위순회 Postorder : Left -> Right -> Root
    public void postOrder(Node node) {
        if(node != null) {
            if(node.left != null) {postOrder(node.left);}
            if(node.right != null) {postOrder(node.right);}
            System.out.print(node.data);
        }
    }
}

public class P_1991 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Tree t = new Tree();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            t.createNode(root, left, right);
        }

        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);

        br.close();
    }
}
