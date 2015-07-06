package com;

import com.berlinclock.BerlinClock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.0
 * @date 28/06/2015
 * *********************************************
 * convertTime implements for Clock-Unix format:
 */
public class ClockUnix extends BerlinClock {

    /**
     *
     * @param time 'UNIX'
     * @return 'O RROO RRRO YYROOOOOOOO YYOO'
     */
    @Override
    public  String convertTime(String time) throws NumberFormatException {
        if(time != null)
        {
            Pattern patternClockUnix = Pattern.compile("^[0-9]+$");
            Matcher   matchClockUnix = patternClockUnix.matcher(time);
            if( matchClockUnix.matches() ){
                int   aTime = Integer.valueOf(time).intValue();
                int   hours = aTime / 60 / 60;
                int minutes = (aTime - (hours * 60 * 60)) / 60;
                int seconds = aTime - ((hours * 60 * 60) + (minutes * 60));
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
