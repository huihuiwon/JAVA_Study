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
