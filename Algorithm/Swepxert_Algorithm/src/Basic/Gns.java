package Basic;

//[S/W 문제해결 기본] 5일차 - GNS 
import java.util.Scanner;

public class Gns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int t = 1; t <= testCase; t++){
			String N = sc.next();
			int M = sc.nextInt();
			
			String[] value = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
			String[] str = new String[M];
			int[] num = new int[value.length]; 
					
			for(int i = 0; i < M; i++){
				str[i] = sc.next();
				
				for(int j = 0; j < value.length; j++){
					if(str[i].equals(value[j])){
						num[j]++;
						break;
					}
				}
			}
			System.out.println(N);
			for(int i = 0; i < num.length; i++){
				for(int j = 0; j < num[i]; j++){
					System.out.print(value[i] + " ");
				}
			}
		}
	}
}
