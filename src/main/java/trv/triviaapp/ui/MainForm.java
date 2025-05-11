package trv.triviaapp.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import trv.triviaapp.controller.TriviaController;

/**
 * The MainForm class represents the main user interface of the Trivia application.
 * It displays the main screen, allowing users to start a new game or exit the application.
 */
public class MainForm extends javax.swing.JFrame {
    private TriviaController controller;

    /**
     * Constructs a new MainForm.
     * Initializes the form components and sets up the TriviaController.
     * 
     * @param controller The controller used to manage the trivia game logic.
     */
    public MainForm(TriviaController controller) {
        this.controller = controller;
        initComponents();
    }
    
    /**
     * Initializes the form's components (buttons, labels, panels, etc.).
     * This method is automatically called during the construction of the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelPlay = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelBackground.setBackground(new java.awt.Color(129, 0, 127));
        jPanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Henny Penny", 1, 96)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(65, 0, 128));
        jLabel1.setText("TRIVIA TIME!");
        jPanelBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        panelPlay.setBackground(new java.awt.Color(129, 0, 64));
        panelPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPlayMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Henny Penny", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Play");

        javax.swing.GroupLayout panelPlayLayout = new javax.swing.GroupLayout(panelPlay);
        panelPlay.setLayout(panelPlayLayout);
        panelPlayLayout.setHorizontalGroup(
            panelPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        panelPlayLayout.setVerticalGroup(
            panelPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPlayLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelBackground.add(panelPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 410, 90));

        lblExit.setFont(new java.awt.Font("Henny Penny", 0, 36)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setText("Exit");
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        jPanelBackground.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 70, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Called when the 'Exit' label is clicked.
     * Exits the application when triggered.
     */
    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

    /**
     * Called when the 'Play' panel is clicked.
     * Starts a new trivia game by invoking the controller's method to begin the game.
     */    
    private void panelPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPlayMouseClicked
        try {
            controller.startNewGame();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_panelPlayMouseClicked

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JLabel lblExit;
    private javax.swing.JPanel panelPlay;
    // End of variables declaration//GEN-END:variables
}
