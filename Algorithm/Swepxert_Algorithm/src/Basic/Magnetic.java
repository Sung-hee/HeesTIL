package Basic;

// [S/W 문제해결 기본] 5일차 - Magnetic

import java.util.Scanner;

public class Magnetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					map[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			
			for(int i = 0; i < N; i++){
				boolean flag = false;
				
				for(int j = 0; j < N; j++){
					if(map[j][i] == 1){
						flag = true;
					}
					else if(map[j][i] == 2){
						if(flag){
							flag = false;
							cnt++;
						}
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
