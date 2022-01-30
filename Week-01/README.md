# 1주차 문제 풀이

## 재귀

### 1. 하노이 탑 

![image](https://user-images.githubusercontent.com/57666289/151686840-744cbf73-f9c7-475b-a48e-fcab86882e0c.png)

n 개를 1 -> 3으로 옮기기 위해선 n-1 개를 먼저 1->2 로 옮긴 다음, 제일 큰 n을 1 -> 3으로 옮기고, n-1 개를 2->3 으로 옮겨야 한다.

![image](https://user-images.githubusercontent.com/57666289/151686878-06c494d8-a8c0-4349-b4a3-a4abfa725475.png)


### StringBuilder 
- 문자열을 버퍼에 담아놨다가 한 번에 출력할 수 있음
- 하노이 탑에서 몇 번 옮겨야 하는지는 재귀를 실행한 후에 알 수 있었는데, StringBuilder를 통해 재귀함수의 출력값을 담아놓고, 몇 번 옮기는지 개수를 출력한 후 StringBuilder 의 내용을 출력하는 방식으로 사용하였다.

```java
public static StringBuilder res = new StringBuilder();

res.append(1+"\n");
res.append(2+"\n");
res.append(3+"\n");

System.out.println(res);
```
<br/>

## 브루트 포스
- 완전 탐색. 가능한 경우를 모두 탐색

<br/>

### 2.체스판 다시 칠하기 
