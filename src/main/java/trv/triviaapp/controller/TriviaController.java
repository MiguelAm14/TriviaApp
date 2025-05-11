package trv.triviaapp.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import trv.triviaapp.api.TriviaApi;
import trv.triviaapp.model.Question;
import trv.triviaapp.model.QuestionSet;
import trv.triviaapp.ui.MainForm;
import trv.triviaapp.ui.MultipleChoiceForm;
import trv.triviaapp.ui.TrueFalseForm;

/**
 * Controller for managing the trivia game logic.
 * This controller handles fetching questions, starting a new game,
 * navigating through questions, and submitting answers.
 */
public class TriviaController {
    private TriviaApi api;
    private QuestionSet questionSet;
    private MainForm mainForm;
    private MultipleChoiceForm mcForm;
    private TrueFalseForm tfForm;
    private int count;    
    /**
     * Constructor that initializes the TriviaController and the required UI forms.
     * It connects to the trivia API and prepares the UI for interaction.
     * 
     * @throws MalformedURLException if the URL for the API is malformed
     */
    public TriviaController() throws MalformedURLException {
        System.out.println("Initializing TriviaController");
        try {
            this.api = new TriviaApi();
            mainForm = new MainForm(this);
            mcForm = new MultipleChoiceForm(this);
            tfForm = new TrueFalseForm(this);
            // Set the location of the forms to center on the screen
            mainForm.setLocationRelativeTo(null);
            mcForm.setLocationRelativeTo(null);
            tfForm.setLocationRelativeTo(null);
            
            mainForm.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }      
    }
    
    /**
     * Fetches trivia questions from the API and stores them in the question set.
     * 
     * @throws IOException if an error occurs while making the API request or parsing the response
     */
    public void getQuestions() throws IOException {
        api = new TriviaApi();
        int cnn = api.connect();
        
        if (cnn == 200) {
            String json = api.getJSON();
            System.out.println(json);
                
            Gson gson = new Gson();
            questionSet = gson.fromJson(json, QuestionSet.class);
            count = 0;
        } else {
            System.out.println("Error " + cnn);
        }
    }
    
    /**
     * Starts a new game by fetching trivia questions and displaying the first question.
     * 
     * @throws IOException if an error occurs while fetching the questions
     */
    public void startNewGame() throws IOException {        
        try {
            getQuestions();
            
            if (questionSet != null && questionSet.getQuestions() != null && !questionSet.getQuestions().isEmpty()) {
                questionSet.setQuestionIndex(0);
                
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            nextQuestion();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(mainForm, "Error: " + e.getMessage(),
                                    "Error", JOptionPane.ERROR_MESSAGE);     
                        }
                    }
                });
            } else {
                JOptionPane.showMessageDialog(mainForm, "Failed to load questions", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Error starting new game: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }    
    
    /**
     * Displays the next question in the trivia game.
     * Depending on the type of question (multiple choice or true/false),
     * the appropriate form is displayed.
     */
    public void nextQuestion() {        
        try {
            if(questionSet != null && questionSet.hasMoreQuestions()) {
                Question next = questionSet.getCurrentQuestion();
                
                // Hide both forms initially
                mcForm.setVisible(false);
                tfForm.setVisible(false);
                
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Show the appropriate form based on the question type
                            if(next.isMultipleChoice()) {
                                mcForm.setQuestion(next);
                                mcForm.repaint();
                                mcForm.revalidate();
                                mcForm.setVisible(true);
                            } else {
                                tfForm.setQuestion(next);
                                tfForm.repaint();
                                tfForm.revalidate();
                                tfForm.setVisible(true);
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                });
            } else {
                mcForm.setVisible(false);
                tfForm.setVisible(false);
                
                JOptionPane.showMessageDialog(null, "End of Game! You did " + count + "/" + questionSet.getSize());
                
                // Display the main form after the game ends
                mainForm.setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Error: " + e.getMessage(), 
                                         "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    /**
     * Displays the current question index, and the number of questions.
     * [index,N°questions]
     * @return An int array containing the current index and number of questions.
     */    
    public int [] getData() {
        int [] data = new int[2];
        data[0] = questionSet.getQuestionIndex();
        data[1] = questionSet.getSize();

        return data;
    }
    
    /**
     * Submits the player's answer to the current question and checks if it is correct.
     * If correct, a success message is shown, otherwise the correct answer is displayed.
     * After answering, the next question is shown.
     * 
     * @param answer The player's answer to the current question
     */
    public void submitAnswer(String answer) {
        boolean isCorrect = questionSet.answer(answer);
        Question currentQuestion = questionSet.getCurrentQuestion();        
        if (isCorrect) {
            System.out.println("Correct");
            count++;
        } else
            System.out.println("Incorrect");
        
        String message = isCorrect ? "Correct!" : "Incorrect. The correct answer was: " + currentQuestion.getCorrectAnsw();

        JOptionPane.showMessageDialog(
                currentQuestion.isMultipleChoice() ? mcForm : tfForm,
                message,
                "Result",
                isCorrect ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE
        );        
        
        // If there are more questions, move to the next one
        if(questionSet.hasMoreQuestions()) {
            questionSet.nextQuestion(); 
            nextQuestion();
        }
    }
    
}
