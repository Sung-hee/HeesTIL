package Level4;

public class Expressions {

	public int expressions(int num) {
		
		int answer = 0;
		int test = 0;
		
		for(int i = 1; i <=num; i++){
			
			for(int j = i; j<=num; j++){
				test += j;
				
				if(test == num){
					answer++;
				}
				else if(test > num){
					test = 0;
					break;
				}
			}
		}
		return answer;
	}

	public static void main(String args[]) {
		Expressions expressions = new Expressions();
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(expressions.expressions(15));
	}
}
