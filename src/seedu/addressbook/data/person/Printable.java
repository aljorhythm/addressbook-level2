package seedu.addressbook.data.person;

/**
 * Represents a printable object
 *
 */
public interface Printable {
    /**
     * Returns printable message
     * @return
     */
    public String getPrintableString();

    /**
     * Returns printable message combined from other Printable instances
     * @param printables
     * @return
     */
    default String getPrintableString(Printable... printables){
        StringBuilder builder = new StringBuilder();
        for(Printable printable : printables){
            builder.append(printable.getPrintableString());
        }
        return builder.toString();
    }
}
