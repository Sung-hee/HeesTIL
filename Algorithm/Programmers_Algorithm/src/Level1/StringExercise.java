package Level1;

//Level1. 가운데 글자 가져오기
public class StringExercise{
	
    String getMiddle(String word){
      if(word.length() % 2 == 0){
        return word.substring(word.length()/2 - 1, word.length()/2 + 1);
      }
      else
        return word.substring(word.length()/2, word.length()/2 + 1);
    }
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void  main(String[] args){
        StringExercise se = new StringExercise();
        System.out.println(se.getMiddle("power"));
    }
}
