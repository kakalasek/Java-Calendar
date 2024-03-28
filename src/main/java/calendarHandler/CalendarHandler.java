package calendarHandler;

import utils.Utils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.*;

public class CalendarHandler {

    public static String[][] getMonths() {
        String[][] output = new String[12][2];

        LocalDate localDate = LocalDate.now();

        for (int i = 0; i < 12; i++) {

            output[i][0] = String.valueOf(localDate.getYear());
            output[i][1] = Utils.capitalize(localDate.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, new Locale("cs", "CZ")));

            localDate = localDate.plusMonths(1);
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
