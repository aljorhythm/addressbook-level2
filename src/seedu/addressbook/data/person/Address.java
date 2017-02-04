package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "[block], street, [unit], postal_code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the format '" + EXAMPLE +"'";
    public static final String ADDRESS_VALIDATION_REGEX = "^[^,]*(, [^,]*){3}$";

    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    private static class AddressCSVIndices {
        static int BLOCK = 0, STREET = 1, UNIT = 2, POSTAL_CODE = 3;
    }

    /**
     * Validates given address.
     *
     * @throws IllegalValueException
     *             if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        address = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressParts = address.split(", ");
        this.block = new Block(addressParts[AddressCSVIndices.BLOCK]);
        this.street = new Street(addressParts.length > 1 ? addressParts[AddressCSVIndices.STREET] : "");
        this.unit = new Unit(addressParts.length > 2 ? addressParts[AddressCSVIndices.UNIT] : "");
        this.postalCode = new PostalCode(addressParts.length > 3 ? addressParts[AddressCSVIndices.POSTAL_CODE] : "");
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    /**
     * @return String representation of address
     */
    @Override
    public String toString() {
        String[] addressParts = new String[] { block.toString(), street.toString(), unit.toString(),
                postalCode.toString() };
        return String.join(", ", addressParts);
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
