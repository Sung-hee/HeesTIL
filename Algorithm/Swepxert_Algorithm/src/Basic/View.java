package Basic;

import java.util.Scanner;

//[S/W 문제해결 기본] 1일차 - View
public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
        
		for(int t = 1; t <= testCase; t++){
			int N = sc.nextInt();
			int[] build = new int[N];
            int result = 0;
			
			for(int i = 0; i < N; i++){
				build[i] = sc.nextInt();
			}
			
			for(int i = 2; i < N-2; i++){
				if(build[i] > 0 && build[i-2] < build[i] && build[i-1] < build[i] 
						&& build[i+2] < build[i] && build[i+1] < build[i]){
					result += build[i] - Math.max(Math.max(build[i-2], build[i-1]), Math.max(build[i+2], build[i+1]));
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}