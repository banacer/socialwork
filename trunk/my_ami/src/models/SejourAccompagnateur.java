/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Nacer Khalil
 */
@Entity
public class SejourAccompagnateur extends Model{
    
    @ManyToOne
    private Accompagnateur accompagnateur;
    private Date DateDentree;
    private Date DateSortie;
    
    @ManyToOne
    private Bed bed;
    
    @Id
    @GeneratedValue
    private int id;

    public SejourAccompagnateur() {
    }

    public SejourAccompagnateur(Accompagnateur accompagnateur, Date DateDentree, Date DateSortie, Bed bed) {
        this.accompagnateur = accompagnateur;
        this.DateDentree = DateDentree;
        this.DateSortie = DateSortie;
        this.bed = bed;
    }

    public Date getDateDentree() {
        return DateDentree;
    }

    public void setDateDentree(Date DateDentree) {
        this.DateDentree = DateDentree;
    }

    public Date getDateSortie() {
        return DateSortie;
    }

    public void setDateSortie(Date DateSortie) {
        this.DateSortie = DateSortie;
    }

    public Accompagnateur getAccompagnateur() {
        return accompagnateur;
    }

    public void setAccompagnateur(Accompagnateur accompagnateur) {
        this.accompagnateur = accompagnateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the bed
     */
    public Bed getBed() {
        return bed;
    }
    
    
}
