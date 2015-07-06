package com.berlinclock;

/**
 * @author Lazarchuk Aleksandr
 * @version 1.0
 * @date 28/06/2015
 * ***************************
 * The Berlin Clock interface:
 */
public interface TimeConverter {

    /**
     * @param time
     * @return 'O RROO RRRO YYROOOOOOOO YYOO'
     */
    public String convertTime(String time) throws NumberFormatException;

}
