package parkiran;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Waktu {
    public static String updateTimer() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        return sdf.format(now);
    }
}
