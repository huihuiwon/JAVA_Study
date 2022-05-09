## 10주차 문제 풀이

### 로또의 최고 순위와 최저 순위
![image](https://user-images.githubusercontent.com/57666289/167334380-96a25aa5-5b23-4dc8-9c5a-88e64e14e64a.png)


0, 1개 → 6 등

나머지 순위 → 7 - (맞은 개수)

- 만약 0 이 있으면, 최저 순위는 0을 제외하고 맞힌 개수, 최고 순위는 0이 맞았다 치고 맞힌 개수
- answer[0] : 최고 순위, answer[1] : 최저 순위

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
