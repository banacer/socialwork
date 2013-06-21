/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;

import models.Diagnostic;
import models.Misc;
import models.Model;
import models.Transaction;

/**
 *
 * @author nacerkhalil
 */
public class SituationFinJournee extends javax.swing.JPanel {

    /**
     * Creates new form SituationFinJournee
     */
    private MainFrame mainFrame;
     List<Transaction> list;
    public SituationFinJournee(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        list = null;
        update();
    }

    public void update()
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for(int i = 0; i < model.getRowCount(); i++)
            model.removeRow(i);
        Date d = new Date(Calendar.getInstance().getTimeInMillis());
        Query q = Model.getEntityManager().createNamedQuery("transactions_today");
        q.setParameter("d", d);
        list = q.getResultList();
        for(Transaction tr: list)
        {
            String[] row = new String[9];
            row[0] = (new Integer(tr.getSerial())).toString();
            row[1] = tr.getPatient().getFullName();
            row[2] = tr.getpDateDentree().toString();
            row[3] = tr.getpDateSortie().toString();
            if(tr.getAccompagnateur() != null)
            {
                row[4] = tr.getAccompagnateur().getFullName();
                row[5] = tr.getaDateDentree().toString();
                row[6] = tr.getaDateSortie().toString();
            }
            else
            {
                row[4] = "";
                row[5] = "";
                row[6] = "";
            }
            row[7] = tr.getTransactionType();
            row[8] = (new Integer(tr.getSum())).toString();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial", "Patient", "Date d'entree", "Date de sortie", "Accompagnateur", "Date d'entree", "Date de sortie", "Type", "Somme"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jButton1.setText("Imprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jButton1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel18))
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(422, 422, 422)
                    .add(jLabel17)
                    .addContainerGap(422, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel18)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 535, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(283, 283, 283)
                    .add(jLabel17)
                    .addContainerGap(284, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        this.mainFrame.closeAll();
        this.mainFrame.goBack();
        this.mainFrame.reset();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("size: "+list.size());
        if(list != null && list.size() > 0)
        {
            Misc.printTransactions(list);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
