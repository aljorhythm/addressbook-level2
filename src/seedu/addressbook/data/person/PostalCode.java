package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * 
 * @author joellim
 * Postal Code part of an address
 */

public class PostalCode {
    private String postalCode;

    public static String REGEX = "^\\d{6}$";

    public PostalCode(String postalCode) throws IllegalValueException {
        this.postalCode = IllegalValueException.matchString(postalCode, REGEX,
                "Invalid Postal Code '" + postalCode + "' Postal Code should consist of 6 numeric characters");
    }

    public String toString() {
        return postalCode;
    }
}
