package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class Name extends ContactDetail {
    private String fullName;

    public Name(String value) throws IllegalValueException {
        super(value);
        this.fullName = value;
    }

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(getFullName().split("\\s+"));
    }

    @Override
    String getValidationErrorMessage() {
        return MESSAGE_NAME_CONSTRAINTS;
    }

    @Override
    String getValidationRegex() {
        return NAME_VALIDATION_REGEX;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

}
