package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public class Address extends PrivatableContactDetail {

    public Address(String value, boolean isPrivate) throws IllegalValueException {
        super(value, isPrivate);
    }

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    @Override
    String getValidationErrorMessage() {
        return MESSAGE_ADDRESS_CONSTRAINTS;
    }

    @Override
    String getValidationRegex() {
        return ADDRESS_VALIDATION_REGEX;
    }

    @Override
    public String getPrintableStringPrefix() {
        return " Address: ";
    }
}
