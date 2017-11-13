package Level2;

import java.util.Arrays;

public class ReverseInt {
	public int reverseInt(int n){
		String str = Integer.toString(n);
		
		char[] arr = str.toCharArray();
		
		Arrays.sort(arr);
		
		StringBuilder answer = new StringBuilder(new String(arr));
		return Integer.parseInt(answer.reverse().toString());
	}
  
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void  main(String[] args){
		ReverseInt ri = new ReverseInt();
		System.out.println(ri.reverseInt(118372));
	}
}