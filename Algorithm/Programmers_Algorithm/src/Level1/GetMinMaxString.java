package Level1;

import java.util.Arrays;

//Level1. 최대값과 최소값
public class GetMinMaxString {
    public String getMinMaxString(String str) {
      String[] array = str.split(" ");
			int[] numArray = new int[array.length]; 
		
			for(int i=0; i<numArray.length; i++){
				numArray[i] = Integer.parseInt(array[i]);
			}
			Arrays.sort(numArray);
			String result = numArray[0] + " " + numArray[numArray.length-1];
			return result;
    }

    public static void main(String[] args) {
        String str = "1 2 3 4";
        GetMinMaxString minMax = new GetMinMaxString();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println("최대값과 최소값은?" + minMax.getMinMaxString(str));
    }
}