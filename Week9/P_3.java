import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
    	//���� ���̵�-�г���
        HashMap<String, String> uidName = new HashMap<>();
        //����,���� ���(���̵�-����,���� �޽����� ����)
        ArrayList<String[]> uidMsg= new ArrayList<>();
        
        //����,���� �� �ʿ� ���̵��� �г��� ����
        //����,���� �� ����Ʈ�� ���� ���̵�� ������ �޽��� �߰�
        for (String s : record) {
        	String[] rmsg = s.split(" ");
        	switch (rmsg[0]) {
        	case "Enter":
        		uidName.put(rmsg[1], rmsg[2]);
        		uidMsg.add(new String[] {rmsg[1], "���� ���Խ��ϴ�."});
        		break;
        	case "Leave":
        		uidMsg.add(new String[] {rmsg[1], "���� �������ϴ�."});
        		break;
        	case "Change": 
        		uidName.put(rmsg[1], rmsg[2]);
        		break;
        	}
        }
        
        //�޽������� ���� ���̵� �г������� ����
        String[] answer = new String[uidMsg.size()];
        for (int i=0; i<uidMsg.size(); i++) {
        	String[] s = uidMsg.get(i);
        	answer[i] = uidName.get(s[0])+s[1];
        }
        
        return answer;
    }
}