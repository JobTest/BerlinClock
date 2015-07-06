package com;

import com.berlinclock.BerlinClock;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.1
 * @date 28/06/2015
 * *******************************************
 * convertTime implements for Clock-24 format:
 * param time 'HH:mm:ss'
 * return 'O RROO RRRO YYROOOOOOOO YYOO'
 */
public class Clock24 extends BerlinClock {

    public static final String PATTERN_CLOCK_24 = "^[0-9]+:[0-9]+:[0-9]+$";

    @Override
    public  String convertTime(String time) throws IllegalArgumentException {
        if(!StringUtils.isEmpty(time) && !StringUtils.isBlank(time))
        {
            Pattern patternClock24 = Pattern.compile(PATTERN_CLOCK_24);
            if( patternClock24.matcher(time).matches() )
            {
                String[] aTime = time.split(":");
                int      hours = Integer.valueOf(aTime[0]).intValue();
                int    minutes = Integer.valueOf(aTime[1]).intValue();
                int    seconds = Integer.valueOf(aTime[2]).intValue();
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
