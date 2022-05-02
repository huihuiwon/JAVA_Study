import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
    	//유저 아이디-닉네임
        HashMap<String, String> uidName = new HashMap<>();
        //입장,퇴장 기록(아이디-입장,퇴장 메시지로 저장)
        ArrayList<String[]> uidMsg= new ArrayList<>();
        
        //입장,변경 시 맵에 아이디의 닉네임 저장
        //입장,퇴장 시 리스트에 유저 아이디와 입퇴장 메시지 추가
        for (String s : record) {
        	String[] rmsg = s.split(" ");
        	switch (rmsg[0]) {
        	case "Enter":
        		uidName.put(rmsg[1], rmsg[2]);
        		uidMsg.add(new String[] {rmsg[1], "님이 들어왔습니다."});
        		break;
        	case "Leave":
        		uidMsg.add(new String[] {rmsg[1], "님이 나갔습니다."});
        		break;
        	case "Change": 
        		uidName.put(rmsg[1], rmsg[2]);
        		break;
        	}
        }
        
        //메시지에서 유저 아이디를 닉네임으로 변경
        String[] answer = new String[uidMsg.size()];
        for (int i=0; i<uidMsg.size(); i++) {
        	String[] s = uidMsg.get(i);
        	answer[i] = uidName.get(s[0])+s[1];
        }
        
        return answer;
    }
}