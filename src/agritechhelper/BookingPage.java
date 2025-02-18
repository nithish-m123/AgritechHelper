/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package agritechhelper;

import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author mekal
 */
public class BookingPage extends javax.swing.JFrame {
    DataResource dr=new DataResource();
    /**
     * Creates new form BookingPage
     */
    public BookingPage() {
        initComponents();
        slot1.setBackground(Color.white);
        slot2.setBackground(Color.white);
        slot3.setBackground(Color.white);
        slot4.setBackground(Color.white);
        slot5.setBackground(Color.white);
        slot6.setBackground(Color.white);
        slot7.setBackground(Color.white);
        slot8.setBackground(Color.white);
        slot9.setBackground(Color.white);
        String email=Session.getSharedData();
        String name=dr.getName(email);
        if(name==null)
        {
            JOptionPane.showMessageDialog(null,"SomeThing went wrong try logout and login again..");
        }
        else
        {
            names.setText(name);
        }
        Tractor tr;
        tr=dr.getTractorOwner(Booking.getId());
        if(tr==null)
        {
            JOptionPane.showMessageDialog(null,"SomeThing went wrong .. please try again..");
            new TractorBookingPage().setVisible(true);
            dispose();
        }
        else
        {
            tractorname.setText(tr.getTractorName());
            ownerName.setText(dr.getName(email));
            equip.setText(tr.getEquipmentList());
        }
        Slots s;
        int id=dr.getTractorId(tr.getTractorName());
        if(id==-1)
        {
            JOptionPane.showMessageDialog(null,"please start again");
            new TractorBookingPage().setVisible(true);
            dispose();
        }
        LocalDate today = LocalDate.now();
        Date date = Date.valueOf(today);
        s=dr.getSlots(id, date);
        if(s==null)
        {
            JOptionPane.showMessageDialog(null,"No Slots");
            new TractorBookingPage().setVisible(true);
            dispose();
        }
        else
        {
            if(s.getSlot1()==true)
                slot1.setBackground(Color.green);
            if(s.getSlot2()==true)
                slot2.setBackground(Color.green);
            if(s.getSlot3()==true)
                slot3.setBackground(Color.green);
            if(s.getSlot4()==true)
                slot4.setBackground(Color.green);
            if(s.getSlot5()==true)
                slot5.setBackground(Color.green);
            if(s.getSlot6()==true)
                slot6.setBackground(Color.green);
            if(s.getSlot7()==true)
                slot7.setBackground(Color.green);
            if(s.getSlot8()==true)
                slot8.setBackground(Color.green);
            if(s.getSlot9()==true)
                slot9.setBackground(Color.green);
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

        jButton1 = new javax.swing.JButton();
        names = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tractorname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ownerName = new javax.swing.JTextField();
        equip = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        slot1 = new javax.swing.JButton();
        slot2 = new javax.swing.JButton();
        slot3 = new javax.swing.JButton();
        slot4 = new javax.swing.JButton();
        slot5 = new javax.swing.JButton();
        slot7 = new javax.swing.JButton();
        slot6 = new javax.swing.JButton();
        slot8 = new javax.swing.JButton();
        slot9 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));
        getContentPane().add(names, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 84, 26));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tractor Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 110, 30));

        tractorname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tractornameActionPerformed(evt);
            }
        });
        getContentPane().add(tractorname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 160, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Owner Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        ownerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownerNameActionPerformed(evt);
            }
        });
        getContentPane().add(ownerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 160, 30));

        equip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipActionPerformed(evt);
            }
        });
        getContentPane().add(equip, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 140, 60));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Equipment List");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jButton2.setText("Book Slots");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 160, 40));

        slot1.setText("5:30 to  6:30");
        slot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot1ActionPerformed(evt);
            }
        });
        getContentPane().add(slot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 100, 40));

        slot2.setText("7:00 to 8:00");
        slot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot2ActionPerformed(evt);
            }
        });
        getContentPane().add(slot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 100, 40));

        slot3.setText("8:30  to  9:30");
        slot3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot3ActionPerformed(evt);
            }
        });
        getContentPane().add(slot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 100, 40));

        slot4.setText("10:30 to11:30");
        slot4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot4ActionPerformed(evt);
            }
        });
        getContentPane().add(slot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 100, 40));

        slot5.setText("12:00to13:00 ");
        slot5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot5ActionPerformed(evt);
            }
        });
        getContentPane().add(slot5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 100, 40));

        slot7.setText("15:00to16:00");
        slot7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot7ActionPerformed(evt);
            }
        });
        getContentPane().add(slot7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 100, 40));

        slot6.setText("13:30to14:30");
        slot6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot6ActionPerformed(evt);
            }
        });
        getContentPane().add(slot6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 100, 40));

        slot8.setText("16:30to17:30");
        slot8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot8ActionPerformed(evt);
            }
        });
        getContentPane().add(slot8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 100, 40));

        slot9.setText("18:00to19:00");
        slot9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot9ActionPerformed(evt);
            }
        });
        getContentPane().add(slot9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 100, 40));

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agritechhelper/bookingpage.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Session.clearSession();
        new UserSelectionPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tractornameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tractornameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tractornameActionPerformed

    private void ownerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ownerNameActionPerformed

    private void equipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equipActionPerformed

    private void slot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot2ActionPerformed
        if(slot2.getBackground()==Color.green)
        {
            JOptionPane.showMessageDialog(null,"This slot is already booked");
        }
        else if(slot2.getBackground()==Color.white)
        {
            slot2.setBackground(Color.red);
        }
        else if(slot2.getBackground()==Color.red)
        {
            slot2.setBackground(Color.white);
        }
    }//GEN-LAST:event_slot2ActionPerformed

    private void slot6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot6ActionPerformed
        if(slot6.getBackground()==Color.green)
        {
            JOptionPane.showMessageDialog(null,"This slot is already booked");
        }
        else if(slot6.getBackground()==Color.white)
        {
            slot6.setBackground(Color.red);
        }
        else if(slot6.getBackground()==Color.red)
        {
            slot6.setBackground(Color.white);
        }
    }//GEN-LAST:event_slot6ActionPerformed

    private void slot7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot7ActionPerformed
        if(slot7.getBackground()==Color.green)
        {
            JOptionPane.showMessageDialog(null,"This slot is already booked");
        }
        else if(slot7.getBackground()==Color.white)
        {
            slot7.setBackground(Color.red);
        }
        else if(slot7.getBackground()==Color.red)
        {
            slot7.setBackground(Color.white);
        }
    }//GEN-LAST:event_slot7ActionPerformed

    private void slot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot1ActionPerformed
        if(slot1.getBackground()==Color.green)
        {
            JOptionPane.showMessageDialog(null,"This slot is already booked");
        }
        else if(slot1.getBackground()==Color.white)
        {
            slot1.setBackground(Color.red);
        }
        else if(slot1.getBackground()==Color.red)
        {
            slot1.setBackground(Color.white);
        }
    }//GEN-LAST:event_slot1ActionPerformed

    private void slot5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot5ActionPerformed
        if(slot5.getBackground()==Color.green)
        {
            JOptionPane.showMessageDialog(null,"This slot is already booked");
        }
        else if(slot5.getBackground()==Color.white)
        {
            slot5.setBackground(Color.red);
        }
        else if(slot5.getBackground()==Color.red)
        {
            slot5.setBackground(Color.white);
        }
    }//GEN-LAST:event_slot5ActionPerformed

    private void slot9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot9ActionPerformed
        if(slot9.getBackground()==Color.green)
        {
            JOptionPane.showMessageDialog(null,"This slot is already booked");
        }
        else if(slot9.getBackground()==Color.white)
        {
            slot9.setBackground(Color.red);
        }
        else if(slot9.getBackground()==Color.red)
        {
            slot9.setBackground(Color.white);
        }
    }//GEN-LAST:event_slot9ActionPerformed

    private void slot3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot3ActionPerformed
        if(slot3.getBackground()==Color.green)
        {
            JOptionPane.showMessageDialog(null,"This slot is already booked");
        }
        else if(slot3.getBackground()==Color.white)
        {
            slot3.setBackground(Color.red);
        }
        else if(slot3.getBackground()==Color.red)
        {
            slot3.setBackground(Color.white);
        }
    }//GEN-LAST:event_slot3ActionPerformed

    private void slot4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot4ActionPerformed
        if(slot4.getBackground()==Color.green)
        {
            JOptionPane.showMessageDialog(null,"This slot is already booked");
        }
        else if(slot4.getBackground()==Color.white)
        {
            slot4.setBackground(Color.red);
        }
        else if(slot4.getBackground()==Color.red)
        {
            slot4.setBackground(Color.white);
        }
    }//GEN-LAST:event_slot4ActionPerformed

    private void slot8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot8ActionPerformed
        if(slot8.getBackground()==Color.green)
        {
            JOptionPane.showMessageDialog(null,"This slot is already booked");
        }
        else if(slot8.getBackground()==Color.white)
        {
            slot8.setBackground(Color.red);
        }
        else if(slot8.getBackground()==Color.red)
        {
            slot8.setBackground(Color.white);
        }
    }//GEN-LAST:event_slot8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String slots="";
        if(slot1.getBackground()==Color.red)
        {
            slots=slots+"slot1,";
        }
        if(slot2.getBackground()==Color.red)
        {
            slots=slots+"slot2,";
        }
        if(slot3.getBackground()==Color.red)
        {
            slots=slots+"slot3,";
        }
        if(slot4.getBackground()==Color.red)
        {
            slots=slots+"slot4,";
        }
        if(slot5.getBackground()==Color.red)
        {
            slots=slots+"slot5,";
        }
        if(slot6.getBackground()==Color.red)
        {
            slots=slots+"slot6,";
        }
        if(slot7.getBackground()==Color.red)
        {
            slots=slots+"slot7,";
        }
        if(slot8.getBackground()==Color.red)
        {
            slots=slots+"slot8,";
        }
        if(slot9.getBackground()==Color.red)
        {
            slots=slots+"slot9,";
        }
        if(slots.equals(""))
        {
            JOptionPane.showMessageDialog(null,"You have selected no slots..");
        }
        else
        {
            int Tid=dr.getTractorId(tractorname.getText());
            LocalDate today = LocalDate.now();
            Date date = Date.valueOf(today);
            int FId=dr.getFarmerId(names.getText());
            if(FId==-1)
            {
                JOptionPane.showMessageDialog(null,"SomeThing went wrong Please Try againg..");
                new BookingPage().setVisible(true);
            }
            else
            {
            if(dr.BookSlots(slots,Tid,date))
            {
                dr.booking(slots,Tid,FId,date);
                JOptionPane.showMessageDialog(null,"Booked Successfully for the "+slots);
                Booking.closeBooking();
                new FarmerInterFace().setVisible(true);
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"SomeThing went wrong Please Try againg..");
                new BookingPage().setVisible(true);
                dispose();
            }
            }
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       new TractorBookingPage().setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField equip;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel names;
    private javax.swing.JTextField ownerName;
    private javax.swing.JButton slot1;
    private javax.swing.JButton slot2;
    private javax.swing.JButton slot3;
    private javax.swing.JButton slot4;
    private javax.swing.JButton slot5;
    private javax.swing.JButton slot6;
    private javax.swing.JButton slot7;
    private javax.swing.JButton slot8;
    private javax.swing.JButton slot9;
    private javax.swing.JTextField tractorname;
    // End of variables declaration//GEN-END:variables
}
