package calendarHandler;

import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;

public class CalendarHandler {

    private static final Calendar calendar = Calendar.getInstance();
    private static final Date date = new Date();

    public static String[][] getMonths() {
        String[][] output = new String[12][2];

        calendar.setTime(date);

        int j = calendar.get(Calendar.YEAR);

        for (int i = 0; i < 12; i++) {

            switch (calendar.get(Calendar.MONTH)) {
                case 0: output[i][0] = String.valueOf(j); output[i][1] = "Leden";
                    break;
                case 1: output[i][0] = String.valueOf(j); output[i][1] = "Únor";
                    break;
                case 2: output[i][0] = String.valueOf(j); output[i][1] = "Březen";
                    break;
                case 3: output[i][0] = String.valueOf(j); output[i][1] = "Duben";
                    break;
                case 4: output[i][0] = String.valueOf(j); output[i][1] = "Květen";
                    break;
                case 5: output[i][0] = String.valueOf(j); output[i][1] = "Červen";
                    break;
                case 6: output[i][0] = String.valueOf(j); output[i][1] = "Červenec";
                    break;
                case 7: output[i][0] = String.valueOf(j); output[i][1] = "Srpen";
                    break;
                case 8: output[i][0] = String.valueOf(j); output[i][1] = "Září";
                    break;
                case 9: output[i][0] = String.valueOf(j); output[i][1] = "Říjen";
                    break;
                case 10: output[i][0] = String.valueOf(j); output[i][1] = "Listopad";
                    break;
                case 11: output[i][0] = String.valueOf(j); output[i][1] = "Prosinec";
                    break;
            }

            calendar.roll(Calendar.MONTH, true);
            if(calendar.get(Calendar.MONTH) == Calendar.JANUARY) j += 1;
        }

        return output;
    }
}
