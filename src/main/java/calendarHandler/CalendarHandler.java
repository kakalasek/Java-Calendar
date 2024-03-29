package calendarHandler;

import utils.Utils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.*;

/**
 * A class to handle all date and time operations for this program
 */
public class CalendarHandler {

    /**
     * Returns all 12 months from now and their respective years
     * @return An array of Strings. Each row ( out of 12 ) represents a month and is made up of the year at the 0 index and the full month name at the 1 index.
     */
    public static String[][] getMonths() {
        String[][] output = new String[12][2];  // Prepares the output array

        LocalDate localDate = LocalDate.now();  // Creates localDate object with current date

        // Fills the output array
        for (int i = 0; i < 12; i++) {

            output[i][0] = String.valueOf(localDate.getYear()); // Putting year of the month at the 0 index
            output[i][1] = Utils.capitalize(localDate.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, new Locale("cs", "CZ")));    // Putting the full name of the month at the 1 index

            localDate = localDate.plusMonths(1); // Moving on by a month
        }

        return output;
    }

    /**
     * Used to retrieve the number days in a month
     * @param month Accepts name of month in czech full standalone format
     * @param year Year for the corresponding month
     * @return Number of days in the month
     */
    public static int getDaysInMonth(String month, int year){
        int monthIndex = parseMonthStringToInt(month);  // Convert month string into integer by mapping numbers 1-12 to the corresponding months

        return YearMonth.of(year, monthIndex).lengthOfMonth();
    }

    /**
     * Returns the specified day of the week in czech short format
     * @param day Day in month
     * @param month Month in year
     * @param year Speaks for itself...
     * @return The czech short format String
     */
    public static String getDayOfWeek(int day, String month, int year){
        int monthIndex = parseMonthStringToInt(month);  // Obtains the index of a month

        return LocalDate.of(year, monthIndex, day).getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("cs", "CZ")).toUpperCase();
    }

    /**
     * Maps month string to number and returns the number
     * @param month The month in czech full standalone format
     * @return The corresponding number for the entered month
     */
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
