package Basic;

import java.util.Scanner;

//[S/W 문제해결 기본] 2일차 - Ladder2
public class Ladder2 {
	
	static int N = 100;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1};
	static int[] dy = {-1, 1, 0};
	static int result;
	static int cnt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t = 1; t <= testCase; t++){
			sc.nextInt();
			map = new int[N][N];
			
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					map[i][j] = sc.nextInt();
				}
			}
			int index = 0;
			int nMin = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++){
				visited = new boolean[N][N];
				
				if(map[0][i] == 1){
					cnt = 0;
					visited[0][i] = true;
					dfs(0, i, 1);
					
					if(nMin > cnt){
						nMin = cnt;
						index = i;
					}
					else if (nMin == cnt && index < i){
						index = i;
					}
				}
			}
			System.out.println("#" + t + " " + index);
		}
	}

	private static void dfs(int x, int y, int depth) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 3; i++){
			int px = x + dx[i];
			int py = y + dy[i];
			
			if(px < 0 || px >= N || py < 0 || py >= N){
				continue;
			}
			
			if(map[px][py] == 1 && px == 99){
				cnt = depth;
				break;
			}
			
			if(map[px][py] == 1 && visited[px][py] == false){
				visited[px][py] = true;
				dfs(px, py, depth+1);
				break;
			}
		}
	}
}

