package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a person's contact detail
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
 */
public abstract class ContactDetail implements Printable {
    /**
     * 
     */
    private String value;

    /**
     * Instance's value attribute will be set to String supplied to constructor
     * @param value
     * @throws IllegalValueException Thrown if value is invalid, error message implemented by inherited class
     */
    public ContactDetail(String value) throws IllegalValueException {
        this.value = value.trim();
        if (!isValid(value)) {
            throw new IllegalValueException(getValidationErrorMessage());
        }
    }

    public void printClass() {
        System.out.print(this.getClass());
    }

    /**
     * Returns error message if validation fails
     * @return
     */

    abstract String getValidationErrorMessage();

    /**
     * Returns true if a given string is a valid value
     */
    public boolean isValid(String test) {
        return test.matches(getValidationRegex());
    }

    /**
     * Returns regex used for validation
     * @return
     */
    abstract String getValidationRegex();

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other.getClass().equals(this.getClass()) // instanceof handles nulls
                        && this.getValue().equals(((ContactDetail) other).getValue())); // state check
    }

    /**
     * 
     * String to be prefixed to toString() for printing
     */
    public abstract String getPrintableStringPrefix();
}
