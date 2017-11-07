package Basic;

import java.util.Scanner;

public class Stringfind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			sc.nextInt();
			String findStr = sc.next();
			String str = sc.next();
			int cnt = 0;
			
			for(int i = 0; i <= str.length()-findStr.length(); i++){
				String find = str.substring(i, i+findStr.length());
				
				if(find.equals(findStr)){
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}

