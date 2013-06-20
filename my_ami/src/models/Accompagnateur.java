/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 *
 * @author Nacer Khalil
 */
@Entity
@NamedQueries({
@NamedQuery(name="AccompagnateurByCIN",query="select a from Accompagnateur a where CIN = :cin")
})
public class Accompagnateur extends User{

    public Accompagnateur(String firstName, String lastName, String CIN, Date dateOfBirth) {
        super(firstName, lastName, CIN, dateOfBirth);
    }

    public Accompagnateur() {
    }
    
}
