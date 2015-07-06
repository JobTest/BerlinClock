package com.berlinclock;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.0
 * @date 28/06/2015
 * ***************************
 * The Berlin Clock interface:
 */
public interface IBerlinClock {

    /**
     * @param time
     * @return 'O RROO RRRO YYROOOOOOOO YYOO'
     */
    String convertTime(String time);

}
