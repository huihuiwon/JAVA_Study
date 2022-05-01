package kakao.week9;

//문자열 압축

public class N_2 {
    public int solution(String s) {
        //앞에서부터 잘라야한다!
        int chk=1;
        
        int answer = s.length();
        
        for(int i=1;i<=s.length()/2;i++){
            
            int d=checking(s,i);
            if(d<answer)answer=d;
        }
        
        
        return answer;
    }
    public int checking(String s,int l){
        int chk=0;
        
        while(chk<s.length()-l){
            String a=s.substring(chk,chk+l);
            
            int rep=0;
            
            for(int i=1;i<s.length();i++){
                String z=a.repeat(i);
                if(chk+i*l<=s.length() && s.substring(chk,chk+i*l).equals(z)){
                    rep=i;
                }
                else break;
            }
            
            if(rep>1){
                String ch = rep+a;
                s=s.substring(0,chk)+ch+s.substring(chk+rep*l,s.length());
                chk+=ch.length();
            }
            else chk+=l;
            
        }
        return s.length();
        
    }
}
