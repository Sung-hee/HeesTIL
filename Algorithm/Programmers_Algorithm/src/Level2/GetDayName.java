package Level2;

public class GetDayName {

	 public String getDayName(int a, int b)
	    {
	      String answer = "";
	      int[] Months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	      String[] Day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
	      int DayofWeeks = 0;

	      for(int i = 0; i < a - 1; i++){
	        DayofWeeks += Months[i];
	      }
	      DayofWeeks += (b-1);
	      answer = Day[DayofWeeks%7];

	      return answer;
	    }
	    public static void main(String[] args)
	    {
	    	GetDayName test = new GetDayName();
	        int a=5, b=24;
	        System.out.println(test.getDayName(a,b));
	    }
	}
