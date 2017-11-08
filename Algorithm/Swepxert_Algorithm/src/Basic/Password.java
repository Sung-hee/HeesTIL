package Basic;

import java.util.LinkedList;
import java.util.Scanner;

//[S/W 문제해결 기본] 7일차 - 암호생성기
public class Password {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			int N = sc.nextInt();
			String pwd = sc.next();
			LinkedList<Character> list = new LinkedList<>();
			
			for(int i = 0; i < N; i++){
				list.add(pwd.charAt(i));
			}
			
			for(int i = 0; i < list.size()-1; i++){
				if(list.get(i) == list.get(i + 1)){
					for(int j = 0; j < 2; j++){
						list.remove(i);
					}
					i = -1;
				}
			}
			System.out.print("#" + t + " ");
			
			for(int i = 0; i < list.size(); i++){
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}

}
