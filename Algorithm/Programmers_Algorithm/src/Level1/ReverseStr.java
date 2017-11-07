package Level1;

import java.util.Arrays;

//Level1. 문자열 내림차순으로 배치하기
public class ReverseStr {
	public String reverseStr(String str){
		char[] reverse = str.toCharArray();
		
		Arrays.sort(reverse);
		
		StringBuilder result = new StringBuilder(new String(reverse));
		return result.reverse().toString();
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		ReverseStr rs = new ReverseStr();
		System.out.println( rs.reverseStr("Zbcdefg") );
	}
}
