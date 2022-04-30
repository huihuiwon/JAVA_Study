## 신고결과받기
처음에는 Hash를 이용해서 풀어야하나 고민했다</br>
신고 받는 사람과 신고한 사람을 Key로 두고, 신고받은 횟수를 value로 두면</br>
value는 무조건 1로 고정이 되고 딱히 Hash를 만드는 의미가 없다</br>
</br>
그렇다고 신고 받은 사람이나 한 사람을 Key, 그 반대를 Value로 두면</br>
중복이 되어서 제대로 값이 들어가지않는다</br>
=> 그래서 생각해낸게 이차원 배열로 만들어서 [신고한사람][신고된사람]=true로 만드는 것</br></br>


여기서 또다른 문제는 인덱스는 Int형이고, 사원의 이름은 String형!</br>
IndexOf를 찾아야하는데 String[] 에서 indexOf를 사용할 수 없다</br>
=> Arrays.asList(arr).indexOf() 를 사용</br>
`chk[Arrays.asList(id_list).indexOf(tmp[0])][Arrays.asList(id_list).indexOf(tmp[1])]=true;`</br></br>

for문을 돌려서 한 사원당 신고받은 횟수를 세고,</br>
그 횟수가 k 를 넘는다면 그 사원의 인덱스를 HashSet에 넣는다</br>
ArrayList가 아닌 HashSet에 넣는 이유는, 우선 cnt_tmp가 k를 넘는지 안 넘는지 검사하기 전에</br>
무조건 list에 값을 넣기 때문에 중복된 값이 들어갈 수 있기 때문</br></br>

그 후 cnt_tmp가 k보다 넘는다면,</br>
그 유저를 신고한 사원에게 메일이 발송된다</br>
따라서 for문을 돌려서 그 유저를 신고한 사원을 찾고, 받을 정지 메일, cnt를 +1 해준다</br></br></br></br>




## 문자열 압축
substring으로 풀이</br>
앞에서부터 k개씩 잘라가면서, 현재 보고 있는 substring과 직전 substring을 비교했을 때</br>
같다면 압축을 할 수 있는 것이니 tmp++, 아니면 len에 직전의 결과를 넣는다</br>
`if(s.substring(i, k+i).equals(s.substring(i-k, i)))`</br></br>

만약 aaabc 라고 했을 때 3abc 로 압축될 수 있는데,</br>
1. b와 a는 같지 않으므로, len에 k(1) 과 tmp의 길이(1) 를 넣어야한다</br>
2. b와 c도 같지 않은데, 이때는 tmp가 1이므로 1b 이고, 이때 1은 생략된다</br>
따라서 len+=k</br></br>

1의 경우에 처음 k+1 을 해줬었는데, 그러면</br>
aaaaaaaaaabc 같은 경우, 10abc 라 정답은 5지만 결과는 4가 나온다</br>
압축했을 때 그 숫자가 10이 넘을 수 있다는 것도 생각해줘야함</br></br>

Int 형의 숫자 길이를 구하기 위해서는 `(int)Math.log(num)+1` 로 구할 수 있다</br>
혹은 String으로 변환해서 length() 를 구해주는 방법도 있다</br></br>

또 만약 aaabc가 있고, k가 3이라면?</br>
기존 틀렸던 코드에서는 aaa까지만 보고 bc는 보지 않는다</br>
그래서 len이 3이 됨</br>
따라서 s.length%k 를 해줘서 보지 않고 넘어간 나머지의 길이도 넣어줘야한다




## 오픈채팅방
HashMap을 이용해서 풀이</br>
만약 Enter이나 Change의 경우 key에 아이디, value에 이름을 넣는다</br>
같은 키, 즉 같은 아이디라면 Change를 했을 때 value값이 바뀐다</br></br>

출력을 할 때는 Enter 혹은 Leave 일때만 나타내면 되니까,</br>
Enter일 때는 `hm.get(tmp[1])+"님이 들어왔습니다"`</br>
Leave일 때는 `hm.get(tmp[1])+"님이 나갔습니다"`</br>
를 하면 알아서 바뀐 닉네임으로 들어오고 나옴을 표시해줌</br></br>

마지막에 ArrayList를 String 배열로 바꾸는 방법은
`List.toArray(arr)`
