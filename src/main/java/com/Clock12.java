package com;

import com.berlinclock.BerlinClock;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.1
 * @date 28/06/2015
 * *******************************************
 * convertTime implements for Clock-12 format:
 * param time 'hh:mm:ss meridiem'
 * return 'O RROO RRRO YYROOOOOOOO YYOO'
 */
public class Clock12 extends BerlinClock {

    public static final String PATTERN_CLOCK_12 = "^[0-9]+:[0-9]+:[0-9]+ [A-Za-z]+$";

    @Override
    public  String convertTime(String time) throws IllegalArgumentException {
        if(!StringUtils.isEmpty(time) && !StringUtils.isBlank(time))
        {
            Pattern patternClock12 = Pattern.compile(PATTERN_CLOCK_12);
            if( patternClock12.matcher(time).matches() )
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
                    return generateBerlinClockTime(meridiem.equalsIgnoreCase("pm") ? (hours+12) : hours, minutes, seconds);
            }
            return BerlinClock.TIME_ZERO;
        } else {
            throw new IllegalArgumentException("Illegal Argument");
        }
    }
}
