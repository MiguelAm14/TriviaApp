package trv.triviaapp.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class provides methods to connect to the Trivia API, retrieve questions, and manage the connection.
 * It handles the interaction with the trivia API, including making requests, reading responses, 
 * and managing the connection life-cycle.
 */
public class TriviaApi {
    private URL url;
    private HttpURLConnection conn;
    
    /**
     * Constructor that initializes the TriviaApi with the URL of the Trivia API.
     * This constructor sets the API endpoint to retrieve 10 trivia questions.
     * 
     * @throws MalformedURLException if the URL is invalid
     */
    public TriviaApi() throws MalformedURLException {
        this.url = new URL("https://opentdb.com/api.php?amount=10");
    }
    
    /**
     * Establishes a connection to the Trivia API and returns the HTTP response code.
     * This method sends a GET request to the API to fetch trivia questions.
     * 
     * @return The HTTP response code from the server
     * @throws IOException if an I/O error occurs when making the connection
     */
    public int connect() throws IOException {
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);        
        conn.connect();
        
        int response = conn.getResponseCode();
        
        return response;
    }
    
    /**
     * Reads the JSON response from the API and returns it as a string.
     * This method reads the input stream from the connection and appends the data into a StringBuilder.
     * 
     * @return The JSON response from the API as a String
     * @throws IOException if an error occurs while reading the response
     */
    public String getJSON() throws IOException {
        StringBuilder info = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                info.append(line);
            }
        }
        
        return info.toString();
    }
    
    /**
     * Closes the connection to the Trivia API if it is open.
     * This method ensures that the connection is properly closed when no longer needed.
     */
    public void disconnect() {
        if (conn != null) {
            conn.disconnect();
        }
    }
}
