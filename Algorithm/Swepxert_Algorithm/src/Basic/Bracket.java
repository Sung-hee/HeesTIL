package Basic;

import java.util.Scanner;
import java.util.Stack;

//[S/W ¹®Á¦ÇØ°á ±âº»] 4ÀÏÂ÷ - °ýÈ£ Â¦Áþ±â

public class Bracket {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			int N = sc.nextInt();
			String str = sc.next();
			Stack<Character> stack= new Stack<Character>();
			int result = 1;
			
			for(int i = 0; i < N; i++){
				char ch = str.charAt(i);
				
				if(ch == '[' || ch == '<' || ch == '{' || ch == '('){
					stack.add(ch);
				}
				else {
					if(stack.isEmpty()){
						result = 0;
						break;
					}
					else if(stack.lastElement() == '['){
						if(ch == ']'){
							stack.pop();
						}
						else {
							result = 0;
							break;
						}
					}
					else if(stack.lastElement() == '<'){
						if(ch == '>'){
							stack.pop();
						}
						else {
							result = 0;
							break;
						}
					}
					else if(stack.lastElement() == '('){
						if(ch == ')'){
							stack.pop();
						}
						else {
							result = 0;
							break;
						}
					}
					else if(stack.lastElement() == '{'){
						if(ch == '}'){
							stack.pop();
						}
						else {
							result = 0;
							break;
						}
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}

