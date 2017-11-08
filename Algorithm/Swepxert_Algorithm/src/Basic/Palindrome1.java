package Basic;

import java.util.Scanner;

//[S/W 문제해결 기본] 3일차 - 회문1
public class Palindrome1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		int length = 8;
		
		for(int t = 1; t <= testCase; t++){
			char[][] palin = new char[length][length];
			int cnt = 0;
			int N = sc.nextInt();

			for(int i = 0; i < length; i++){
				char[] str = sc.next().toCharArray();
				
				for(int j = 0; j < length; j++){
					palin[i][j] = str[j];
				}				
			}
			
			for(int i = 0; i < length; i++){
				for(int j = 0; j < length; j++){
					int index = 1;
					boolean isPalindrome = true;
					
					if(!(j+N > length)){
						for(int k = j; k < j + (N / 2); k++){
							if(palin[i][k] != palin[i][j+N-index]){
								isPalindrome = false;
								break;
							}
							index++;
						}
						if(isPalindrome)
							cnt++;
					}
					index = 1;
					
					if(!(i+N > length)){
						isPalindrome = true;
						
						for(int k = i; k < i + (N / 2); k++){
							if(palin[k][j] != palin[i+N-index][j]){
								isPalindrome = false;
								break;
							}
							index++;
						}
						if(isPalindrome)
							cnt++;
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
