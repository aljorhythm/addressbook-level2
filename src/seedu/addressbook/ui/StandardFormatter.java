package seedu.addressbook.ui;

public class StandardFormatter extends OutputFormatter{
    /**  printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";
    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();
    @Override
    String getDivider() {
        return DIVIDER;
    }

    @Override
    String getLinePrefix() {
        return LINE_PREFIX;
    }

    @Override
    String getIndexedListItemFormat() {
        return MESSAGE_INDEXED_LIST_ITEM;
    }

    @Override
    String getLineSeparator() {
        return LS;
    }
}
