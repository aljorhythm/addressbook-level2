package seedu.addressbook.data.person;

/**
 * 
 * @author joellim
 * Street part of an address
 */

public class Street {
    private String street;

    public Street(String street) {
        this.street = street;
    }

    public String toString() {
        return street;
    }
}
