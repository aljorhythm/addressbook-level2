package seedu.addressbook.data.exception;

/**
 * Signals that some given data does not fulfill some constraints.
 */
public class IllegalValueException extends Exception {
    /**
     * @param message should contain relevant information on the failed constraint(s)
     */
    public IllegalValueException(String message) {
        super(message);
    }

    /**
     * 
     * @param test String to test
     * @param regex Regex to test against
     * @param errorMessage error message if match fails
     * @return test if regex matches
     * @throws IllegalValueException with error message
     */
    public static String matchString(String test, String regex, String errorMessage) throws IllegalValueException {
        if (test.matches(regex)) {
            return test;
        } else {
            throw new IllegalValueException(errorMessage);
        }
    }
}
