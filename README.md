# The Berlin Clock

The Berlin Uhr (Clock) is a rather strange way to show the time. On the top of the clock there is a yellow lamp that
blinks on/off every two seconds. The time is calculated by adding rectangular lamps.
 
The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps. Every lamp
represents 5 hours. In the lower row of red lamps every lamp represents 1 hour. So if two lamps of the first row and
three of the second row are switched on that indicates 5+5+3=13h or 1 pm.
 
The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4. In the
first row every lamp represents 5 minutes. In this first row the 3rd, 6th and 9th lamp are red and indicate the first
quarter, half and last quarter of an hour. The other lamps are yellow. In the last row with 4 lamps every lamp
represents 1 minute.

One can be seen [here](http://www.3quarks.com/en/BerlinClock/)

Sample use case:

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Sample Berlin Clock interface:

public interface TimeConverter {

    String convertTime(String aTime);

}


# Expected outcome

Archive or link on repository, containing:
- Working solution of Berlin Clock algorithm (usage of Maven project structure is preferable)
- Simple, elegant code that reads like a narrative (refer to Clean Code concepts)
- Automated tests proving that solution works (JUnit or any other framework may be used)