package hangman.model;

import java.io.Serializable;

public class ModelException extends Exception implements Serializable {
    
    public static String NEGATIVE_COUNTER = "Some of parameters are negative";

    public ModelException(String exception) {
        super(exception);
    }
}
