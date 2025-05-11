package trv.triviaapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of trivia questions. It manages a collection of questions, keeps track of the 
 * current question, and provides methods to navigate through and answer questions.
 */
public class QuestionSet {
    private int response_code;
    private List<Question> results;
    private int questionIndex = 0;

    /**
     * Default constructor for creating a QuestionSet object. Initializes the list of questions.
     */
    public QuestionSet() {
        this.results = new ArrayList<>();
    }

    /**
     * Returns the response code associated with the question set.
     * 
     * @return The response code (typically used to check if the API request was successful).
     */
    public int getResponseCode() {
        return response_code;
    }

    /**
     * Returns the current index of the question being displayed.
     * 
     * @return The index of the current question.
     */
    public int getQuestionIndex() {
        return questionIndex;
    }

    /**
     * Sets the current index of the question.
     * 
     * @param questionIndex The index to set for the current question.
     */
    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }    
    
    /**
     * Returns the total number of questions in the set.
     * 
     * @return The size of the question set.
     */
    public int getSize() {
        return results.size();
    }

    /**
     * Returns the list of all questions in the set.
     * 
     * @return The list of questions in the set.
     */
    public List<Question> getQuestions() {
        return results;
    }

    /**
     * Checks if there are more questions left to answer in the set.
     * 
     * @return true if there are more questions; false otherwise.
     */
    public boolean hasMoreQuestions() {
        return  questionIndex < results.size();
    }
    
    /**
     * Returns the current question based on the current index.
     * 
     * @return The current Question object, or null if there are no more questions.
     */
    public Question getCurrentQuestion() {
        if (questionIndex < results.size()) {
            return results.get(questionIndex);
        }
        return null; 
    }
    
    /**
     * Advances to the next question in the set.
     * 
     * @return true if there is a next question, false if there are no more questions.
     */
    public boolean nextQuestion() {
        questionIndex++;
        return questionIndex < results.size();
    }
    
    /**
     * Checks if the provided answer is correct for the current question.
     * 
     * @param answer The answer to check against the current question's correct answer.
     * @return true if the answer is correct, false otherwise.
     */
    public boolean answer(String answer) {
        Question question = getCurrentQuestion();
        if (question != null && question.checkAnswer(answer)) {
            // TODO: Add a score
            return true;
        }
        return false;
    }
}
