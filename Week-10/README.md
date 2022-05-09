# 10주차 문제 풀이

## 로또의 최고 순위와 최저 순위
![image](https://user-images.githubusercontent.com/57666289/167334380-96a25aa5-5b23-4dc8-9c5a-88e64e14e64a.png)

0, 1개 → 6 등

나머지 순위 → 7 - (맞은 개수)
</br>

- 만약 0 이 있으면, 최저 순위는 0을 제외하고 맞힌 개수, 최고 순위는 0이 맞았다 치고 맞힌 개수
- answer[0] : 최고 순위, answer[1] : 최저 순위
</br>

- lottos를 for문으로 돌면서, 만약 0이면 answer[0] +=1
- 0이 아니면 해당 숫자가 win_nums에 포함되어 있는지 확인

```java
//포함여부 IntStream -> anyMatch로 확인
//anyMatch에서 일치하는지 확인할 숫자를 final 로 선언해야 한다.
final int a= lottos[i];
if (IntStream.of(win_nums).anyMatch(x -> x == a)){
       answer[1]++;}
```

- win_nums에 해당 숫자가 포함되어 있으면 answer[1]+=1
- for문을 다 돌고 난 뒤 answer[0]+=answer[1]  .  answer[0]에 0을 제외하고 맞힌 숫자를 더해준다.
- 점수에서 순위 구하는 로직 ( 7- 맞은개수) 을 통해 순위 반환

<br/>

## 카카오프렌즈 컬러링북

영역의 넓이 구하기 → dfs, bfs를 통해 푸는 문제

bfs로 해결

- 방문했는지 체크하기 위한 boolean[][] check 배열 필요
- 이중 for문으로 picture[i][j]를 보면서, 값이 0보다 크고 check[i][j]==false면 bfs 호출.
- 현재 위치(x,y) 를 queue에 넣음.
- queue에서 좌표를 poll하고, 해당 위치에서 상하좌우로 보면서, check가 false이고 picture값이 동일하면 queue에 해당 위치를 넣어주고, check=true로 체크함.
- 해당 영역의 넓이를 체크할 ans 변수에 +1 해줌.
- queue에 값이 들어있을 때 까지 반복.

```java
public int bfs(int[][] picture,int m,int n, int x,int y){
        int[] dir_x={-1,0,1,0};
        int[] dir_y={0,-1,0,1};
        int ans=1;
        Queue<int[]> q=new LinkedList<int[]>();
        
        q.add(new int[]{x,y});
        check[x][y]=true;
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            
            for(int i=0;i<4;i++){ //해당 위치에서 상하좌우로 탐색.
                int n_x=pos[0]+dir_x[i];
                int n_y=pos[1]+dir_y[i];
                
                if(n_x>=0&&n_x<m&&n_y>=0&&n_y<n){
                    if(!check[n_x][n_y] && picture[n_x][n_y]==picture[x][y]){
			//check가 false고, picture 값이 pos에서 picture값과 동일하면 탐색
                        q.add(new int[]{n_x,n_y});
                        check[n_x][n_y]=true;
                        ans+=1;
                    }
                }
            }
        }
        return ans; //해당 영역의 넓이 ans 값 반환.
    }
```

- main 함수에서 이중 for문 돌면서 bfs 호출할 때, `numOfArea` (영역 개수) +1 해주고, bfs 반환값이 `maxSizeOfOneArea` (최대 영역 크기) 보다 크면 `maxSizeOfOneArea`에 반환값 넣어줌.


<br/>


## 단체사진 찍기

### Permutation (순열)

- 서로 다른 n개에서 r개를 뽑아서 정렬하는 경우의 수를 구할 때, 사용한다. (순서 상관 있음)
- visited를 사용해서, dfs와 비슷함

1. 재귀함수 permutation에서 원소들을 차례로 보면서 visited = false 인 원소를 출력값 out[depth]에 넣어준다.
2. 그다음 depth+1에 들어갈 수를 찾기 위해 또 permutation 함수를 재귀호출 해준다.
3. depth가 목표 길이인 r이 되면, 종료

순열 구하는 코드

```java
public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r){
        if(depth == r){ //r 길이만큼 조합했다면, 종료한다
            for(int num: out) System.out.print(num); //순열 출력
            System.out.println();
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){ //방문하지 않았다면
                visited[i] = true; 
                out[depth] = arr[i]; //조합값 out의 현재 위치에 원소를 넣어준다.
                permutation(arr, out, visited, depth+1, r); //재귀함수 호출. 그다음 위치로 넘어감
                visited[i] = false; 
            }
        }
    }
```

- 단체사진 찍기 문제는 depth == r 일 때, 조건 data를 만족하는지 확인을 함.
- 모든 조건을 일치하면 answer +=1를 해주고, answer를 출력해주었다.

번외

- 중복 순열 : 서로 다른 n개에서 중복이 가능하게 r개를 뽑아서 정렬하는 경우의 수
- 조합 : 서로 다른 n개에서 순서 없이 r개를 뽑는 경우의 수
- 중복 조합 : 서로 다른 n개에서 순서 없이, 중복이 가능하게 r개를 뽑는 경우의 수

참고 : [https://velog.io/@cgw0519/알고리즘-순열-중복순열-조합-중복조합-총정리](https://velog.io/@cgw0519/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%88%9C%EC%97%B4-%EC%A4%91%EB%B3%B5%EC%88%9C%EC%97%B4-%EC%A1%B0%ED%95%A9-%EC%A4%91%EB%B3%B5%EC%A1%B0%ED%95%A9-%EC%B4%9D%EC%A0%95%EB%A6%AC)
