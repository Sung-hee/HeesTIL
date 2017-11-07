package Basic;

import java.util.Scanner;

//[S/W 문제해결 기본] 2일차 - Sum
public class Sum {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int testCase = 10;
        int[][] map = new int[100][100];
         
        for(int t = 1; t <= testCase; t++){
            int result = 0;
            sc.nextInt();
             
            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map[0].length; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i = 0; i <map.length; i++){
                int col = 0;
                for(int j = 0; j < map[0].length; j++){
                    col += map[i][j];
                }
                result = Math.max(col, result);
            }
            for(int j = 0; j <map.length; j++){
                int row = 0;
                for(int i = 0; i < map[0].length; i++){
                    row += map[i][j];
                }
                result = Math.max(row, result);
            }
            int dxLine = 0;
            int dyLine = 0;
             
            for(int i = 0; i < map.length; i++){
                dxLine += map[i][i];
                dyLine += map[i][map.length - i - 1];
            }
            result = Math.max(dxLine, result);
            result = Math.max(dyLine, result);
             
            System.out.println("#" + t + " " + result);
        }
    }
 
}
