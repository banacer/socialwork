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
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author Nacer Khalil
 */
@Entity
@NamedQueries
({
    
@NamedQuery(name="getEmptyRoomsByDate",query="select i from Sejour i where i not in (select s from Sejour s where dateDentree > :d AND :d < dateSortie)")
        
})
public class Sejour extends Model{
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    private Patient patient;
    
    @ManyToOne
    private Bed bed;
    
    private Date dateDentree;
    private Date dateSortie;
    private int nombreJours;
    private double sommePaye;
    private String observation;
    
    @ManyToOne
    private SejourAccompagnateur sejourAccompagnateur;
    

    public Sejour() {
    }

    public Sejour(Patient patient, Bed bed, Date dateDentree, Date dateSortie, double sommePaye, String observation, SejourAccompagnateur sejourAccompagnateur) {
        this.patient = patient;
        this.bed = bed;
        this.dateDentree = dateDentree;
        this.dateSortie = dateSortie;
        this.nombreJours = Misc.calculateDifference(dateDentree, dateSortie);
        this.sommePaye = sommePaye;
        this.observation = observation;
        this.sejourAccompagnateur = sejourAccompagnateur;
    }
    
    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the bed
     */
    public Bed getBed() {
        return bed;
    }

    /**
     * @param bed the bed to set
     */
    public void setBed(Bed bed) {
        this.bed = bed;
    }

    /**
     * @return the dateDentree
     */
    public Date getDateDentree() {
        return dateDentree;
    }

    /**
     * @param dateDentree the dateDentree to set
     */
    public void setDateDentree(Date dateDentree) {
        this.dateDentree = dateDentree;
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

    /**
     * @return the nombreJours
     */
    public int getNombreJours() {
        return nombreJours;
    }

    /**
     * @param nombreJours the nombreJours to set
     */
    public void setNombreJours(int nombreJours) {
        this.nombreJours = nombreJours;
    }

    /**
     * @return the sommePaye
     */
    public double getSommePaye() {
        return sommePaye;
    }

    /**
     * @param sommePaye the sommePaye to set
     */
    public void setSommePaye(double sommePaye) {
        this.sommePaye = sommePaye;
    }

    /**
     * @return the observation
     */
    public String getObservation() {
        return observation;
    }

    /**
     * @param observation the observation to set
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }

    /**
     * @return the sejourAccompagnateur
     */
    public SejourAccompagnateur getSejourAccompagnateur() {
        return sejourAccompagnateur;
    }

    /**
     * @param sejourAccompagnateur the sejourAccompagnateur to set
     */
    public void setSejourAccompagnateur(SejourAccompagnateur sejourAccompagnateur) {
        this.sejourAccompagnateur = sejourAccompagnateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        final Sejour other = (Sejour) obj;
        if (!Objects.equals(this.patient, other.patient)) {
            return false;
        }
        if (!Objects.equals(this.bed, other.bed)) {
            return false;
        }
        if (!Objects.equals(this.dateDentree, other.dateDentree)) {
            return false;
        }
        if (!Objects.equals(this.dateSortie, other.dateSortie)) {
            return false;
        }
        if (this.nombreJours != other.nombreJours) {
            return false;
        }
        if (Double.doubleToLongBits(this.sommePaye) != Double.doubleToLongBits(other.sommePaye)) {
            return false;
        }
        if (!Objects.equals(this.observation, other.observation)) {
            return false;
        }
        if (!Objects.equals(this.sejourAccompagnateur, other.sejourAccompagnateur)) {
            return false;
        }
        return true;
    }
    
    

}
