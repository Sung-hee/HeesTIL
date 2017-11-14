package Level2;

public class Collatz {
	
	public int collatz(int num) {
		int answer = 0;
		int cnt = 0;
		
		while(cnt < 500){
			cnt ++;
			
			if(num % 2 == 0){
				num = num / 2;
			}
			else if(num % 2 == 1){
				num = num * 3 + 1;	
			}
			if(num == 1){
				answer = cnt;
				break;
			}
      answer = -1;
		}
		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		Collatz c = new Collatz();
		int ex = 6;
		System.out.println(c.collatz(ex));
	}
}
