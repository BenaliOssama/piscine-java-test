import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MonthlyPeriod {
    public String calculatePeriod(String startDate, String endDate) {
        // Implementation to calculate the period between two dates in months and years
        LocalDate date1 = LocalDate.parse(startDate);
        LocalDate date2 = LocalDate.parse(endDate);

        Period period = Period.between(date1, date2);
        
        String res = "" ; 
        if (period.getMonths() > 0) {
            res = String.format("%d months", period.getMonths() );
        }

        if (period.getYears() > 0 ) {
            if (!res.equals("")){
                res = String.format("%d years and ", period.getYears()) + res;
            }else{
                res = String.format("%d years", period.getYears()) + res;
            }
        }

        return res;
    }
}
