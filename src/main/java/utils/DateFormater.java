package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
    public static String formattedDateAndHour () {
        Date now = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy HH'h'mm'm'ss's'");
        String formattedDate = dateFormatter.format(now);
        return formattedDate;
    }

    public static String formattedDate () {
        Date now = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy");
        String formattedDate = dateFormatter.format(now);
        return formattedDate;
    }
}
