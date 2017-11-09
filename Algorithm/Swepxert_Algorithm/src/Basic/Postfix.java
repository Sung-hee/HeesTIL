package Basic;

import java.util.Scanner;

public class Postfix {
	static int result = 0;
	static int[] leftNode;
	static int[] rightNode;
	static String[] node;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			int N = sc.nextInt();
			sc.nextLine();
			node = new String[N+1];
			leftNode = new int[N+1];
			rightNode = new int[N+1];
			
			for(int i = 1; i <= N; i++){
				String[] str = sc.nextLine().trim().split(" ");				
                node[i] = str[1];
				
				if(str.length > 2){
					leftNode[i] = Integer.parseInt(str[2]);
					rightNode[i] = Integer.parseInt(str[3]);
				}
			}
			result = 0;
			postfix(1);
			System.out.println("#" + t + " " + result);
		}
	}

	private static int postfix(int i) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = 0;
		
		if(leftNode[i] != 0){
			left = postfix(leftNode[i]);
		}
		if(rightNode[i] != 0){
			right = postfix(rightNode[i]);
		}
		
		if("*".equals(node[i])){
			result = left * right;
			return result;
		}
		else if("+".equals(node[i])){
			result = left + right;
			return result;
		}
		else if("/".equals(node[i])){
			result = left / right;
			return result;
		}
		else if("-".equals(node[i])){
			result = left - right;
			return result;
		}
		else {
			return Integer.parseInt(node[i]);
		}
	}
}
