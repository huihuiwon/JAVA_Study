package kakao.week9;

import java.util.HashMap;
import java.util.Map.Entry;

//오픈채팅방

public class N_3 {
	public String[] solution(String[] record) {
        String[] answer = {};
        //userid hashmap 을 만들면 되지 않을까
        HashMap<String, String> nickname = new HashMap<>();
        int n=0;
        
        for(String s:record){
            String[] v=s.split(" ");
            if(v[0].equals("Enter")||v[0].equals("Leave"))n++;
            
            if(v[0].equals("Enter")||v[0].equals("Change"))nickname.put(v[1],v[2]);
        }
        answer = new String[n];
        
        int cnt=0;
        for(String s:record){
            String[] v=s.split(" ");
            if(v[0].equals("Enter")){
                answer[cnt]=nickname.get(v[1])+"님이 들어왔습니다.";
                cnt++;
            }
            else if(v[0].equals("Leave")){
                answer[cnt]=nickname.get(v[1])+"님이 나갔습니다.";
                cnt++;
            }
        }

        
        return answer;
    }
}
