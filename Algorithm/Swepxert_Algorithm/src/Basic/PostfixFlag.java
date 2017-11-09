package Basic;

import java.util.Scanner;

public class PostfixFlag {
	static String[] node;
	static int[] leftNode;
	static int[] rightNode;
	static int flag;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			int N = sc.nextInt();
			sc.nextLine();
			
			node = new String[N + 1];
			leftNode = new int[N + 1];
			rightNode = new int[N + 1];

			for(int i = 1; i <= N; i++){
				String[] str = sc.nextLine().trim().split(" ");
				node[i] = str[1];
				
				if(str.length > 2){
					leftNode[i] = Integer.parseInt(str[2]);
				}
				if(str.length > 3){
					rightNode[i] = Integer.parseInt(str[3]);
				}
			}
			flag = 1;
			postFix(1);
			System.out.println("#" + t + " " + flag);
		}
	}

	private static void postFix(int i) {
		// TODO Auto-generated method stub
		if(leftNode[i] != 0){
			postFix(leftNode[i]);
		}
		if(rightNode[i] != 0){
			postFix(rightNode[i]);
		}
		if(leftNode[i] == 0 && rightNode[i] == 0){
			if("*".equals(node[i]) || "/".equals(node[i]) || "+".equals(node[i]) || "-".equals(node[i])){
				flag = 0;
			}
		}
	}

}
