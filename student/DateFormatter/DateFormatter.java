import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {
    private long date; // in seconds
    private String formattedDate;
    private String format;

    // Accepted formats
    private static final String[] ACCEPTED_FORMATS = {
        "DD/MM/YYYY", "DD Month YYYY", "DD.MM.YYYY"
    };

    // Default constructor
    public DateFormatter() {
        this.date = System.currentTimeMillis() / 1000L; // current UTC time in seconds
        this.format = "DD/MM/YYYY";
        updateFormattedDate();
    }

    // Constructor with date only
    public DateFormatter(long date) {
        this.date = date;
        this.format = "DD/MM/YYYY";
        updateFormattedDate();
    }

    // Constructor with date and format
    public DateFormatter(long date, String format) {
        this.date = date;
        if (isValidFormat(format)) {
            this.format = format;
            updateFormattedDate();
        } else {
            this.format = "DD/MM/YYYY";
            updateFormattedDate();
        }
    }

    // Getters
    public long getDate() {
        return date;
    }

    public String getFormat() {
        return format;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    // Setters
    public void setDate(long date) {
        this.date = date;
        updateFormattedDate();
    }

    public void setFormat(String format) {
        if (isValidFormat(format)) {
            this.format = format;
            updateFormattedDate();
        }
    }

    // Validate the format (case-insensitive)
    private boolean isValidFormat(String format) {
        for (String f : ACCEPTED_FORMATS) {
            if (f.equalsIgnoreCase(format)) return true;
        }
        return false;
    }

    // Convert custom format to Java SimpleDateFormat pattern
    private String toSimpleDateFormatPattern(String format) {
        format = format.toLowerCase();
        switch (format) {
            case "dd/mm/yyyy": return "dd/MM/yyyy";
            case "dd month yyyy": return "dd MMMM yyyy";
            case "dd.mm.yyyy": return "dd.MM.yyyy";
            default: return null; // should never happen if validated
        }
    }

    // Update the formattedDate field
    private void updateFormattedDate() {
        String pattern = toSimpleDateFormatPattern(this.format);
        if (pattern != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            this.formattedDate = sdf.format(new Date(this.date * 1000));
        }
    }
}

