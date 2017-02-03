package seedu.addressbook.data.person;

/**
 * 
 * @author joellim
 * Postal Code part of an address
 */

public class PostalCode {
    private String postalCode;

    public PostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String toString() {
        return postalCode;
    }
}
