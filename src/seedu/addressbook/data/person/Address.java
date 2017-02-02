package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+"; // TODO test regex  ^a\/([^,]+,){1-3}\d*

    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException
     *             if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressParts = trimmedAddress.split(", ");
        this.block = new Block(addressParts[0]);
        this.street = new Street(addressParts[1]);
        this.unit = new Unit(addressParts.length > 2 ? addressParts[2] : "");
        this.postalCode = new PostalCode(addressParts.length > 3 ? addressParts[3] : "");
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        String[] addressParts = new String[] { block.toString(), street.toString(), unit.toString(), postalCode.toString() };
        String ret = "";
        for(int i = 0; i < addressParts.length; i++){
            String part = addressParts[i];
            if(!part.equals("")){
                if(!ret.equals("")){
                    ret += ", ";
                }
                ret += part;
            };
        }
        return ret;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                        && this.toString().equals(((Address) other).toString())); // state
                                                                                  // check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
