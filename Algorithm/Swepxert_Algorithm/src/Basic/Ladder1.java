package Basic;

import java.util.Scanner;

//[S/W 문제해결 기본] 2일차 - Ladder1
public class Ladder1 {
	
	static int N = 100;
	static int[][] map;
	static boolean[][] visited;
	static int nStart;
	static int mStart;
	static int nEnd;
	static int[] dx;
	static int[] dy;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			sc.nextInt();
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					map[i][j] = sc.nextInt();
				}
			}
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(map[i][j] == 2){
						nStart = i;
						mStart = j;
					}
				}
			}
			dfs(nStart, mStart);
			System.out.println("#" + t + " " + nEnd);
		}
	}

	public static boolean dfs(int x, int y) {
		// TODO Auto-generated method stub
		if(x < 0 || x >= N || y < 0 || y >= N || visited[x][y] || map[x][y] == 0){
			return false;
		}
		if(x == 0){
			nEnd = y;
			return true;
		}
		visited[x][y] = true;
		dx = new int[] {1, -1, 0, 0};
		dy = new int[] {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++){
			int nX = x + dy[i];
			int nY = y + dx[i];
			
			if(dfs(nX, nY)){
				return true;
			}
		}
		
		return false;
	}
}
