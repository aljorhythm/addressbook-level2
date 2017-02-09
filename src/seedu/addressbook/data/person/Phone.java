package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class Phone extends PrivatableContactDetail {

    public static final String EXAMPLE = "123456789";
    public static final String MESSAGE_PHONE_CONSTRAINTS = "Person phone numbers should only contain numbers";
    public static final String PHONE_VALIDATION_REGEX = "\\d+";

    public Phone(String value, boolean isPrivate) throws IllegalValueException {
        super(value, isPrivate);
    }

    @Override
    String getValidationErrorMessage() {
        // TODO Auto-generated method stub
        return MESSAGE_PHONE_CONSTRAINTS;
    }

    @Override
    String getValidationRegex() {
        // TODO Auto-generated method stub
        return PHONE_VALIDATION_REGEX;
    }

    @Override
    public String getPrintableStringPrefix() {
        return " Phone: ";
    }
}
