package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * 
 * @author joellim
 *  The block part of an address
 */
public class Block {
    private String block;

    public static String REGEX = "(^[\\d]{1,4}[A-Z]{0,1}$)|(^$)";

    public Block(String block) throws IllegalValueException {
        if (block.matches(REGEX)) {
            this.block = block;
        } else {
            throw new IllegalValueException("Invalid Block '" + block
                    + "' Block format should consist of 1-4 digits and optionally followed by a capital letter");
        }
    }

    public String toString() {
        return block;
    }
}
