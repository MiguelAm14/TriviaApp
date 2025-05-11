package trv.triviaapp.ui;

import java.util.List;
import javax.swing.SwingUtilities;
import trv.triviaapp.controller.TriviaController;
import trv.triviaapp.model.Question;

/**
 * This class represents the UI for a multiple-choice question form
 * in the trivia application.
 */
public class MultipleChoiceForm extends javax.swing.JFrame {

    /** Controller that handles logic for submitting answers. */
    private TriviaController controller;

    /** The current question being displayed. */
    private Question currentQuestion;

    /**
     * Creates a new MultipleChoiceForm with the specified controller.
     * 
     * @param controller the TriviaController used to handle user actions
     */
    public MultipleChoiceForm(TriviaController controller) {
        this.controller = controller;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * Sets the current question and updates the form UI.
     * 
     * @param question the question to display
     */
    public void setQuestion(Question question) {
        this.currentQuestion = question;

        resetOptions();

        txtQuestion.setEditable(true);
        txtQuestion.setText(question.getQuestion());
        txtQuestion.setEditable(false); 

        List<String> options = question.shuffledAnswers();

        if (options.size() >= 4) {
            lblOption1.setText(options.get(0));
            lblOption2.setText(options.get(1));
            lblOption3.setText(options.get(2));
            lblOption4.setText(options.get(3));
        }
        
        int [] data = controller.getData();
        lblCounter.setText((data[0]+1) + "/" + data[1]);

        this.revalidate();
        this.repaint();
    }

    /**
     * Enables all option labels.
     */
    public void resetOptions() {
        lblOption1.setEnabled(true);
        lblOption2.setEnabled(true);
        lblOption3.setEnabled(true);
        lblOption4.setEnabled(true);
    }

    /**
     * Forces an update of the UI tree.
     */
    public void updateUI() {
        SwingUtilities.updateComponentTreeUI(this);
        this.invalidate();
        this.validate();
        this.repaint();
    }

    /**
     * Disables all option labels to prevent further clicks.
     */
    public void disableAllOptions() {
        lblOption1.setEnabled(false);
        lblOption2.setEnabled(false);
        lblOption3.setEnabled(false);
        lblOption4.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        panelOption3 = new javax.swing.JPanel();
        lblOption3 = new javax.swing.JLabel();
        panelOption2 = new javax.swing.JPanel();
        lblOption2 = new javax.swing.JLabel();
        panelOption4 = new javax.swing.JPanel();
        lblOption4 = new javax.swing.JLabel();
        panelOption1 = new javax.swing.JPanel();
        lblOption1 = new javax.swing.JLabel();
        lblCounter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(65, 0, 128));
        setUndecorated(true);

        jPanelBackground.setBackground(new java.awt.Color(65, 0, 128));
        jPanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtQuestion.setColumns(20);
        txtQuestion.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        jPanelBackground.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 540, 140));

        panelOption3.setBackground(new java.awt.Color(129, 0, 127));

        lblOption3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblOption3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOption3.setText("...");
        lblOption3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOption3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelOption3Layout = new javax.swing.GroupLayout(panelOption3);
        panelOption3.setLayout(panelOption3Layout);
        panelOption3Layout.setHorizontalGroup(
            panelOption3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOption3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        panelOption3Layout.setVerticalGroup(
            panelOption3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOption3, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        jPanelBackground.add(panelOption3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 260, 90));

        panelOption2.setBackground(new java.awt.Color(129, 0, 127));

        lblOption2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblOption2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOption2.setText("...");
        lblOption2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOption2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelOption2Layout = new javax.swing.GroupLayout(panelOption2);
        panelOption2.setLayout(panelOption2Layout);
        panelOption2Layout.setHorizontalGroup(
            panelOption2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOption2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        panelOption2Layout.setVerticalGroup(
            panelOption2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOption2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        jPanelBackground.add(panelOption2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 260, 90));

        panelOption4.setBackground(new java.awt.Color(129, 0, 127));

        lblOption4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblOption4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOption4.setText("...");
        lblOption4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOption4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelOption4Layout = new javax.swing.GroupLayout(panelOption4);
        panelOption4.setLayout(panelOption4Layout);
        panelOption4Layout.setHorizontalGroup(
            panelOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOption4, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        panelOption4Layout.setVerticalGroup(
            panelOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOption4, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        jPanelBackground.add(panelOption4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 260, 90));

        panelOption1.setBackground(new java.awt.Color(129, 0, 127));

        lblOption1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblOption1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOption1.setText("...");
        lblOption1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOption1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelOption1Layout = new javax.swing.GroupLayout(panelOption1);
        panelOption1.setLayout(panelOption1Layout);
        panelOption1Layout.setHorizontalGroup(
            panelOption1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOption1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        panelOption1Layout.setVerticalGroup(
            panelOption1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOption1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        jPanelBackground.add(panelOption1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 260, 90));

        lblCounter.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCounter.setText("../..");
        jPanelBackground.add(lblCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 50, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Mouse click event handlers that send the selected answer to the controller

    private void lblOption2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOption2MouseClicked
        controller.submitAnswer(lblOption2.getText());
        disableAllOptions();
    }//GEN-LAST:event_lblOption2MouseClicked

    private void lblOption1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOption1MouseClicked
        controller.submitAnswer(lblOption1.getText());
        disableAllOptions();
    }//GEN-LAST:event_lblOption1MouseClicked

    private void lblOption4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOption4MouseClicked
        controller.submitAnswer(lblOption4.getText());
        disableAllOptions();
    }//GEN-LAST:event_lblOption4MouseClicked

    private void lblOption3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOption3MouseClicked
        controller.submitAnswer(lblOption3.getText());
        disableAllOptions();
    }//GEN-LAST:event_lblOption3MouseClicked

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
            java.util.logging.Logger.getLogger(MultipleChoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MultipleChoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MultipleChoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MultipleChoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCounter;
    private javax.swing.JLabel lblOption1;
    private javax.swing.JLabel lblOption2;
    private javax.swing.JLabel lblOption3;
    private javax.swing.JLabel lblOption4;
    private javax.swing.JPanel panelOption1;
    private javax.swing.JPanel panelOption2;
    private javax.swing.JPanel panelOption3;
    private javax.swing.JPanel panelOption4;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}
