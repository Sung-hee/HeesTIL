package Level1;

// 나누어 떨어지는 숫자 배열 Level 1
import java.util.Arrays;

public class Divisible {
	public int[] divisible(int[] array, int divisor) {
		int cnt = 0;
		int n = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] % divisor == 0){
				cnt++;
			}
		}
		int[] ret = new int[cnt];
		
		for(int i = 0; i < array.length; i++){
			if(array[i] % divisor == 0){
				ret[n] = array[i];
				n++;
			}
		}
		
		
		
		return ret;
	}
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		Divisible div = new Divisible();
		int[] array = {5, 9, 7, 10};
		System.out.println( Arrays.toString( div.divisible(array, 5) ));
	}
}
