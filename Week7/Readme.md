## 가운데를 말해요

PriorityQueue를 두 개 둬서 하나는 작은 순으로 정렬, 하나는 큰 순으로 졍렬하게 함</br>
기본적으로 PriorityQueue는 숫자가 작은 것이 우선순위가 높다</br>
숫자가 큰 것부터 정렬하려면 PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); 로 표현</br></br>

작은 것부터 정렬하는 것을 minus, 큰 것부터 정렬하는 것을 plus라고 치면</br>
plus.size()와 minus.size()를 비교했을 때 plus가 같거나 크면 minus에 add(num)</br>
-> minus.peek()을 가운데로 하고 싶기 때문</br></br>

반대로 minus가 작으면 plus.add(num)</br>
-> 균형을 맞추기 위해</br></br>

다만, 이때 만약 plus.peek()와 minus.peek()을 비교했을 때</br>
plus.peek()이 minus.peek()보다 작다면 앞서 세운 가정이 무너짐</br>
![image](https://user-images.githubusercontent.com/50469773/158059429-06e74882-26b5-446d-99f5-cfb97e369b40.png)
</br>
따라서 plus.peek()와 minus.peek()을 바꿔줘야함
</br></br></br>
</br></br></br>



## 내리막길

(1,1)부터 (N,M)까지 가는 데 항상 내리막길로만 이동하는 경로의 개수를 구하는 문제</br>
최단 경로를 구하는 것이 아니고 경로의 개수를 구하는 문제이기 때문에 BFS가 아닌 DFS로 풀어야함</br></br>

dp[nx][ny]는 nx, ny까지 오는데 가능한 이동 경로의 개수</br>
for(dir=0; dir<4; dir++)를 이용해서</br>
상하좌우를 돌아가면서 만약 s,e 보다 nx,ny가 더 작다면 s, e -> nx, ny로 이동 가능하다는 것이니</br>
if(map[nx][ny]<map[s][e])</br>
dp[s][e] += DFS(nx, ny, map);</br>
로 가능한 경로를 더해준다</br></br>


이때 방문했다는 표시를 남기기 위해 dp[s][e]=0 으로 설정해주고, 만약 방문했다면 함수를 다시 실행하지 않고 dp[s][e]를 return</br>
![image](https://user-images.githubusercontent.com/50469773/158059560-015c96b2-2d11-4fe6-81b2-282b5be89218.png)
</br></br></br>

***
처음에 BFS로 풀려고 했더니 잘못된 결과가 나옴</br>
단순 DFS로만 풀면 메모리 초과 발생 -> DP 이용해야함</br></br>

블로그를 참고</br>
</br></br></br>
</br></br>
## 동전1
DP 로 푸는 문제</br>
동전의 가치가 1, 2, 5이고 k가 10이면</br>
dp[10]은 dp[9]에서 1을 더한 것, 8에서 2를 더한 것, 5에서 5를 더한 것으로 구할 수 있다</br></br>

하지만 그 안에 중복된 것이 많기 때문에 단순히 dp[10]=dp[9]+dp[8]+dp[5]를 하면 안됨</br>
![image](https://user-images.githubusercontent.com/50469773/158060049-02dc17df-c2b8-4e5e-9db6-33010f0c2b9f.png)
</br>
for문 순서를 바꿔서 처음에 잘못된 결과 나옴
