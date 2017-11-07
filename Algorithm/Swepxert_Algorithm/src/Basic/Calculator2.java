package Basic;

import java.util.Scanner;
import java.util.Stack;

//[S/W 문제해결 기본] 6일차 - 계산기2 

public class Calculator2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			int N = sc.nextInt();
			String str = sc.next();
			
			Stack<Integer> number = new Stack<Integer>();
			Stack<Character> symbol = new Stack<Character>();
			
			for(int i = 0; i < N; i++){
				if(str.charAt(i) == '*'){
					symbol.push(str.charAt(i));
				}
				else if(str.charAt(i) == '+'){
					symbol.push(str.charAt(i));
				}
				else {
					number.push(str.charAt(i) - '0');
					
					if(!symbol.isEmpty() && symbol.peek() == '*'){
						symbol.pop();
						number.push(number.pop() * number.pop());
					}
				}
			}
			while(!symbol.isEmpty()){
				symbol.pop();
				number.push(number.pop() + number.pop());
			}
			System.out.println("#" + t + " " + number.pop());
		}
	}
}