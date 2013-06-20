/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RoomMgt.java
 *
 * Created on Jun 19, 2013, 7:50:16 PM
 */
package GUI;

import java.util.List;
import javax.persistence.Query;
import models.Bed;
import models.Misc;
import models.Model;
import models.Room;

/**
 *
 * @author banacer
 */
public class RoomMgt extends javax.swing.JPanel {

    /** Creates new form RoomMgt */
    public RoomMgt() {
        initComponents();
        Query query = Model.getEntityManager().createNamedQuery("getallrooms");
        List<Room> rooms = query.getResultList();
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();
        
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
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "rez de chaussez", "etage 1", "etage 2", "etage 3" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "chambre 1", "chambre 2", "chambre 3", "chambre 4" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lit 1", "lit 2", "lit 3", "lit4" }));

        jButton1.setText("Ajouter Lit");

        jButton2.setText("Supprimer Lit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(433, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        jComboBox2.removeAllItems();
        Query query = Model.getEntityManager().createNamedQuery("getallrooms");
        List<Room> rooms = query.getResultList();
        int floor = jComboBox1.getSelectedIndex();//Misc.fromFloorNametoNum((String) jComboBox1.getSelectedItem());
        for(Room r : rooms)
        {
            if(r.getFloor() == floor)
                jComboBox2.addItem(r.getRoomNum());
        }
        
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

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
        catch(Exception e)
        {
            
        }
        int floor = jComboBox1.getSelectedIndex();//Misc.fromFloorNametoNum((String) jComboBox1.getSelectedItem());
        if(room != null)
        {
            for(Bed b : room.getBeds())
            {            
                jComboBox3.addItem(b.getNumber());
            }
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    // End of variables declaration//GEN-END:variables
}
