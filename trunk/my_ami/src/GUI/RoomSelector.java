/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.sound.midi.SysexMessage;
import models.*;

/**
 *
 * @author nacerkhalil
 */
public class RoomSelector extends javax.swing.JPanel {

    

    /**
     * Creates new form RoomSelector
     */
    private Patient patient;
    private Accompagnateur accompagnateur;
    private String medecinTraitant;
    private String diagnostic;
    private boolean accompagnateur_selected;  
    private MainFrame mainFrame;

    
    public RoomSelector(Patient patient, Accompagnateur accompagnateur, boolean accompagnateur_selected, String medecinTraitant, String diagnostic,MainFrame mainFrame) {
        
        initComponents();
        this.accompagnateur_selected = accompagnateur_selected;
        this.jPanel1.setVisible(false);
        this.patient = patient;
        this.accompagnateur = accompagnateur;
        this.jPanel1.setVisible(accompagnateur_selected);
        //roomList = new ArrayList<>();
        this.medecinTraitant = medecinTraitant;
        this.diagnostic = diagnostic;
        this.mainFrame = mainFrame;
        
        Query query = Model.getEntityManager().createNamedQuery("getallrooms");
        List<Room> rooms = query.getResultList();        
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();
        jComboBox4.removeAllItems();
        jComboBox5.removeAllItems();
        jComboBox6.removeAllItems();
        
        for(Room r: rooms)
        {
            boolean exist = false;
            for(int i = 0; i < jComboBox1.getItemCount(); i++)
            {
                if(jComboBox1.getItemAt(i).equals(r.getFloorName()))
                {
                    exist = true;
                    break;
                }
            }
            if(!exist)
                jComboBox1.addItem(r.getFloorName());
        }
        
        for(Room r: rooms)
        {
            boolean exist = false;
            for(int i = 0; i < jComboBox6.getItemCount(); i++)
            {
                if(jComboBox6 == null)
                    break;
                if(jComboBox6.getItemAt(i).equals(r.getFloorName()))
                {
                    exist = true;
                    break;
                }
            }
            if(!exist)
                jComboBox6.addItem(r.getFloorName());
        }
    }
    private void deployPatient(List<Sejour> l, boolean patient)
    {
        if(patient)
        {
            jComboBox1.removeAllItems();
            jComboBox2.removeAllItems();
            jComboBox3.removeAllItems();
        }
        
        else
        {
            jComboBox4.removeAllItems();
            jComboBox5.removeAllItems();
            jComboBox6.removeAllItems();
        }
        
        
        for(Sejour s : l)
        {
            int bedNumber  = s.getBed().getNumber();
            int roomNumber = s.getBed().getRoom().getRoomNum();
            String floorNumber = s.getBed().getRoom().getFloorName();
            
            if(patient)
            {
                jComboBox1.addItem(floorNumber);
                jComboBox2.addItem(roomNumber);
                jComboBox3.addItem(bedNumber);
            }
            
            else
            {
                jComboBox4.addItem(floorNumber);
                jComboBox5.addItem(roomNumber);
                jComboBox6.addItem(bedNumber);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        jLabel1.setText("Veuillez choisir la date d'enregistrement:");

        jButton1.setText("Choisir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rez de chaussez", "Premier etage", "Deuxieme etage", "troisieme etage" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel3.setText("Etage:");

        jLabel4.setText("Chambre:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chambre 1", "Chambre 2", "Chambre 3", "Chambre 4" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel5.setText("Lit:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lit 1", "Lit 2", "Lit 3", "Lit 4" }));

        jLabel6.setText("Choisir Lit pour patient");

        jLabel7.setText("Choisir Lit pour accompagnateur");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lit 1", "Lit 2", "Lit 3", "Lit 4" }));

        jLabel8.setText("Etage:");

        jLabel9.setText("Chambre:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chambre 1", "Chambre 2", "Chambre 3", "Chambre 4" }));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        jLabel10.setText("Lit:");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rez de chaussez", "Premier etage", "Deuxieme etage", "troisieme etage" }));
        jComboBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox6ItemStateChanged(evt);
            }
        });

        jLabel11.setText("Date de sortie:");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel7)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jLabel8)
                                .add(18, 18, 18)
                                .add(jComboBox6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(31, 31, 31)
                                .add(jLabel9)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 33, Short.MAX_VALUE)
                                .add(jComboBox5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel10)
                        .add(18, 18, 18)
                        .add(jComboBox4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(109, 109, 109))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel11)
                        .add(79, 79, 79)
                        .add(jDateChooser3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(379, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jLabel7)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jComboBox6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8)
                    .add(jLabel9)
                    .add(jComboBox5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10)
                    .add(jComboBox4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(30, 30, 30)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel11)
                    .add(jDateChooser3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jLabel2.setText("Date de sortie:");

        jButton2.setText("Enregistrer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(11, 11, 11)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel6)
                            .add(layout.createSequentialGroup()
                                .add(jLabel3)
                                .add(18, 18, 18)
                                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(31, 31, 31)
                                .add(jLabel4))
                            .add(layout.createSequentialGroup()
                                .add(jLabel2)
                                .add(82, 82, 82)
                                .add(jDateChooser2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(layout.createSequentialGroup()
                                .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel5))
                            .add(jDateChooser1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 172, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jComboBox3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 98, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(28, 28, 28)
                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(jLabel20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jLabel20)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 10, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(jDateChooser1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(9, 9, 9)
                                .add(jLabel1)))
                        .add(37, 37, 37)
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3)
                            .add(jLabel4)
                            .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel5)
                            .add(jComboBox3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(30, 30, 30)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jDateChooser2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(97, 97, 97))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Date dateEntree = new Date(jDateChooser1.getCalendar().getTimeInMillis());
        Date dateSortiePatient = new Date( jDateChooser2.getCalendar().getTimeInMillis());
        Date dateSortieAccompagnateur = null;
        if(accompagnateur_selected)
            dateSortieAccompagnateur = new Date(jDateChooser3.getCalendar().getTimeInMillis());
        Query q = Model.getEntityManager().createNamedQuery("findBed");
        StringTokenizer tok = null;
        Bed b = null;
        SejourAccompagnateur sejourAccompagnateur = null;
        if(accompagnateur_selected)
        {            
            int room = (Integer) jComboBox5.getSelectedItem();
            int bed = (Integer) jComboBox4.getSelectedItem();

            q.setParameter("b", bed);
            q.setParameter("r", room);
            q.setParameter("f", Misc.fromFloorNametoNum(jComboBox6.getSelectedItem().toString()));

            b = (Bed) q.getSingleResult();

            sejourAccompagnateur = new SejourAccompagnateur(accompagnateur, dateEntree, dateSortieAccompagnateur,b);
            sejourAccompagnateur.save();
        }
        
        double somme = 20 * Misc.calculateDifference(dateEntree, dateSortiePatient);
        if(accompagnateur_selected)
            somme += 20 * Misc.calculateDifference(dateEntree, dateSortieAccompagnateur);
        
        q = Model.getEntityManager().createNamedQuery("findBed");
        q.setParameter("b", Integer.parseInt(jComboBox3.getSelectedItem().toString()));
        q.setParameter("r", Integer.parseInt(jComboBox2.getSelectedItem().toString()));
        q.setParameter("f", Misc.fromFloorNametoNum(jComboBox1.getSelectedItem().toString()));
        b = (Bed) q.getSingleResult();
        
        Diagnostic d = new Diagnostic(diagnostic, medecinTraitant, dateEntree, dateSortiePatient, patient);
        d.save();
        
        Sejour sejour = new Sejour(patient, b, dateEntree, dateSortiePatient,somme , "", sejourAccompagnateur);
        sejour.save();
        
        Transaction t = new Transaction(patient, dateEntree, dateSortiePatient, accompagnateur, dateEntree, dateSortieAccompagnateur, "Normal",sejour,sejourAccompagnateur);
        t.save();
        Misc.printTransaction(t);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date d = (Date) jDateChooser1.getDate();
        javax.persistence.Query q =  Model.getEntityManager().createNamedQuery("getEmptyRoomsByDate");
        q.setParameter("date", d);
        deployPatient(q.getResultList(),true);
        deployPatient(q.getResultList(),false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

        private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
        jComboBox2.removeAllItems();
        Query query = Model.getEntityManager().createNamedQuery("getallrooms");
        List<Room> rooms = query.getResultList();
        int floor = jComboBox1.getSelectedIndex();
        //Misc.fromFloorNametoNum((String) jComboBox1.getSelectedItem());
        for (Room r : rooms) 
        {             
            if (r.getFloor() == floor) 
            {                 
                jComboBox2.addItem(r.getRoomNum());
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox6ItemStateChanged
        jComboBox5.removeAllItems();
        Query query = Model.getEntityManager().createNamedQuery("getallrooms");
        List<Room> rooms = query.getResultList();         int floor = jComboBox6.getSelectedIndex();
        //Misc.fromFloorNametoNum((String) jComboBox1.getSelectedItem());
        for (Room r : rooms)
        {             
            if (r.getFloor() == floor)
            {                 
                jComboBox5.addItem(r.getRoomNum());
            }
        }            
    }//GEN-LAST:event_jComboBox6ItemStateChanged

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
    jComboBox4.removeAllItems();
    Model.getEntityManager().clear();
    Query query = Model.getEntityManager().createNamedQuery("getroom");
    query.setParameter("f", jComboBox6.getSelectedIndex());
    query.setParameter("r", (jComboBox5.getSelectedIndex() + 1));
    Room room = null;
    try 
    {             
        room = (Room) query.getSingleResult();
    }         
    catch (Exception e) 
    {
    }
    int floor = jComboBox6.getSelectedIndex();//Misc.fromFloorNametoNum((String) jComboBox1.getSelectedItem());
    if (room != null)
    {             
        for (Bed b : room.getBeds()) 
        {                 
            jComboBox4.addItem(b.getNumber());
        }         
    } 
    
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        jComboBox3.removeAllItems();
        Query query = Model.getEntityManager().createNamedQuery("getroom"); 
        query.setParameter("f", jComboBox1.getSelectedIndex());
        query.setParameter("r", (jComboBox2.getSelectedIndex() + 1)); 
        Room room = null;
        try 
        {             
            room = (Room) query.getSingleResult();
        } 
        catch (Exception e) 
        {
        }
        int floor = jComboBox1.getSelectedIndex();//Misc.fromFloorNametoNum((String) jComboBox1.getSelectedItem());
        if (room != null) 
        {             
            for (Bed b : room.getBeds()) 
            {                 
                jComboBox3.addItem(b.getNumber());
            }         
        }     
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        this.mainFrame.closeAll();
        this.mainFrame.goBack();
        this.mainFrame.reset();
    }//GEN-LAST:event_jLabel20MouseClicked
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}