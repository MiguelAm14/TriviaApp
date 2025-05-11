package trv.triviaapp;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import trv.triviaapp.controller.TriviaController;

/**
 * The main entry point for the TriviaApp. It initializes the application's user interface 
 * and the main controller, setting up the necessary environment for the trivia game.
 */
public class TriviaApp {
    
    /**
     * The main method that serves as the entry point for the Trivia application.
     * It configures the Look and Feel of the application and starts the main controller in a 
     * separate thread to handle the logic of the trivia game.
     * 
     * @param args Command line arguments, which are not used in this application.
     */
    public static void main(String[] args) {
        // Configure the Look and Feel of the application (optional)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create and start the main controller in a separate thread
        SwingUtilities.invokeLater(() -> {
            try {
                TriviaController controller = new TriviaController();
            } catch (MalformedURLException ex) {
                Logger.getLogger(TriviaApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
