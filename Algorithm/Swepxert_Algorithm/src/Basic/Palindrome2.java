package Basic;

import java.util.Scanner;

//[S/W 문제해결 기본] 3일차 - 회문2
public class Palindrome2 {
	
	static int size = 100;
	static char[][] palin;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			palin = new char[size][size];
			int cnt = 0;
			int N = sc.nextInt();
			int result = 0;
			
			for(int i = 0; i < size; i++){
				char[] str = sc.next().toCharArray();
				
				for(int j = 0; j < size; j++){
					palin[i][j] = str[j];
				}
			}
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					for(int k = j; k < size; k++){
						if(isPalindrome(i, j, k, true)){
							result = Math.max(result, k - j);
						}
						if(isPalindrome(i, j, k, false)){
							result = Math.max(result, k - j);
						}
					}
				}
			}
			System.out.println("#" + t + " " + (result + 1));
		}
	}

	public static boolean isPalindrome(int state, int start, int end, boolean isPalindrome) {
		// TODO Auto-generated method stub
		if(start >= end){
			return true;
		}
		if(isPalindrome){
			if(palin[state][start] == palin[state][end]){
				if(isPalindrome(state, start + 1, end - 1, isPalindrome)){
					return true;
				}
			}
		}
		else{
			if(palin[start][state] == palin[end][state]){
				if(isPalindrome(state, start + 1, end - 1, isPalindrome)){
					return true;
				}
			}
		}
		return false;
	}
}
