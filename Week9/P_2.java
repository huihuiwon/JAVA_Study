class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        //문자열 압축 단위: 1-문자열 길이의 1/2
		for (int i=1; i<=s.length()/2; i++) {
			//압축된 문자열
			StringBuilder result = new StringBuilder();
			//압축된 횟수
			int cnt = 1;
			String cur = s.substring(0, i);
			for (int j=i; j<=s.length(); j+=i) {
				//문자열이 i개 단위로 나누어 떨어지면 마지막 비교할 문자열은 ""
				//나누어 떨어지지 않으면 마지막 문자열 위치까지
				String next;
				if (j+i>s.length()) {
					next = (j==s.length()) ? "" : s.substring(j);
				}
				else {
					next = s.substring(j, j+i);
				}
				//다음 문자열과 같으면 압축 횟수+1
				//다르면 결과에 압축된 횟수(>1)+비교한 문자열을 이어서 붙임
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
			//마지막 부분 문자열 추가
			result.append(cur);
			
			answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}