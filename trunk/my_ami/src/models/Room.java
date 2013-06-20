/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Nacer Khalil
 */
@Entity
@NamedQueries({
@NamedQuery(name="getallrooms",query="select r from Room r"),
@NamedQuery(name="getroom",query="select r from Room r where floor =:f and roomNum= :r"),
})
public class Room extends Model{
    
    @Id
    @GeneratedValue
    private int id;
    
    private int floor;
    private int roomNum;
    
    private String roomType; // standard, special
    
    @OneToMany
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    List<Bed> beds;
    private int freeBeds;

    public Room() {
    }
    

    public Room(int floor, int roomNum, String roomType) throws Exception {
        this.floor = floor;
        this.roomNum = roomNum;
        this.roomType = roomType;
        if(beds == null)
            freeBeds = 0;
        else
            this.freeBeds = beds.size();
        
        if(freeBeds == 0)
        {
            int count = 0;
            if(this.roomType.equalsIgnoreCase("standard"))
                count = 4;
            else if(this.roomType.equalsIgnoreCase("special"))
                count = 2;
            else
                throw new Exception("room type invalid");
        }
    }
    
    public Room(int floor, int roomNum, String roomType, int freeBeds) throws Exception {
        this.floor = floor;
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.freeBeds = freeBeds;
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFreeBeds() {
        return freeBeds;
    }

    public void setFreeBeds(int freeBeds) {
        this.freeBeds = freeBeds;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFloorName()
    {
        switch(floor)
        {
            case 0:
                return "rez de chaussée";
            
            default:
                return "Etage "+floor;
        }
    }
    
    
}
