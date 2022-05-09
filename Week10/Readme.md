### 로또의 최고순위와 최저순위
win_nums 나 lottos 나 중복된 숫자는 없으므로,</br>
HashSet을 이용해서 구현</br></br>

우선 HashSet에 win_num를 넣고</br>
lottos를 하나씩 보면서 일단 0인 것들의 개수를 센다</br>
이 수를 zcnt라 한다</br>
그러면서 만약 hs.contains(i) 를 했을 때 그 수가 있다면,</br>
해당 숫자를 맞췄다는 뜻이므로 그 개수도 센다</br>
이 수를 wcnt라 한다</br></br>

``` java
int zcnt=0; int wcnt=0;
for(int i : lottos) {
    if(i==0) zcnt++;
    if(hs.contains(i))
        wcnt++;</br>
}
```
</br></br>
여기서 zcnt가 0이라면, 알아볼 수 없는 숫자가 없다는 뜻이므로</br>
최저순위 = 최고 순위</br></br>

아니라면, 최저 순위는 알아볼 수 없는 숫자를 모두 틀린 것이고</br>
최고 순위는 알아볼 수 없는 숫자를 모두 맞춘 것</br></br>


```java
public int score(int wcnt){
    if(wcnt==6) return 1;
    else if(wcnt==5) return 2;
    else if(wcnt==4) return 3;
    else if(wcnt==3) return 4;
    else if(wcnt==2) return 5;
    else return 6;
}
```
</br></br>
구현해둔 score 함수를 통해 순위를 구한다</br></br></br>



### 카카오프렌즈 컬러링북
BFS를 이용해서 구현하는 문제</br>
단, 여기서 시작점을 알 수 없으니 이중 for문을 이용해서 가능한 시작점을 모두 넣어준다</br></br>

```java
boolean dist[][]=new boolean[m][n];
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
for(int i=0; i<m; i++){
    for(int j=0; j<n; j++){
       if(dist[i][j] || picture[i][j]==0) continue;
        Queue<int[] > q = new LinkedList<>();
        q.add(new int[] {i, j});
        dist[i][j]=true;
        numberOfArea++;
        int max=0;
        while(!q.isEmpty()){
            int cur[]=q.poll();
            max++;
            for(int dir=0; dir<4; dir++){
                int nx=dx[dir]+cur[0];
                int ny=dy[dir]+cur[1];
                if(nx<0 || ny<0|| nx>=m || ny>=n) continue;
                if(dist[nx][ny] || picture[nx][ny]!=picture[cur[0]][cur[1]]) continue;
                if(picture[nx][ny]==0) continue;
                q.add(new int[] {nx, ny});
                dist[nx][ny]=true;
            }
        }
        maxSizeOfOneArea=Math.max(maxSizeOfOneArea, max);

    }
}
```

</br></br></br>
### 단체사진 찍기
DFS를 이용해서 풀이</br>
우선 8명이서 설 수 있는 모든 경우를 생각해주고, 그 중 조건을 만족하는 수를 세주는 식으로 구현</br></br>

DFS를 이용해서 순열을 만들어준다</br></br>

```java
  public void DFS(int L, int n, String[] data){
      if(L==8){
          String tmp="";
          for(int i=0; i<8; i++){
              tmp+=(arr[i]+"");
          }
          sat(tmp, data, n);
          return;
      }
      for(int i=0; i<8; i++){
          if(!chk[i]){
              chk[i]=true;
              arr[L]=kakao[i];
              DFS(L+1, n, data);
              chk[i]=false;
          }
      }
  }
]
```
</br></br>

순열을 만든 후에는 프렌즈의 인덱스를 구하고, 조건에서 원하는 간격을 구한 후 조건을 만족하는지 확인</br>
여기서 간격은 그 사이에 있는 프렌즈의 수이므로, 간격이 0이면 프렌즈 사이 수는 0명이지만</br>
인덱스는 1이 차이남</br>
따라서 간격+1 을 해줘서 인덱스로 계산하기 용이하게 미리 세팅</br></br>


```java
 public void sat(String str, String[] data, int n) {
    boolean flag=true;

    for(String d : data){
        int first=str.indexOf(d.charAt(0));
        int second=str.indexOf(d.charAt(2));
        int diff=d.charAt(4)-'0';
        diff+=1;
        if(d.charAt(3)=='<'){
            if(Math.abs(first-second)>=diff) {
                flag=false;
                break;
            }
        }
        else if(d.charAt(3)=='>'){
            if(Math.abs(first-second)<=diff) {
                flag=false;
                break;
            }
        }
        else if(d.charAt(3)=='='){
            if(Math.abs(first-second)!=diff) {
                flag=false;
                break;
            }
        }    
    }
    if(flag) {
        answer++;
    }
}
```
