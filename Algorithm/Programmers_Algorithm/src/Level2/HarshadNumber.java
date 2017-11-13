package Level2;

public class HarshadNumber {
	public boolean isHarshad(int num) {
		int fnum = num;
		int result = 0;
		int nmg = 0;

		while (num >= 0) {
			nmg = num % 10;
			result += nmg;
			num = num / 10;
		}
		if (fnum % result == 0) {
			return true;
		} else
			return false;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		HarshadNumber sn = new HarshadNumber();
		System.out.println(sn.isHarshad(18));
	}
}
