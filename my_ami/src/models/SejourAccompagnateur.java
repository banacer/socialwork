/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Date;
import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SejourAccompagnateur other = (SejourAccompagnateur) obj;
        if (!Objects.equals(this.accompagnateur, other.accompagnateur)) {
            return false;
        }
        if (!Objects.equals(this.DateDentree, other.DateDentree)) {
            return false;
        }
        if (!Objects.equals(this.DateSortie, other.DateSortie)) {
            return false;
        }
        if (!Objects.equals(this.bed, other.bed)) {
            return false;
        }
        return true;
    }
    
    
}
