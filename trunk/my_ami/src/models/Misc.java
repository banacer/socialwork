/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Nacer Khalil
 */
public class Misc {
    
    public static int calculateDifference(Date a, Date b)
    {
        int tempDifference = 0;
        int difference = 0;
        Calendar earlier = Calendar.getInstance();
        Calendar later = Calendar.getInstance();

        if (a.compareTo(b) < 0)
        {
            earlier.setTime(a);
            later.setTime(b);
        }
        else
        {
            earlier.setTime(b);
            later.setTime(a);
        }

        while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR))
        {
            tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
            difference += tempDifference;

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }

        if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR))
        {
            tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
            difference += tempDifference;

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }
        return difference;
    }
    
    public static int fromFloorNametoNum(String name)
    {
        System.out.println("");
        if(name.equalsIgnoreCase("rez de chaussée"))
            return 0;
        if(name.equalsIgnoreCase("Etage 1"))
            return 1;
        if(name.equalsIgnoreCase("Etage 2"))
            return 2;
        if(name.equalsIgnoreCase("Etage 3"))
            return 3;
        
        else return -1;
    }

}
