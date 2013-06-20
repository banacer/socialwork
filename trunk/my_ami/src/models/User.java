package models;

import java.sql.Date;
import javax.persistence.*;

/**
 *
 * @author Nacer Khalil
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)  
public class User extends Model{

    @Id
    @GeneratedValue
    private int id;
    
    private String firstName;
    private String lastName;
    
    @Column(unique=true)
    private String CIN;
    private Date dateOfBirth;
    

    public User()
    {
        
    }
    
    public User(String firstName, String lastName, String CIN, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CIN = CIN;
        this.dateOfBirth = dateOfBirth;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFullName()
    {
        return firstName+" "+lastName;
    }
    

}
