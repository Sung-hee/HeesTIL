package Level2;

import java.util.Arrays;

//최솟값 만들기 Level 2
public class GetMinSum {

	public int getMinSum(int[] A, int[] B) {
		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < A.length; i++) {
			answer += A[i] * B[A.length - i - 1];
		}
		return answer;
	}

	public static void main(String[] args) {
		GetMinSum test = new GetMinSum();
		int[] A = { 1, 2 };
		int[] B = { 3, 4 };
		System.out.println(test.getMinSum(A, B));
	}
}