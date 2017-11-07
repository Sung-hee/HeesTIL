package Basic;

import java.util.Scanner;

//[S/W 문제해결 기본] 4일차 - 길찾기

public class Wayfind {
	
	static int end = 99;
	static int[] aMap;
	static int[] bMap;
	static int size = 100;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			sc.next();
			int length = sc.nextInt();
			
			aMap = new int[size];
			bMap = new int[size];
			visited = new boolean[size];
			
			for(int i = 0; i < length; i++){
				int N = sc.nextInt();
				int M = sc.nextInt();
				
				if(aMap[N] > 0){
					bMap[N] = M;
				}
				else
					aMap[N] = M;
			}
			visited[0] = true;
			result = 0;
			dfs(0);
			System.out.println("#" + t + " " + result);
		}
	}

	private static void dfs(int i) {
		// TODO Auto-generated method stub
		if(i == end){
			result = 1;
			return;
		}
		if(aMap[i] > 0 && !visited[aMap[i]]){
			visited[aMap[i]] = true;
			dfs(aMap[i]);
			visited[aMap[i]] = false;
		}
		if(bMap[i] > 0 && !visited[bMap[i]]){
			visited[bMap[i]] = true;
			dfs(bMap[i]);
			visited[bMap[i]] = false;
		}
	}	

}
