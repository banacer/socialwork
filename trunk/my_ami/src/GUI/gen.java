/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import models.Bed;
import models.Room;

/**
 *
 * @author Nacer Khalil
 */
public class gen {

    public static void main(String[] args) throws Exception
    {
        Room room = null;
        Bed bed = null;
        int roomId = 0;
        for(int i = 0; i< 56; i++)
        {
            if(i % 4 == 0)
            {
                if(roomId == 4)
                    roomId = 0;
                roomId++;
                room = new Room((i/16), roomId, "standard",4);
                room.save();
            }
            int num = (i % 4) + 1;
            bed = new Bed(i, room, ((i % 16) % 4) + 1, false);
            bed.save();
        }
        room = new Room(3, 3, "special",2);
        room.save();
        bed = new Bed(57, room, 1, false);
        bed.save();
        bed = new Bed(58, room, 2, false);
        bed.save();
        
        room = new Room(3, 4, "special",2);
        room.save();
        bed = new Bed(59, room, 1, false);
        bed.save();
        bed = new Bed(60, room, 2, false);
        bed.save();
    }
}
