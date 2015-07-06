package com;

import com.berlinclock.BerlinClock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.0
 * @date 28/06/2015
 * *******************************************
 * convertTime implements for Clock-24 format:
 */
public class Clock24 extends BerlinClock {

    /**
     *
     * @param time 'HH:mm:ss'
     * @return 'O RROO RRRO YYROOOOOOOO YYOO'
     */
    @Override
    public  String convertTime(String time) throws NumberFormatException {
        if(time != null)
        {
            Pattern patternClock24 = Pattern.compile("^[0-9]+:[0-9]+:[0-9]+$");
            Matcher   matchClock24 = patternClock24.matcher(time);
            if( matchClock24.matches() )
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
            throw new NumberFormatException();
        } else {
            return null;
        }
    }
}
