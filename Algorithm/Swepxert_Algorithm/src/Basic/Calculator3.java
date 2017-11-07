package Basic;

//[S/W 문제해결 기본] 6일차 - 계산기3

import java.util.Scanner;
import java.util.Stack;

public class Calculator3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			int N = sc.nextInt();
			String str = sc.next();
			String postFix = "";
			
			Stack<Character> ct = new Stack<>();
			Stack<String> st = new Stack<>();
			
			for(int i = 0; i < N; i++){
				if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
					postFix += str.charAt(i);
				}
				else if(str.charAt(i) == '('){
					ct.add(str.charAt(i));
				}
				else if(str.charAt(i) == ')'){
					while(!(ct.peek() == '(')){
						postFix += ct.pop();
					}
					ct.pop();
				} 
				else if(str.charAt(i) == '+'){
					while(!(ct.peek() == '(')){
						postFix += ct.pop();
					}
					ct.add(str.charAt(i));
				}
				else {
					ct.add(str.charAt(i));
				}
			}
			while(!ct.isEmpty()){
				postFix += ct.pop();
			}
			for(int i = 0; i < postFix.length(); i++){
				if(postFix.charAt(i) >= '0' && postFix.charAt(i) <= '9'){
					st.add(postFix.substring(i, i + 1));
				}
				else if (postFix.charAt(i) == '+') {
                    int z = Integer.parseInt(st.pop());
                    int y = Integer.parseInt(st.pop());
                    int x = z + y;
                    st.add(String.valueOf(x));
                } else {
                    int z = Integer.parseInt(st.pop());
                    int y = Integer.parseInt(st.pop());
                    int x = z * y;
                    st.add(String.valueOf(x));
                }
            }
            int sum = Integer.parseInt(st.pop());
            System.out.println("#" + t + " " + sum);
		}
	}
}

