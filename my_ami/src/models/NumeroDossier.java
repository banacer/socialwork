/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author Nacer Khalil
 */
@Entity
@NamedQueries
({
@NamedQuery(name="FindNumeroDossier", query="select n from NumeroDossier n where year= :year and c= :c")
})

public class NumeroDossier extends Model{
    
    @Id
    @GeneratedValue
    private int id;
    
    private int number;
    private int year;
    private char c;
    

    public NumeroDossier() {
        super();
    }

    public NumeroDossier(int number, int year, char c) {
        super();
        this.number = number;
        this.year = year;
        this.c = c;
    }
    
    public static String generateNumeroDossier(String lastName)
    {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Query q = Model.getEntityManager().createNamedQuery("FindNumeroDossier");
        q.setParameter("year", year);
        q.setParameter("c", lastName.charAt(0));
        NumeroDossier n = null;
        try
        {
            n = (NumeroDossier) q.getSingleResult();
        }
        catch(Exception e)
        {
            
        }
        if(n == null)
        {
            n = new NumeroDossier(1, year,lastName.charAt(0));
            n.save();
        }
        String numero = n.getNumber()+"\\"+n.getYear()+"\\"+n.getC();
        //update numeroDossier
        //EntityManager em = em();
        //em.getTransaction().begin();
        n.setNumber(n.getNumber() + 1);
        //em.getTransaction().commit();
	//em.close();
        
        return numero;
    }
    public static String previewNumeroDossier(String lastName)
    {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Query q = Model.getEntityManager().createNamedQuery("FindNumeroDossier");
        q.setParameter("year", year);
        q.setParameter("c", lastName.charAt(0));
        NumeroDossier n = null;
        try
        {
            n = (NumeroDossier) q.getSingleResult();
        }
        catch(Exception e)
        {
            
        }
        if(n == null)
        {
            n = new NumeroDossier(1, year,lastName.charAt(0));
        }
        String numero = n.getNumber()+"\\"+n.getYear()+"\\"+n.getC();
        return numero;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the c
     */
    public char getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(char c) {
        this.c = c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
