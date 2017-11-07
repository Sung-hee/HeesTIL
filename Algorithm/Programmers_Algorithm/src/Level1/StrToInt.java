package Level1;

//스트링을 숫자로 바꾸기 Level 1
public class StrToInt {
    public int getStrToInt(String str) {
			int num ;
			num = Integer.parseInt(str);
		
			return num;
    }
    //아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String args[]) {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.getStrToInt("-1234"));
    }
}
