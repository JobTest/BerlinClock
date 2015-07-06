package com.berlinclock;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.0
 * @date 28/06/2015
 * {@link http://www.3quarks.com/en/TimeConverter/}
 * ************************************************
 * The Berlin Clock object:
 */
public abstract class BerlinClock implements TimeConverter {

    /**
     * return zero BerlinClock time format
     */
    public static final String TIME_ZERO = "O OOOO OOOO OOOOOOOOOOO OOOO";

    /**
     * The round yellow light crowning the clock at the top is of minor significance for telling the time: It blinks every second.
     */
    private boolean rowSeconds;
    /**
     * These indicate the hours of a day.
     * Every lamp represents 5 hours.
     */
    private int firstRowHours;
    /**
     * In the lower row of red lamps every lamp represents 1 hour.
     */
    private int secondRowHours;
    /**
     * The two rows of lamps at the bottom count the minutes.
     * The first of these rows has 11 lamps, the second 4.
     */
    private int firstRowMinutes;
    private int secondRowMinutes;

    /**
     * Middle of the afternoon When the time is 13:17:01 Then the clock should look like 'O RROO RRRO YYROOOOOOOO YYOO'
     * @param hours 'HH'
     * @param minutes 'mm'
     * @param seconds 'ss'
     * @return BerlinClock time format 'O RROO RRRO YYROOOOOOOO YYOO'
     */
    public final String generateBerlinClockTime(int hours, int minutes, int seconds){
        calculateHours(hours);
        calculateMinutes(minutes);
        calculateSeconds(seconds);

        return indicateRowSeconds() + " " + indicateFirstRowHours() + " " + indicateSecondRowHours() + " "  + indicateFirstRowMinutes() + " " + indicateSecondRowMinutes();
    }

    /**
     * Every lamp represents 5 hours.
     * So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.
     * @param hours
     */
    private void calculateHours(int hours) {
        firstRowHours = hours / 5;
        secondRowHours = hours - ((hours / 5) * 5);
    }
    /**
     * In the first row every lamp represents 5 minutes. In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour.
     * The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.
     * @param minutes
     */
    private void calculateMinutes(int minutes){
        firstRowMinutes  = minutes / 5;
        secondRowMinutes = minutes - ((minutes / 5) * 5);
    }
    private void calculateSeconds(int seconds) {
        if ((seconds % 2) == 0)
        {
            rowSeconds = true;
        } else {
            rowSeconds = false;
        }
    }

    /**
     * These indicate the hours and minutes and seconds of a day.
     * @return
     */
    private String indicateRowSeconds() {
        if (rowSeconds)
        {
            return "Y";
        } else {
            return "O";
        }
    }
    private String indicateFirstRowHours() {
        StringBuffer strFirstRowHour = new StringBuffer();
        for (int frh = 1; frh < 5; frh++)
        {
            if (frh <= firstRowHours)
            {
                strFirstRowHour.append("R");
            } else {
                strFirstRowHour.append("O");
            }
        }
        return strFirstRowHour.toString();
    }
    private String indicateSecondRowHours() {
        StringBuffer strSecondRowHour = new StringBuffer();
        for (int srh = 1; srh < 5; srh++)
        {
            if (srh <= secondRowHours)
            {
                strSecondRowHour.append("R");
            } else {
                strSecondRowHour.append("O");
            }
        }
        return strSecondRowHour.toString();
    }
    private String indicateFirstRowMinutes() {
        StringBuffer strFirstRowMinute = new StringBuffer();
        for (int frm = 1; frm < 12; frm++)
        {
            if (frm <= firstRowMinutes)
            {
                if ((frm % 3) == 0)
                {
                    strFirstRowMinute.append("R");
                } else {
                    strFirstRowMinute.append("Y");
                }
            } else {
                strFirstRowMinute.append("O");
            }
        }
        return strFirstRowMinute.toString();
    }
    private String indicateSecondRowMinutes() {
        StringBuffer strSecondRowMinute = new StringBuffer();
        for (int srm = 1; srm < 5; srm++)
        {
            if (srm <= secondRowMinutes)
            {
                strSecondRowMinute.append("Y");
            } else {
                strSecondRowMinute.append("O");
            }
        }
        return strSecondRowMinute.toString();
    }
}