/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import javax.persistence.*;


/**
 *
 * @author Nacer Khalil
 */
@Entity

@NamedQueries
({
    
@NamedQuery(name="findBed",query="select b from Bed b where number = :b AND room.roomNum = :r AND room.floor = :f"),
//@NamedQuery(name="findAvailable",query="select b from Bed b busy = false")
        
})
public class Bed extends Model{
    
    @Id
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    
    private int number;
    
    private boolean busy;
    
    public Bed() {
    }

    public Bed(int id, Room room, int number, boolean busy) {
        this.id = id;
        this.room = room;
        this.number = number;
        this.busy = busy;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * @return the room_number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param room_number the room_number to set
     */
    public void setNumber(int room_number) {
        this.number = room_number;
    }
    
    
    
    
}
