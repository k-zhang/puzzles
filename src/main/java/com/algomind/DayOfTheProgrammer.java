package com.algomind;

import java.util.Arrays;

/***
 * Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on the Day of the Programmer
 * (the 256 day of the year) during a year in the inclusive range from 1700 to 2700.
 * From 1700 to 1917, Russia's official calendar was the Julian calendar; since 1919 they used the Gregorian calendar system.
 *
 * The transition from the Julian to Gregorian calendar system occurred in 1918, when the next day after January 31st was February 14th.
 * This means that in 1918, February 14th was the 32nd day of the year in Russia.
 *
 * In both calendar systems, February is the only month with a variable amount of days; it has 29 days during a leap year, and 28 days during all other years.
 * In the Julian calendar, leap years are divisible by 4; in the Gregorian calendar, leap years are either of the following:
 *      - Divisible by 400.
 *      - Divisible by 1 and not divisible by 100.
 *
 * Given a year, y, find the date of the 256th day of that year according to the official Russian calendar during that year.
 * Then print it in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is y.
 *
 * For example, the given year = 1984. 1984 is divisible by 4, so it is a leap year. The 256th day of a leap year after 1918 is September 12, so the answer is 21.09.1984.
 *
 * Function Description
 * Complete the dayOfProgrammer function in the editor below. It should return a string representing the date of the 256th day of the year given.
 *
 * Input Format
 * A single integer denoting year y.
 *
 ***/


public class DayOfTheProgrammer {
    private static final int[] days = new int[] {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int DAY = 256;

    public String dayOfProgrammer(int year) {
        Date dateResult;

        if(year < 1918) {
            dateResult = findJulianDate(year);
        }else if(year > 1918) {
            dateResult = findGeogianDate(year);
        }else{
            dateResult = find1918(year);
        }

        return dateResult.toString();
    }

    private static Date find1918(int year) {
        int daysInFeb = 15;
        Date date = workoutCalendarDate(year, daysInFeb);
        if(date.month == 2) date.day += 13;
        return date;
    }

    private static Date findJulianDate(int year) {
        int daysInFeb = year % 4 == 0 ? 29 : 28;
        return workoutCalendarDate(year, daysInFeb);
    }

    private static Date findGeogianDate(int year) {
        int daysInFeb = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0) ? 29 : 28;
        return workoutCalendarDate(year, daysInFeb);
    }

    private static Date workoutCalendarDate(int year, int daysInFeb) {
        int[] calendarDays = Arrays.copyOf(days, days.length);
        calendarDays[1] = daysInFeb;

        int month = 0;
        int remainDays = DAY;
        for(int i = 0 ; i < days.length ; i++) {
            if(remainDays < 0) {
                break;
            }
            remainDays -= calendarDays[i];
            month = i + 1;
        }

        return new Date(year, month, calendarDays[month - 1] + remainDays);
    }

    public static class Date {
        private int year;
        private int month;
        private int day;

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public String toString() {
            return String.format("%02d", day) + "." + String.format("%02d", month) + "." + String.format("%02d", year);
        }
    }
}
