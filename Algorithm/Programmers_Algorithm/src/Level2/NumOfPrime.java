package Level2;

//소수 찾기 Level 2 
public class NumOfPrime {
	int numberOfPrime(int n) {
		int result = 0;
		boolean flag;
		
		for(int i=2;i<=n;i++){
			flag = true;
			
			for(int j=2;j<i;j++){
				if(i % j == 0){
					flag = false;
				}
			}
			if(flag == true){
				result++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		NumOfPrime prime = new NumOfPrime();
		System.out.println( prime.numberOfPrime(10) );
	}

}
