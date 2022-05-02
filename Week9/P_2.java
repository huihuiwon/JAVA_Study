class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        //���ڿ� ���� ����: 1-���ڿ� ������ 1/2
		for (int i=1; i<=s.length()/2; i++) {
			//����� ���ڿ�
			StringBuilder result = new StringBuilder();
			//����� Ƚ��
			int cnt = 1;
			String cur = s.substring(0, i);
			for (int j=i; j<=s.length(); j+=i) {
				//���ڿ��� i�� ������ ������ �������� ������ ���� ���ڿ��� ""
				//������ �������� ������ ������ ���ڿ� ��ġ����
				String next;
				if (j+i>s.length()) {
					next = (j==s.length()) ? "" : s.substring(j);
				}
				else {
					next = s.substring(j, j+i);
				}
				//���� ���ڿ��� ������ ���� Ƚ��+1
				//�ٸ��� ����� ����� Ƚ��(>1)+���� ���ڿ��� �̾ ����
				if (next.equals(cur)){
					cnt++;
				}
				else {
					if (cnt > 1) {
						result.append(String.valueOf(cnt));
						cnt = 1;
					}
					result.append(cur);
					cur = next;
				}
				
			}
			//������ �κ� ���ڿ� �߰�
			result.append(cur);
			
			answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}