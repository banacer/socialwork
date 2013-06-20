/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author Nacer Khalil
 */
@Entity
@NamedQueries({
@NamedQuery(name="patientByCIN",query="select p from Patient p where CIN = :cin"),
@NamedQuery(name="patientByNumPatient",query="select p from Patient p where numeroPatient = :num")
})
public class Patient extends User{
    
    private String situationFamiliale;
    private int nombreDenfants;
    private String profession;
    private String addresse;
    @Column(unique=true)
    private String numeroPatient;
    
    @OneToMany
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private List<Diagnostic> diagnostic;
    
    public Patient()
    {
        super();
    }

    public Patient(String situationFamiliale, int nombreDenfants, String profession, String addresse, String firstName, String lastName, String CIN, Date dateOfBirth) {
        super(firstName, lastName, CIN, dateOfBirth);
        this.situationFamiliale = situationFamiliale;
        this.nombreDenfants = nombreDenfants;
        this.profession = profession;
        this.addresse = addresse;
        //Generate Numero Du patient
        numeroPatient = NumeroDossier.generateNumeroDossier(lastName);
        
    }
    /**
     * @return the situationFamiliale
     */
    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    /**
     * @param situationFamiliale the situationFamiliale to set
     */
    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    /**
     * @return the nombreDenfants
     */
    public int getNombreDenfants() {
        return nombreDenfants;
    }

    /**
     * @param nombreDenfants the nombreDenfants to set
     */
    public void setNombreDenfants(int nombreDenfants) {
        this.nombreDenfants = nombreDenfants;
    }

    /**
     * @return the profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param profession the profession to set
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * @return the addresse
     */
    public String getAddresse() {
        return addresse;
    }

    /**
     * @param addresse the addresse to set
     */
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

     /**
     * @return the numeroPatient
     */
    public String getNumeroPatient() {
        return numeroPatient;
    }

    /**
     * @param numeroPatient the numeroPatient to set
     */
    public void setNumeroPatient(String numeroPatient) {
        this.numeroPatient = numeroPatient;
    }

    /**
     * @return the diagnostic
     */
    public List<Diagnostic> getDiagnostic() {
        return diagnostic;
    }
    
    
    
}
