# 13주차 문제풀이

## 트리의 지름

트리의 최대 지름을 출력

⇒ dfs 를 이용해서 루트부터 아래로 내려가면서 최대 길이를 구한다.

<br/>

ArrayList<Node> 배열을 통해 노드 간 연결 저장

list[현재 노드].add(new Node(자식 노드, 가중치));

</br>
  
1. 노드 1부터 탐색
2. 현재 노드에서 아래 노드들의 최대 길이를 dfs 호출하면서 확인한다
3. 아래 노드들의 길이 제일 큰 값을 max1 , 두번째로 큰 값을 max2 에 넣는다.
4. 만약 max1 , max2 다 0이 아니면 `answer=Math.max(max1+max2, answer)`
5. 4번 경우가 아니면 `answer=Math.max(max1, answer)`
6. dfs 끝난 후, answer 출력

4, 5번 처럼 나눠주는 이유는, 루트 노드에서 하나의 노드만 존재하는 경우가 있음. 그 경우에는 5번 경우를 통해 max 값을 구해야 한다.

</br>

dfs 코드

```java
public static int dfs(int now) {
		int max1=0;
		int max2=0;

		for(Node2 node:list[now]) { //자식 노드 탐색
			if(!visited[node.n]) { 
				int value=dfs(node.n)+node.w; //자식 노드의 최대길이 구함

				//max1보다 value 가 크면
				if(max1<value) { 
					max2=max1; 
					max1=value;
				}
				//value가 max1 보다는 작고 max2 보다는 크면
				else if(max2<value)max2=value;
				
				visited[node.n]=true;
			}
		}
    //max1, max2가 다 0 이 아니면 두 개를 더한 값을 업데이트
		if(max1!=0&&max2!=0) {
			answer=Math.max(max1+max2, answer);
		}
		else { //max1에 대해 업데이트
			answer=Math.max(max1, answer);
		}
		return max1;
	}
```

## 트리 순회

> 이진트리를 입력받아서 preorder, inorder , postorder 순회를 하는 문제
> 

</br>

노드 클래스를 생성해 이진트리를 형성함

```java
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
```

</br>

HashMap 을 사용해서 (key는 노드 이름(String), value는 노드) 노드들을 입력받을 때 중복을 제거함

```java
HashMap<String, Node> map = new HashMap<String,Node>();

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
```

hashmap map 에 대해 map.get(node이름) 이 비어있으면 노드를 새로 추가하고, 비어있지 않으면 map.get(node이름) 해서 노드 간 연결을 해줌

</br>

### 순회방법

- 재귀함수 사용
- stringbuilder를 통해 출력값을 추가

### preorder

root → left → right

```java
public static void preorder(Node node) {
		sb.append(node.data);
		if(node.left!=null)preorder(node.left);
		if(node.right!=null)preorder(node.right);
	}
```

### inorder

left → root → right

```java
public static void inorder(Node node) {
		if(node.left!=null)inorder(node.left);
		sb.append(node.data);
		if(node.right!=null)inorder(node.right);
	}
```

### postorder

left → right → root

```java
public static void postorder(Node node) {
		if(node.left!=null)postorder(node.left);
		if(node.right!=null)postorder(node.right);
		sb.append(node.data);
	}
```
