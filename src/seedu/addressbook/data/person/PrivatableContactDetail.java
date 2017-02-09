package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * 
 * Represents a contact detail that can be private
 *
 */
public abstract class PrivatableContactDetail extends ContactDetail {
    private boolean isPrivate;

    public PrivatableContactDetail(String value, boolean isPrivate) throws IllegalValueException {
        super(value);
        this.isPrivate = isPrivate;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
