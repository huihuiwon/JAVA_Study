# 12주차 문제풀이

## 부분합

> 1차원 배열이 있고, 이 배열에서 다른 원소를 가리키고 있는 2개의 포인터를 조작해가면서 원하는 것을 얻는 형태. 이 때문에 투포인터 알고리즘이라고 불린다.
> 

10,000 이하의 자연수로 이루어진 길이 N 짜리 수열에서 연속된 수들의 부분합 중에 합이 S 이상이 되는 것 중 가장 짧은 길이 구하기

출발점을 1씩 증가시키면서 최대 부분 연속 수열 길이를 확인한다.

</br>

### 특정 합을 가지는 부분 연속 수열 찾기

1. 시작점과 끝점이 첫번째 원소의 인덱스를 가리키도록 한다.
2. 현재 부분 합이 S 이상이면 카운트한다. 시작점을 1 증가시키고, 끝점도 시작점으로 업데이트해준다.
3. 현재 부분 합이 S보다 작다면 end를 1 증가시킨다.
4. 모든 경우를 확인할 때까지 2~3번 과정을 반복한다. ( end < n 일 때까지 반복하게 함)

```java
		long answer=100000000;
		int start=0;int end=0;
		long sum=0;
		
		while(end<n) { //end가 n보다 작을때까지만 반복한다.
		// end가 n-1만큼 왔는데 sum이 s보다 작다면 시작점을 늘려도 s보다 sum이 작음
			sum+=arr[end]; //합 구하기
			
			if(sum>=s) { //합이 s보다 크면
				if(end-start+1<answer)answer=end-start+1;  //길이 업데이트
				end=++start; //start +1 해주고, end=start 해줌.
				sum=0;
			}

			else end++;
		}
		
		//출력
		if(answer==100000000)System.out.println(0); //초기값과 그대로면 0 출력
		else System.out.println(answer);
```

</br>


## 가장 긴 증가하는 부분 수열 5

수열 A에 대해 가장 긴 증가하는 부분 수열을 구하는 문제

</br>

- 이진탐색 ( O(n^2) ) → 가장 긴 증가하는 부분 수열 2
- 수열 출력 → 가장 긴 증가하는 부분 수열 4

### 1. 이진탐색

기존의 동적계획법 (이중for문) 에서는 시간복잡도 O(n^2) 로 시간초과가 발생한다.

이진탐색을 통해 시간복잡도를 O(nlogn) 으로 줄일 수 있다.

하지만 수열은 정렬되어있지 않음. (이분탐색은 정렬된 배열에서만 사용 가능) 

→ 같은 크기의 증가 수열에서 마지막 값 중 최솟값을 배열에 저장하고 이분탐색을 진행한다.

### 방법

len = 0 부터 시작. memo 에 해당 index 길이만큼의 증가수열들 중 마지막 값의 최소값을 저장함

- memo[len] < arr[i] 이면 , memo[++len] = arr[i] 저장.
- 아니라면, memo 배열에 대해 binarySearch를 해서 arr[i] 가 들어갈 위치를 찾도록 함. 그리고 len은 해당 위치로 변경

arr = {5,6,7,1,2,3,4} 일 때 시뮬레이션

![image](https://user-images.githubusercontent.com/57666289/169760076-f5ff0954-4323-4eea-9923-26dcccf8e5ba.png)

![image](https://user-images.githubusercontent.com/57666289/169760092-4cb8937a-be95-423e-8d17-278e3ccaa080.png)


이분탐색 하는 코드

```java
		int len=0;
		dp[0]=data[0];

		for(int i=1;i<n;i++) {

			if(data[i]>dp[len]) { //dp 값보다 크면 dp[++len] 에 data[i] 값 저장
				dp[++len]=data[i];
			}
			
			else {
				//이분탐색 실시. data[i] 가 들어갈 위치 탐색
				int left=0;int right=len;
				while(left<right) {
					int mid=(left+right)/2;	
					
					if(dp[mid]<data[i]) {
						left=mid+1;
					}
					else { //dp[mid]가 더 크면.
						right=mid;
					}
				}
				dp[right]=data[i];
			}				
		}
```

</br>

### 2. 수열 출력

이분탐색으로 시간복잡도를 O(nlogn) 로 줄였지만, 정답 수열도 출력해야 한다.

</br>

배열 data 에 대해 index 0~i 까지 중에서 가장 긴 수열 길이를 배열 da에 저장한다고 하자. ( O(n^2) dp 방법)

ex) data = {10, 20, 10, 30, 20, 50}
| data | 10 | 20 | 10 | 30 | 20 | 50 |
| --- | --- | --- | --- | --- | --- | --- |
| da | 1 | 2 | 1 | 3 | 2 | 4 |

da 를 맨 끝에서부터 보면서, 4 → 3 → 2 → 1 순으로 data 를 출력하게 하면 된다.

그럼 50 → 30 → 20 → 10을 출력하는데, 반대로 출력하기 위해 stack 이나 stringbuilder의 insert를 사용하면 된다.

stringbuilder insert를 통해 처음 위치에 넣는 방식

```java
int a = answer;
for(int i=n-1;i>=0;i--) {
		if(a==da[i]) {
			sb.insert(0, data[i]+" ");
			a--;
}
```

sb.insert(0, 넣을 데이터) 를 통해 뒤에 데이터를 추가하는게 아닌 인덱스 0에 데이터를 삽입하도록 해 반대로 출력하게 할 수 있다.

</br>

하지만 insert 를 쓰니까 시간초과가 걸린다..! 특정 인덱스에 데이터를 추가하고 배열을 재정리하는 방식이라 시간초과가 걸리는 것 같다.

따라서 **Stack** 을 사용해 해결

```java
		Stack<Integer> stack = new Stack();
		
		for(int i=n-1;i>=0;i--) {
			if(a==da[i]) {
				stack.push(data[i]);
				a--;
			}
		}
		
		while(!stack.isEmpty())sb.append(stack.pop()+" ");
```

뒤에서부터 보면서 stack 에 담고, 다시 꺼내서 stringbuilder 에 추가


</br>
</br>

## 숨바꼭질 4

세 가지 이동 존재 (현재 위치 X)

1. X-1 (뒤로이동)
2. X+1 (앞으로 이동)
3. 2*X (순간이동)


**bfs를 통해 최단경로를 출력**
- visited 배열을 넣어 이미 방문한 곳은 더 보지 않도록 한다.
- bfs의 큐에는 배열을 넣게 해, {현재 위치, 현재까지 경로길이} 를 넣도록 한다
    
    `Queue<int[]> queue=new LinkedList<int[]>();`
    
- 역추적을 위해 dp 배열에 방문하려는 위치의 이전 위치를 저장하도록 한다.

dp에 해당 위치 직전에 방문한 값을 넣어, 경로를 출력할 수 있게 한다.

| 현재 위치 | 5 | 10 | 9 | 18 | 17 |
| --- | --- | --- | --- | --- | --- |
| dp (직전에 방문한 값) | -1 | 5 | 10 | 9 | 18 |

dp 값이 출발위치일 때까지 탐색한다.

그럼 stack에 17 → 18 → 9 → 10 → 5 순으로 넣게 되고, stack에서 꺼내면서 경로인 5 10 9 18 17 을 출력하게 됨

bfs && 경로 출력 코드

```java
//bfs
	public static int bfs(int n,int k) {
		boolean[] visited=new boolean[100001];
		StringBuilder sb =new StringBuilder();
		int[] dp = new int[100001];
		Stack<Integer> stack = new Stack<>();
		Queue<int[]> queue=new LinkedList<int[]>();
		
		int answer=-1;
		visited[n]=true;
		queue.add(new int[] {n,0});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			
			if(now[0]==k) { //도착
				answer=now[1];

				//경로의 길이와 경로를 출력한다.
				sb.append(answer+"\n");
				int z=now[0];
				while(z!=n) {
					stack.add(z);
					z=dp[z];
				}
				stack.add(z);
				while(!stack.isEmpty()) sb.append(stack.pop()+" ");
				
				System.out.println(sb);
				break;
			}
			
			//세 가지 이동에 대해 탐색
			if(now[0]-1>=0&&visited[now[0]-1]==false) {
				queue.add(new int[] {now[0]-1,now[1]+1});
				visited[now[0]-1]=true;
				dp[now[0]-1]=now[0];
			}
			if(now[0]+1<=100000&&visited[now[0]+1]==false) {
				queue.add(new int[] {now[0]+1,now[1]+1});
				visited[now[0]+1]=true;
				dp[now[0]+1]=now[0];
			}
			if(now[0]*2<=100000&&visited[now[0]*2]==false) {
				queue.add(new int[] {now[0]*2,now[1]+1});
				visited[now[0]*2]=true;
				dp[now[0]*2]=now[0];
			}
		}
		return answer;
	}
```

