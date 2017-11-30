package Level3;

public class JumpCase {

	public int jumpCase(int num) {
		int answer = 0;
		int fnum = 1, fnum1 = 1;

		for (int i = 1; i < num; i++) {
			answer = fnum + fnum1;
			fnum = fnum1;
			fnum1 = answer;
		}
		return answer;
	}

	public static void main(String[] args) {
		JumpCase c = new JumpCase();
		int testCase = 4;
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(c.jumpCase(testCase));
	}
}
