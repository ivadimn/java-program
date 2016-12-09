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
    }

    public void fillDays() {

    }

    private void clearDays() {

    }

}
