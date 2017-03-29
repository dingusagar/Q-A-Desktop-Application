
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dingu
 */
public class Intro_1 extends javax.swing.JFrame {

    /**
     * Creates new form Intro
     */
    public Intro_1() {
        initComponents();
        startMySqlProcess();
        setStopMySqlProcess();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        welcomeText = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));
        getContentPane().setLayout(null);

        jLabel5.setText("Right click on a  Button and Mr.Help will reach you.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(340, 210, 370, 70);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qa.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 20, 520, 240);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button_learn (1).png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 410, 210, 90);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button_update.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 410, 260, 90);

        welcomeText.setFont(new java.awt.Font("URW Palladio L", 3, 36)); // NOI18N
        welcomeText.setText("Your Personal Question Answer Bank");
        getContentPane().add(welcomeText);
        welcomeText.setBounds(180, 270, 690, 130);

        jLabel6.setText("dingusagar@gmail.com");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 570, 220, 40);

        jLabel7.setText("___DinSoftwares___");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(420, 550, 220, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg6.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 660);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
                // TODO add your handling code here:
        
        new QuestionAnswer().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        new LearnFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        welcomeText.setText("Start Learning Questions. Make Edits !");
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        welcomeText.setText("Your Personal Question Answer Bank");
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
         welcomeText.setText("Your Personal Question Answer Bank");
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
         welcomeText.setText("Add new Questions , Answers , Chapters !");
    }//GEN-LAST:event_jLabel4MouseEntered

    
    public void startMySqlProcess()
    {
        String command = "C:\\xampp\\mysql_start.bat";
        try{
             welcomeText.setText("Loading Database Files...Please wait !");   
             Process process = Runtime.getRuntime().exec(command);
             process.waitFor(6, TimeUnit.SECONDS);
             welcomeText.setText("Your Personal Question Answer Bank");
        }
        catch (IOException e)
        {    e.printStackTrace();
             JOptionPane.showMessageDialog(this,"Database could not load ");
        } catch (InterruptedException ex) {
            Logger.getLogger(Intro_1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Database could not load ");
        }
    }  
    
    public void setStopMySqlProcess()
    {
       
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
        @Override
            public void windowClosing(WindowEvent event)
            {
               stopMySql();
               System.exit(0);
            }
         });
        
    }
    public void stopMySql()
    {
         String command = "C:\\xampp\\mysql_stop.bat";
        try{              
                 Process process = Runtime.getRuntime().exec(command);
                 process.waitFor(6, TimeUnit.SECONDS);
                 
                 }
                catch (IOException e)
                {    e.printStackTrace();
                     JOptionPane.showMessageDialog(this,"Database could not load ");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Intro_1.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this,"Database could not load ");
                }
    }
    
    
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
            java.util.logging.Logger.getLogger(Intro_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Intro_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Intro_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Intro_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Intro_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
