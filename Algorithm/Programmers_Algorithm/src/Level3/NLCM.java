package Level3;

public class NLCM {

	public long gcd(long n, long m){
		long temp = n;
		
		if(n < m){
			n = m;
			m = temp;
		}
		if(n % m == 0)
			return m;
		else
			return gcd(m, n%m);
	}
	
	public long gcd_n(int[] num){
		long gcdN = 0;
		
		gcdN = gcd(num[0], num[1]);
		
		if(num != null && num.length>=2){
			for(int i = 2; i < num.length; i++){
				gcdN = gcd(gcdN, num[i]);
			}
		}
		return gcdN;
	}
	
	public long lcm(long n, long m){
		long temp = gcd(n, m);
		
		if(temp == 0){
			return 0;
		}
		else
			return (n / temp * m);
	}
	
	public long nlcm(int[] num) {
		long answer = 0;
		
		answer = lcm(num[0], num[1]);
		if(num != null && num.length >= 2){
			for(int i = 2; i < num.length; i++){
				answer = lcm(answer, num[i]);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		NLCM c = new NLCM();
		int[] ex = { 2, 6, 8, 14 };
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(c.nlcm(ex));
	}
}