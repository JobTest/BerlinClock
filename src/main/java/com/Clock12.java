package com;

import com.berlinclock.BerlinClock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.0
 * @date 28/06/2015
 * *******************************************
 * convertTime implements for Clock-12 format:
 */
public class Clock12 extends BerlinClock {

    /**
     *
     * @param time 'hh:mm:ss meridiem'
     * @return 'O RROO RRRO YYROOOOOOOO YYOO'
     */
    @Override
    public  String convertTime(String time) throws NumberFormatException {
        if(time != null)
        {
            Pattern patternClock12 = Pattern.compile("^[0-9]+:[0-9]+:[0-9]+ [A-Za-z]+$");
            Matcher   matchClock12 = patternClock12.matcher(time);
            if( matchClock12.matches() )
            {
                String[] timePrepared = time.split(" ");
                String[]        aTime = timePrepared[0].split(":");
                int             hours = Integer.valueOf(aTime[0]).intValue();
                int           minutes = Integer.valueOf(aTime[1]).intValue();
                int           seconds = Integer.valueOf(aTime[2]).intValue();
                String       meridiem = timePrepared[1];
                if( (0 <= seconds && seconds < 60)
                        && (0 <= hours && hours < 12)
                        && (0 <= minutes && minutes < 60)
                        && (meridiem.equalsIgnoreCase("am") || meridiem.equalsIgnoreCase("pm")) )
                {
                    hours = meridiem.equalsIgnoreCase("pm") ? (hours+12) : hours;
                    return generateBerlinClockTime(hours, minutes, seconds);
                }
            }
            throw new NumberFormatException();
        } else {
            return null;
        }
    }
}
