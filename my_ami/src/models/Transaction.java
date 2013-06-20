/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.*;

/**
 *
 * @author Nacer Khalil
 */


@NamedQueries({
@NamedQuery(name="my_transaction", query="select t from Transaction t where pDateDentree >= :d"),
@NamedQuery(name="transactions_today",query="select t from Transaction t where pDateDentree >= :d")      
})

@Entity
public class Transaction extends Model{
    
    @Id
    @GeneratedValue
    int id;
    private int serial;
    @ManyToOne
    private Patient patient;
    private Date pDateDentree;
    private Date pDateSortie;
    @ManyToOne
    private Accompagnateur accompagnateur;
    private Date aDateDentree;
    private Date aDateSortie;
    private String transactionType; //Normal or Annulation
    private int somme;
    @OneToOne
    private Sejour sejour;
    @OneToOne
    private SejourAccompagnateur sejourAccompagnateur;

    public Transaction() {
    }

    public Transaction(Patient patient, Date pDateDentree, Date pDateSortie,
            Accompagnateur accompagnateur, Date aDateDentree, Date aDateSortie,
            String transactionType, Sejour sejour, SejourAccompagnateur sejourAccompagnateur) {
        Calendar c = new GregorianCalendar(1989, 6, 5);
        c.add(Calendar.MONTH, -1);
        Date begYear = new Date(c.getTimeInMillis());
        Query q = Model.getEntityManager().createNamedQuery("my_transaction");
        q.setParameter("d", begYear);
        this.serial = q.getResultList().size();
        this.serial++;
        this.patient = patient;
        this.pDateDentree = pDateDentree;
        this.pDateSortie = pDateSortie;
        this.accompagnateur = accompagnateur;
        this.aDateDentree = aDateDentree;
        this.aDateSortie = aDateSortie;
        this.transactionType = transactionType;
        this.somme = 20 * Misc.calculateDifference(pDateDentree, pDateSortie);
        if(aDateDentree != null && aDateSortie != null)
            this.somme += 20 * Misc.calculateDifference(aDateDentree, aDateSortie);
        this.sejour = sejour;
        this.sejourAccompagnateur = sejourAccompagnateur;
    }

    public Date getaDateDentree() {
        return aDateDentree;
    }

    public void setaDateDentree(Date aDateDentree) {
        this.aDateDentree = aDateDentree;
    }

    public Date getaDateSortie() {
        return aDateSortie;
    }

    public void setaDateSortie(Date aDateSortie) {
        this.aDateSortie = aDateSortie;
    }

    public Accompagnateur getAccompagnateur() {
        return accompagnateur;
    }

    public void setAccompagnateur(Accompagnateur accompagnateur) {
        this.accompagnateur = accompagnateur;
    }

    public Date getpDateDentree() {
        return pDateDentree;
    }

    public void setpDateDentree(Date pDateDentree) {
        this.pDateDentree = pDateDentree;
    }

    public Date getpDateSortie() {
        return pDateSortie;
    }

    public void setpDateSortie(Date pDateSortie) {
        this.pDateSortie = pDateSortie;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getSum() {
        return getSomme();
    }

    /**
     * @return the somme
     */
    public int getSomme() {
        return somme;
    }

    /**
     * @return the sejour
     */
    public Sejour getSejour() {
        return sejour;
    }

    /**
     * @return the sejourAccompagnateur
     */
    public SejourAccompagnateur getSejourAccompagnateur() {
        return sejourAccompagnateur;
    }
    
}
