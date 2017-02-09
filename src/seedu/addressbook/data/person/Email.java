package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class Email extends PrivatableContactDetail {

    public Email(String value, boolean isPrivate) throws IllegalValueException {
        super(value, isPrivate);
    }

    public static final String EXAMPLE = "valid@e.mail";
    public static final String MESSAGE_EMAIL_CONSTRAINTS = "Person emails should be 2 alphanumeric/period strings separated by '@'";
    public static final String EMAIL_VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";

    @Override
    String getValidationErrorMessage() {
        return MESSAGE_EMAIL_CONSTRAINTS;
    }

    @Override
    String getValidationRegex() {
        return EMAIL_VALIDATION_REGEX;
    }
}
