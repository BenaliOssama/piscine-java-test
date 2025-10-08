import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DayOfWeekFinder {
    public String findNextDayOfWeek(String startDate, String dayOfWeek) {
        
        String s1 = dayOfWeek.toLowerCase();

        String[] split = startDate.split("-");
        if (split.length != 3) {
            return "Error"; 
        }

        String year = split[0];
        String month = split[1];
        String day = split[2];

        LocalDate date = LocalDate.parse(startDate);//.from(startDate);
        //return date.getDayOfWeek();
        //System.out.println(date.getDayOfWeek());
        //String dayS = date.getDayOfWeek().toString().toLowerCase();
        for (int i = 0 ; i < 10 ; i ++) {
            if ( date.getDayOfWeek().toString().toLowerCase().equals( s1) ){
                break;
            }else if (i == 9){
                return "Error";
            } else{
                 date = date.plusDays(1);
            }

        }
        return date.toString();
    }
}
