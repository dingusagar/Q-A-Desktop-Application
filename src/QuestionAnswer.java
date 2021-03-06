
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.*;
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
public class QuestionAnswer extends javax.swing.JFrame {

    public Connection conn = null;
       public  PreparedStatement stmt = null;
    /**
     * Creates new form QuestionAnswer
     */
    public QuestionAnswer() {
        initComponents();
        connectDataBase();
        GetAllChapters();       
        jLabel3.requestFocus();
        setStopMySqlProcess();
        
        answerText.setLineWrap(true);
        answerText.setWrapStyleWord(true);
        
         questionText.setLineWrap(true);
        questionText.setWrapStyleWord(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify
     * this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chapterSelector = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        answerText = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        homeButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 650));
        getContentPane().setLayout(null);

        chapterSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Create New Chapter" }));
        chapterSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chapterSelectorActionPerformed(evt);
            }
        });
        getContentPane().add(chapterSelector);
        chapterSelector.setBounds(160, 550, 170, 27);

        questionText.setColumns(20);
        questionText.setFont(new java.awt.Font("URW Palladio L", 1, 18)); // NOI18N
        questionText.setRows(5);
        questionText.setText("Type your question here");
        questionText.setToolTipText("dingu");
        questionText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        questionText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                questionTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                questionTextFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(questionText);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 70, 840, 170);

        answerText.setColumns(20);
        answerText.setFont(new java.awt.Font("URW Palladio L", 1, 18)); // NOI18N
        answerText.setRows(5);
        answerText.setText("Type your answer here");
        answerText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        answerText.setName("textgo"); // NOI18N
        answerText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answerTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answerTextFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(answerText);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(90, 250, 840, 260);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button_add.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(710, 520, 90, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button_cancel.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(820, 520, 130, 50);

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home.png"))); // NOI18N
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
        });
        getContentPane().add(homeButton);
        homeButton.setBounds(10, 40, 70, 70);

        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel2.setText("Select Chapter");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 540, 130, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg6.jpg"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1010, 680);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:

          if(evt.getButton()== MouseEvent.BUTTON3){
             JOptionPane.showMessageDialog(this, "ADD : Add a new Question Answer \n\n", "Mr.Help", JOptionPane.INFORMATION_MESSAGE);
             return ;
        }
        
        
        String question = questionText.getText();
        String answer = answerText.getText();
        String chapter = chapterSelector.getSelectedItem().toString();
       
        
        if(question.equals("") || question.equals("Type your question here")){
            JOptionPane.showMessageDialog(this, "You left the question blank");
            return ;
        }
         if(answer.equals("") || answer.equals("Type your answer here")){
            JOptionPane.showMessageDialog(this, "You left the answer blank");
            return ;
        }
        if(chapter.equals("") || chapter.equals("Create New Chapter")){
            JOptionPane.showMessageDialog(this, "Select a valid chapter");
            return ;
        } 
        
       
        
         
        try{
             String query = "INSERT INTO QuestionAnswerTable (Question,Answer,Chapter) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(query);
            //stmt.setNull(1, java.sql.Types.INTEGER);
            stmt.setString(1, question);
            stmt.setString(2,answer);
            stmt.setString(3, chapter);
            stmt.executeUpdate();
           JOptionPane.showMessageDialog(this, "TADA !! New Question added");
           questionText.setText("");
            answerText.setText("");
        }catch(Exception se){
        //Handle errors for JDBC
         JOptionPane.showMessageDialog(this, "Insertion Failure..contact dingu");
         se.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void chapterSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chapterSelectorActionPerformed
        // TODO add your handling code here:
        if(chapterSelector.getSelectedItem().equals("Create New Chapter"))
        {
            String newChapter = null;
             newChapter = JOptionPane.showInputDialog(this, "Enter the name of the Chapter");
            if(newChapter == null)
                return ;
             if(newChapter.equals("")){
                JOptionPane.showMessageDialog(this, "Chapter Name cannot be empty");
                return ;
            }else{
            chapterSelector.addItem(newChapter);
            chapterSelector.setSelectedItem(newChapter);
            }
        }
           
            
    }//GEN-LAST:event_chapterSelectorActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
          if(evt.getButton()== MouseEvent.BUTTON3){
             JOptionPane.showMessageDialog(this, "Cancel : cancel and go back to main page.", "Mr.Help", JOptionPane.INFORMATION_MESSAGE);
             return ;
        }
        new Intro().setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void questionTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_questionTextFocusLost
        // TODO add your handling code here:
        if(questionText.getText().trim().equals(""))
        {
          questionText.setText("Type your question here");
        }
    }//GEN-LAST:event_questionTextFocusLost

    private void questionTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_questionTextFocusGained
        // TODO add your handling code here:
        if(questionText.getText().trim().equals("Type your question here"))
         questionText.setText("");
    }//GEN-LAST:event_questionTextFocusGained

    private void answerTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerTextFocusGained
        // TODO add your handling code here:
        if(answerText.getText().trim().equals("Type your answer here"))
         answerText.setText("");
    }//GEN-LAST:event_answerTextFocusGained

    private void answerTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerTextFocusLost
        // TODO add your handling code here:
          if(answerText.getText().trim().equals(""))
        {
          answerText.setText("Type your answer here");
        }
    }//GEN-LAST:event_answerTextFocusLost

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked

          if(evt.getButton()== MouseEvent.BUTTON3){
             JOptionPane.showMessageDialog(this, "Home : Go to home \n\n"                                       
                     + "Click this button to go to main Menu\n", "Mr.Help", JOptionPane.INFORMATION_MESSAGE);
             return ;
        }
        // TODO add your handling code here:
         new Intro().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeButtonMouseClicked

    public void connectDataBase()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuestionAnswerDatabase","dingusagar","dingusagar123");
           
            System.out.println("Connected !!");
        }catch(SQLException | ClassNotFoundException se){
            //Handle errors for JDBC
           JOptionPane.showMessageDialog(this, "Can't connect to database");
        }
        //Handle errors for Class.forName
        
    }
  
    
      public void GetAllChapters()
    {
        String query2 = "SELECT DISTINCT Chapter FROM QuestionAnswerTable";
       try {
           ResultSet rs = null;
           stmt = null;
           stmt = conn.prepareStatement(query2);
           rs = stmt.executeQuery();
           String item = null;
           while(rs.next()){
                item = rs.getString(1);
               System.out.println(""+item);
           chapterSelector.addItem(new String(item));
           
           }
           if(item !=null)
           chapterSelector.setSelectedItem(item);
           System.out.println("chapters updated");
          
       } catch (SQLException ex) {
           Logger.getLogger(LearnFrame.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(QuestionAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionAnswer().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea answerText;
    private javax.swing.JComboBox<String> chapterSelector;
    private javax.swing.JLabel homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea questionText;
    // End of variables declaration//GEN-END:variables
}
