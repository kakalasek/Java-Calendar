package calendarHandler;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.*;

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

    public static int getDaysInMonth(String month, int year){
        int monthIndex = parseMonthStringToInt(month);

        return YearMonth.of(year, monthIndex).lengthOfMonth();
    }

    public static String getDayOfWeek(int day, String month, int year){
        int monthIndex = parseMonthStringToInt(month);

        return LocalDate.of(year, monthIndex, day).getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("cs", "CZ")).toUpperCase();
    }

    private static int parseMonthStringToInt(String month){
        return switch (month.toLowerCase()) {
            case "leden" -> 1;
            case "únor" -> 2;
            case "březen" -> 3;
            case "duben" -> 4;
            case "květen" -> 5;
            case "červen" -> 6;
            case "červenec" -> 7;
            case "srpen" -> 8;
            case "září" -> 9;
            case "říjen" -> 10;
            case "listopad" -> 11;
            case "prosinec" -> 12;
            default -> 0;
        };
    }
}
