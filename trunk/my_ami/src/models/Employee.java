/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Date;
import javax.persistence.Entity;

/**
 *
 * @author Nacer Khalil
 */
@Entity

public class Employee extends User{
    private String password;
    private Date dateDentre;
    private Date dateSortie;
    
    public Employee()
    {
        super();
    }

    public Employee(String password,Date dateDentre, Date dateSortie, String firstName, String lastName, String CIN, Date dateOfBirth) {
        super(firstName, lastName, CIN, dateOfBirth);
        this.password = password;
        this.dateDentre = dateDentre;
        this.dateSortie = dateSortie;
    }

    /**
     * @return the dateDentre
     */
    public Date getDateDentre() {
        return dateDentre;
    }

    /**
     * @param dateDentre the dateDentre to set
     */
    public void setDateDentre(Date dateDentre) {
        this.dateDentre = dateDentre;
    }

    /**
     * @return the dateSortie
     */
    public Date getDateSortie() {
        return dateSortie;
    }

    /**
     * @param dateSortie the dateSortie to set
     */
    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

}
