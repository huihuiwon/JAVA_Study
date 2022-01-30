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

![image](https://user-images.githubusercontent.com/57666289/151687989-9c4d05c3-f67c-4157-a14f-235c24bf0816.png)
![image](https://user-images.githubusercontent.com/57666289/151687995-320089a2-3931-43a5-a11b-5e010bb2b1bb.png)
![image](https://user-images.githubusercontent.com/57666289/151687999-a25fd3fe-07c8-4b33-8c57-b297f7debbdf.png)

<br/>

### 3. 영화감독 숌

![image](https://user-images.githubusercontent.com/57666289/151688291-60e48fd6-4fc2-4b4b-aed5-737ced8a661b.png)

- 반복문 돌아야 하는 수가 작고, 반복문 안의 코드가 간결하고 시간제한이 넉넉하면 그냥 브루트 포스로 풀자
- 괜히 규칙을 찾으려고 하는게 코드도 더 길어지고 시간도 더 오래 걸릴 수 있다

(브루트포스 문제인지 어떻게 알아차릴 수 있을까...??)
