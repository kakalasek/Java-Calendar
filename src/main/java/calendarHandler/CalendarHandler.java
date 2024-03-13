package calendarHandler;

import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;

public class CalendarHandler {

    private static final Calendar calendar = Calendar.getInstance();
    private static final Date date = new Date();

    public static String[] getMonths() {
        String[] output = new String[12];

        calendar.setTime(date);

        int j = calendar.get(Calendar.YEAR);

        for (int i = 0; i < 12; i++) {

            switch (calendar.get(Calendar.MONTH)) {
                case 0: output[0] = String.valueOf(j); output[1] = "Leden";
                    break;
                case 1: output[0] = String.valueOf(j); output[1] = "Leden";
                    break;
                case 2: output[0] = String.valueOf(j); output[1] = "Leden";
                    break;
                case 3: output[0] = String.valueOf(j); output[1] = "Leden";
                    break;
                case 4: output.put("Květen", j);
                    break;
                case 5: output.put("Červen", j);
                    break;
                case 6: output.put("Červenec", j);
                    break;
                case 7: output.put("Srpen", j);
                    break;
                case 8: output.put("Září", j);
                    break;
                case 9: output.put("Říjen", j);
                    break;
                case 10: output.put("Listopad", j);
                    break;
                case 11: output.put("Prosinec", j);
                    break;
            }


            calendar.roll(Calendar.MONTH, true);
            if(calendar.get(Calendar.MONTH) == Calendar.JANUARY) j += 1;
        }

        return output;
    }
}
