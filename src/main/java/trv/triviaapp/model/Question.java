package trv.triviaapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Represents a trivia question with its type, difficulty, category, 
 * correct answer, and a list of incorrect answers. This class provides 
 * methods to manage the question and its answers, including checking if 
 * an answer is correct and shuffling the answers for display.
 */
public class Question {
    private String type;
    private String difficulty;
    private String category;
    private String question;
    private String correct_answer;
    private String [] incorrect_answers;

    /**
     * Default constructor for creating an empty Question object.
     */
    public Question() {
    } 

    /**
     * Constructs a Question with the specified parameters.
     * 
     * @param type The type of the question (e.g., multiple choice, true/false).
     * @param difficulty The difficulty level of the question (e.g., easy, medium, hard).
     * @param category The category of the question (e.g., Science, History).
     * @param question The actual question text.
     * @param correct_answer The correct answer to the question.
     * @param incorrect_answers An array of incorrect answers.
     */
    public Question(String type, String difficulty, String category, String question, String correct_answer, String[] incorrect_answers) {
        this.type = type;
        this.difficulty = difficulty;
        this.category = category;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }

    /**
     * Returns the type of the question.
     * 
     * @return The type of the question (e.g., "multiple", "Boolean").
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the difficulty level of the question.
     * 
     * @return The difficulty of the question (e.g., "easy", "medium", "hard").
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Returns the category of the question.
     * 
     * @return The category of the question (e.g., "Science", "History").
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the question text after unescaping any HTML entities.
     * 
     * @return The unescaped question text.
     */
    public String getQuestion() {
        return StringEscapeUtils.unescapeHtml4(question);
    }

    /**
     * Returns the correct answer to the question after unescaping any HTML entities.
     * 
     * @return The unescaped correct answer.
     */
    public String getCorrectAnsw() {
        return StringEscapeUtils.unescapeHtml4(correct_answer);
    }

    /**
     * Returns the array of incorrect answers, with each answer unescaped from HTML entities.
     * 
     * @return An array of unescaped incorrect answers.
     */
    public String[] getIncorrectAnsw() {
        for(int i=0; i < incorrect_answers.length; i++) {
            incorrect_answers[i] = StringEscapeUtils.unescapeHtml4(incorrect_answers[i]);
        }
        
        return incorrect_answers;
    }

    /**
     * Returns a string representation of the Question object.
     * 
     * @return A string representing the Question object with all its attributes.
     */
    @Override
    public String toString() {
        return "Question{" + "type=" + type + ", difficulty=" + difficulty + ", category=" + category + ", question=" + question + ", correctAnsw=" + correct_answer + ", incorrectAnsw=" + incorrect_answers + '}';
    }
    
    /**
     * Determines if the question is of type "multiple choice".
     * 
     * @return true if the question is multiple choice, false otherwise.
     */
    public boolean isMultipleChoice() {
        return type.equals("multiple");
    }
    
    /**
     * Checks if the given answer matches the correct answer.
     * 
     * @param userAnswer The answer provided by the user.
     * @return true if the answer is correct, false otherwise.
     */
    public boolean checkAnswer(String userAnswer) {
        return getCorrectAnsw().equalsIgnoreCase(userAnswer);
    }
    
    /**
     * Shuffles the answers (both correct and incorrect) and returns them as a list.
     * This method ensures the order of the answers is random for each game.
     * 
     * @return A shuffled list of answers, including the correct and incorrect ones.
     */
    public List<String> shuffledAnswers() {
        List<String> options = new ArrayList<>();
        options.add(this.getCorrectAnsw());
        String[] incorrect = this.getIncorrectAnsw();
        
        options.addAll(Arrays.asList(incorrect));
        
        Collections.shuffle(options);
        
        return options;
    }
}
