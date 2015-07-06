package com.berlinclock;

import com.Clock12;
import com.Clock24;
import com.ClockUnix;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
* @author Lazarchuk Aleksandr
* @version 1.1
* @date 28/06/2015
* *********************************************************
* The test convertTime function for different time formats:
*/
public class BerlinClockTest {

    private IBerlinClock clock24, clock12, clockUnix;

    @Before
    public void setUp() {
        clock24   = new Clock24();
        clock12   = new Clock12();
        clockUnix = new ClockUnix();
    }

    /**
     * Test UseCase for TimeFormat-24
     */
    @Test (timeout = 100)
    @Category(IBerlinClock.class)
    public void testConvertTime24(){
        String   actualValidTime24 = "13:17:01";
        String actualInvalidTime24 = "13:71:01";
        String   actualValidTime12 = "01:17:01 PM";
        String actualValidTimeUnix = "47821";
        String      actualNullTime = null;
        String   actualInvalidTime = "";
        String   expectedValidTime = "O RROO RRRO YYROOOOOOOO YYOO";
        String expectedInvalidTime = BerlinClock.TIME_ZERO;

        assertEquals("Here is test TimeFormat-24 for get valid Time & valid Time-Format(24): ", expectedValidTime, clock24.convertTime(actualValidTime24));
        assertEquals("Here is test TimeFormat-24 for get invalid Time & valid Time-Format(24): ", expectedInvalidTime, clock24.convertTime(actualInvalidTime24));
        assertEquals("Here is test TimeFormat-24 for get invalid Time-Format(12): ", expectedInvalidTime, clock24.convertTime(actualValidTime12));
        assertEquals("Here is test TimeFormat-24 for get invalid Time-Format(Unix): ", expectedInvalidTime, clock24.convertTime(actualValidTimeUnix));
        assertNull("Here is test TimeFormat-24 for get Null Time: ", clock24.convertTime(actualNullTime));
        assertEquals("Here is test TimeFormat-24 for get invalid Time-Format: ", expectedInvalidTime, clock24.convertTime(actualInvalidTime));
    }

    /**
     * Test UseCase for TimeFormat-12
     */
    @Test (timeout = 100)
    @Category(IBerlinClock.class)
     public void testConvertTime12(){
        String   actualValidTime12 = "01:17:01 PM";
        String actualInvalidTime12 = "01:71:01 PM";
        String   actualValidTime24 = "13:17:01";
        String actualValidTimeUnix = "47821";
        String      actualNullTime = null;
        String   actualInvalidTime = "";
        String   expectedValidTime = "O RROO RRRO YYROOOOOOOO YYOO";
        String expectedInvalidTime = BerlinClock.TIME_ZERO;

        assertEquals("Here is test TimeFormat-12 for get valid Time & valid Time-Format(12): ", expectedValidTime, clock12.convertTime(actualValidTime12));
        assertEquals("Here is test TimeFormat-12 for get invalid Time & valid Time-Format(12): ", expectedInvalidTime, clock12.convertTime(actualInvalidTime12));
        assertEquals("Here is test TimeFormat-12 for get invalid Time-Format(24): ", expectedInvalidTime, clock12.convertTime(actualValidTime24));
        assertEquals("Here is test TimeFormat-12 for get invalid Time-Format(Unix): ", expectedInvalidTime, clock12.convertTime(actualValidTimeUnix));
        assertNull("Here is test TimeFormat-12 for get Null Time: ", clock12.convertTime(actualNullTime));
        assertEquals("Here is test TimeFormat-12 for get invalid Time-Format: ", expectedInvalidTime, clock12.convertTime(actualInvalidTime));
    }

    /**
     * Test UseCase for TimeFormat-Unix
     */
    @Test (timeout = 100)
    @Category(IBerlinClock.class)
    public void testConvertTimeUnix(){
        String   actualValidTimeUnix = "47821";
        String actualInvalidTimeUnix = "86401";
        String     actualValidTime24 = "13:17:01";
        String     actualValidTime12 = "01:17:01 PM";
        String        actualNullTime = null;
        String     actualInvalidTime = "";
        String     expectedValidTime = "O RROO RRRO YYROOOOOOOO YYOO";
        String   expectedInvalidTime = BerlinClock.TIME_ZERO;

        assertEquals("Here is test TimeFormat-Unix for get valid Time & valid Time-Format(Unix): ", expectedValidTime, clockUnix.convertTime(actualValidTimeUnix));
        assertEquals("Here is test TimeFormat-Unix for get invalid Time & valid Time-Format(Unix): ", expectedInvalidTime, clockUnix.convertTime(actualInvalidTimeUnix));
        assertEquals("Here is test TimeFormat-Unix for get invalid Time-Format(24): ", expectedInvalidTime, clockUnix.convertTime(actualValidTime24));
        assertEquals("Here is test TimeFormat-Unix for get invalid Time-Format(12): ", expectedInvalidTime, clockUnix.convertTime(actualValidTime12));
        assertNull("Here is test TimeFormat-Unix for get Null Time: ", clockUnix.convertTime(actualNullTime));
        assertEquals("Here is test TimeFormat-Unix for get invalid Time-Format: ", expectedInvalidTime, clockUnix.convertTime(actualInvalidTime));
    }

}
