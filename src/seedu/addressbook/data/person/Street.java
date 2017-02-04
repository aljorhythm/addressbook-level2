package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * 
 * @author joellim
 * Street part of an address
 */

public class Street {
    private String street;

    public static String REGEX = ".+";

    public Street(String street) throws IllegalValueException {
        this.street = IllegalValueException.matchString(street, REGEX,
                "Invalid Street '" + street + "' Street must not be empty");
    }

    public String toString() {
        return street;
    }
}
