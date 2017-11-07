package Basic;

import java.util.Arrays;
import java.util.Scanner;
 
public class Flatten {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int testCase = 10;
         
        for(int t = 1; t <= testCase; t++){
            int[] box = new int[100];
            int dump = sc.nextInt();
             
            for(int i = 0; i < box.length; i++){
                box[i] = sc.nextInt();
            }
             
            int result = 0;
             
            for(int i = 0; i < dump; i++){
                Arrays.sort(box);
                box[0] += 1;
                box[box.length-1] -= 1;
            }
            Arrays.sort(box);
            result = box[box.length-1] - box[0];
            System.out.println("#" + t + " " + result);
        }
    }
 
}
