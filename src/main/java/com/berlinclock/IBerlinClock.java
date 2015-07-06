package com.berlinclock;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.1
 * @date 28/06/2015
 * {@link http://www.3quarks.com/en/TimeConverter/}
 * ************************************************
 * The interface 'Berlin Clock':
 */
public interface IBerlinClock {

    /**
     * @param time
     * @return 'O RROO RRRO YYROOOOOOOO YYOO'
     */
    String convertTime(String time) throws IllegalArgumentException;

}
