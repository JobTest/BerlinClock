package com;

import com.berlinclock.BerlinClock;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.1
 * @date 28/06/2015
 * *********************************************
 * convertTime implements for Clock-Unix format:
 * param time 'UNIX'
 * return 'O RROO RRRO YYROOOOOOOO YYOO'
 */
public class ClockUnix extends BerlinClock {

    public static final String PATTERN_CLOCK_UNIX = "^[0-9]+$";

    @Override
    public  String convertTime(String time) throws IllegalArgumentException {
        if(!StringUtils.isEmpty(time) && !StringUtils.isBlank(time)) {
            Pattern patternClockUnix = Pattern.compile(PATTERN_CLOCK_UNIX);
            if( patternClockUnix.matcher(time).matches() ){
                int   aTime = Integer.valueOf(time).intValue();
                int   hours = aTime / 60 / 60;
                int minutes = (aTime - (hours * 60 * 60)) / 60;
                int seconds = aTime - ((hours * 60 * 60) + (minutes * 60));
                if( 0 <= seconds && seconds < 60
                        && 0 <= hours && hours < 24
                        && 0 <= minutes && minutes < 60 )
                    return generateBerlinClockTime(hours, minutes, seconds);
            }
            return BerlinClock.TIME_ZERO;
        } else {
            throw new IllegalArgumentException("Illegal Argument");
        }
    }
}
