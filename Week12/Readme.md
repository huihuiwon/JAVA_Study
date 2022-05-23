## 부분합
주의할 점은 그 합이 S가 되는 것이 아니라 S 이상이 되는 것!</br>

```java
for(int rt=0; rt<n; rt++) {
  sum+=a[rt];
  if(sum>=m) {
    result=Math.min(result, rt-lt+1);
  }
  while(sum>=m && lt<rt) {
    sum-=a[lt++];
    if(sum>=m) result=Math.min(result, rt-lt+1);
  }
}
```
for문을 이용해서 문제를 푸는데, rt-lt+1 을 하면 길이가 되니,</br>
`result=Math.min(result, rt-lt+1)` 을 이용해서 최솟값 갱신</br></br>

여기서 rt-lt가 아니고 rt-lt+1 을 해주는 이유는,</br>
만약 rt가 1이고 lt가 0이면 길이는 1이 아닌 2이기 때문</br></br>

while문을 이용해 sum>=m 일 동안 sum-=a[lt++]을 해주는데,</br>
이때 lt<rt 라는 조건도 달아줘야함</br>
아니면 lt++을 하면서 rt-lt+1을 해도 0이 돼서 합을 만들 수 있는데 그러면 result가 0이 되는 경우 발생</br></br></br>

## 가장 긴 증가하는 부분 수열
DP로 풀었더니 시간 초과 발생,,</br>
경로를 알기 위해서는 Stack을 이용해서 풀이</br></br>

가장 긴 증가하는 부분 수열을 찾기 위해서는</br>
이분 탐색 혹은 DP 로 푸는 방법이 있다</br>
두 가지 방법 모두 알아 놓기</br></br></br>

## 숨바꼭질 4
```java
if(nx==k) {
  record[k]=cur;
  StringBuilder sb = new StringBuilder();
  sb.append(dist[cur]+1+"\n");

  st.push(k);

  while(k!=n) {
    st.push(record[k]);
    k=record[k];	
    if(record[k]==-1) break;
  }

  while(!st.isEmpty())
    sb.append(st.pop()+" ");
  bw.write(sb+"\n");
    bw.flush();
  return;

}
```
최솟값을 찾기 위한 dist 배열 외에 record 배열을 만들어서 경로 저장</br></br>
record[nx]=cur을 이용해 현재(nx) 를 방문하기 직전 들렀던 곳 (cur) 을 기록</br>
만약 nx==m 이 되면 마찬가지로 record[nx]=cur 대입</br></br>



```java
while(k!=n) {
  st.push(record[k]);
  k=record[k];	
  if(record[k]==-1) break;
}

while(!st.isEmpty())
  sb.append(st.pop()+" ");
```

Stack을 이용한 이 부분을 이용해서 visited에 들어가있는 값들을 출력해준다</br>
주의할 점은 while(k!=n) 으로 조건을 달았지만 if(record[k]==1) break를 하지 않으면 메모리 초과 발생</br>
</br>

```java
if(n==k) {
  bw.write(0+"\n");
  bw.write(n+"\n");
  bw.flush();
  return;
}
```

또한 이 부분도 따로 추가해줘야함
