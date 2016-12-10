package ru.ivadimn.model;

import java.util.Calendar;

/**
 * Created by vadim on 09.12.16.
 */
public class Month  {

    public static final int DAYS_IN_WEEK = 7;
    public static final int MAX_WEEKS = 6;

    private static final Calendar CALENDAR = Calendar.getInstance();

    private int month;
    private int year;
    private int today;
    private int[][] days = new int[MAX_WEEKS][DAYS_IN_WEEK];

    public Month() {
        year = CALENDAR.get(Calendar.YEAR);
        month = CALENDAR.get(Calendar.MONTH);
        today = CALENDAR.get(Calendar.DAY_OF_MONTH);
        fillDays();
    }

    public void fillDays() {
        clearDays();
        CALENDAR.set(year, month, 1);
        int dayOfWeek = 0;
        int weekOfMonth = 0;
        while (month == CALENDAR.get(Calendar.MONTH)) {
            dayOfWeek = CALENDAR.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek > 1) dayOfWeek -= 2;
            else if (dayOfWeek == 1) dayOfWeek = DAYS_IN_WEEK - 1;
            weekOfMonth = CALENDAR.get(Calendar.WEEK_OF_MONTH) - 1;
            days[weekOfMonth][dayOfWeek] = CALENDAR.get(Calendar.DAY_OF_MONTH);
            CALENDAR.add(Calendar.DAY_OF_MONTH, 1);
        }
    }

    private void clearDays() {
        for (int i = 0; i < MAX_WEEKS; i++) {
            for (int j = 0; j < DAYS_IN_WEEK; j++) {
                days[i][j] = 0;
            }

        }
    }

}
