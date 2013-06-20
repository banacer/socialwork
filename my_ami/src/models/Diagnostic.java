/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Date;
import java.util.Calendar;
import javax.persistence.*;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author Nacer Khalil
 */
@Entity
public class Diagnostic extends Model{
    
    @Id
    @GeneratedValue
    private int id;
    
    private String diagnostic;
    private String MedecinTraitant;
    private Date dateDentree;
    private Date dateSortie;
    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
    public Diagnostic()
    {
        diagnostic = MedecinTraitant = "";
        dateDentree = dateSortie = new Date(Calendar.getInstance().getTimeInMillis());
        patient = null;
    }
    
    public Diagnostic(String diagnostic, String MedecinTraitant, Date dateDentree, Date DateSortie, Patient patient)
    {
        this.diagnostic = diagnostic;
        this.MedecinTraitant = MedecinTraitant;
        this.dateDentree = dateDentree;
        this.dateSortie = DateSortie;
        this.patient = patient;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the diagnostic
     */
    public String getDiagnostic() {
        return diagnostic;
    }

    /**
     * @param diagnostic the diagnostic to set
     */
    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    /**
     * @return the MedecinTraitant
     */
    public String getMedecinTraitant() {
        return MedecinTraitant;
    }

    /**
     * @param MedecinTraitant the MedecinTraitant to set
     */
    public void setMedecinTraitant(String MedecinTraitant) {
        this.MedecinTraitant = MedecinTraitant;
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
    

}
