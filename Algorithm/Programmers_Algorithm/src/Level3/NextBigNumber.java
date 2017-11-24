package Level3;

public class NextBigNumber {
	
	public int nextBigNumber(int n) {
		int answer = 0;
		String strNum = Integer.toBinaryString(n);
		int cnt = 0;
		
		for (int i = 0; i < strNum.length(); i++) {
			if (strNum.charAt(i) == '1') {
				cnt++;
			}
		}
		String nextNum = "";
		int nextCnt = 0;
		
		for (int i =n+1;i<1000000;i++){
			nextNum = Integer.toBinaryString(i);
			
			for(int j = 0; j <nextNum.length();j++){
				if(nextNum.charAt(j) == '1'){
					nextCnt++;
				}
			}
			if(nextCnt == cnt){
				answer = Integer.parseInt(nextNum, 2);
				break;
			}
			else
				nextCnt = 0;
			
		}
		
		return answer;
	}

	public static void main(String[] args) {
		NextBigNumber test = new NextBigNumber();
		int n = 78;
		System.out.println(test.nextBigNumber(n));
	}
}
