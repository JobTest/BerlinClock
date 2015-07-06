package com.berlinclock;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.1
 * @date 28/06/2015
 * ************************
 * The 'Berlin Clock':
 */
public abstract class BerlinClock implements IBerlinClock {

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
     *
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

    private void calculateHours(int hours) {
        firstRowHours = hours / 5;
        secondRowHours = hours - (firstRowHours * 5);
    }
    private void calculateMinutes(int minutes){
        firstRowMinutes  = minutes / 5;
        secondRowMinutes = minutes - (firstRowMinutes * 5);
    }
    private void calculateSeconds(int seconds) {
        rowSeconds = (seconds%2) == 0 ? true : false;
    }

    private String indicateRowSeconds() {
        return rowSeconds ? "Y" : "O";
    }
    private String indicateFirstRowHours() {
        StringBuffer strFirstRowHour = new StringBuffer();
        for (int frh=1; frh<5; frh++)
            strFirstRowHour.append( frh <= firstRowHours ? "R" : "O");
        return strFirstRowHour.toString();
    }
    private String indicateSecondRowHours() {
        StringBuffer strSecondRowHour = new StringBuffer();
        for (int srh=1; srh<5; srh++)
            strSecondRowHour.append( srh <= secondRowHours ? "R" : "O");
        return strSecondRowHour.toString();
    }
    private String indicateFirstRowMinutes() {
        StringBuffer strFirstRowMinute = new StringBuffer();
        for (int frm = 1; frm < 12; frm++)
            strFirstRowMinute.append( frm <= firstRowMinutes ? frm % 3 == 0 ? "R" : "Y" : "O" );
        return strFirstRowMinute.toString();
    }
    private String indicateSecondRowMinutes() {
        StringBuffer strSecondRowMinute = new StringBuffer();
        for (int srm = 1; srm < 5; srm++)
            strSecondRowMinute.append( srm <= secondRowMinutes ? "Y" : "O");
        return strSecondRowMinute.toString();
    }
}