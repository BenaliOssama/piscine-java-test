import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectTime {
    private String startTime;
    private String endTime;
    private float hoursLogged;
    
    public ProjectTime(String start, String end){
        this.startTime = start;
        this.endTime = end;
        calculateHours();
    };

    public void setStartTime(String time){
        this.startTime = time;
        // update
        calculateHours();
    };

    public void setEndTime(String time){
        this.endTime = time; // ✅ fix
        calculateHours();
    }


    public String getStartTime(){
        return this.startTime;
    };

    public String getEndTime(){
        return this.endTime;
    };

    public String getHoursLogged() {
        if (hoursLogged == -1) {
            return "-1";
        }
        if (hoursLogged < 2) {
            return (int)(hoursLogged * 60) + " m"; // minutes
        } else if (hoursLogged < 120) {
            return (int)hoursLogged + " h"; // hours
        } else if (hoursLogged < 120 * 24) {
            return (int)(hoursLogged / 24) + " d"; // days
        } else {
            return (int)(hoursLogged / (24 * 30)) + " mo"; // months
        }
    }

    private void calculateHours() {
        try {
            long startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                .parse(startTime).getTime();
            long endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                .parse(endTime).getTime();

            long diff = endDate - startDate;
            if (diff < 0) {
                hoursLogged = -1;
                return;
            }

            // convert milliseconds → hours (float)
            hoursLogged = diff / (1000f * 60 * 60);

        } catch (Exception e) {
                hoursLogged = -1;
        }
    }

}
