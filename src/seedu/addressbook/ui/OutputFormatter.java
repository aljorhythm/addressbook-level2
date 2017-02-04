package seedu.addressbook.ui;

import java.util.List;

public abstract class OutputFormatter {
    /**
     * 
     * @return Divider for sections of output
     */
    abstract String getDivider();

    /**
     * 
     * @return A decorative prefix added to the beginning of lines
     */
    abstract String getLinePrefix();

    /**
     * 
     * @return Regex eg. "\t%1$d. %2$s"
     */
    abstract String getIndexedListItemFormat();

    /**
     * 
     * @return line separator
     */
    abstract String getLineSeparator();

    /**
     * 
     * @param str
     * @return A formatted line
     */
    public String formatLine(String str) {
        return getLinePrefix() + str;
    }

    /**
     * 
     * @param message
     * @return entire String formed by joining strings in message
     */
    // TODO use String builder
    public String formatLines(String... message) {
        String ret = "";
        for (int i = 0; i < message.length; i++) {
            String m = message[i];
            ret += getLinePrefix() + m.replace("\n", "\n" + getLinePrefix())
                    + (i < message.length - 1 ? getLineSeparator() : "");
        }
        return ret;
    }

    /**
     * 
     * @param prepends No of dividers to prepend
     * @param appends No of dividers to append
     * @param message Message in between dividers
     * @return formatted strings prepended and appended with dividers
     */
    // TODO use String builder
    public String formatLinesWithDividers(int prepends, int appends, String... message) {
        String ret = "";
        for (int i = 0; i < prepends; i++) {
            ret += formatLine(getDivider()) + getLineSeparator();
        }
        ret += formatLines(message) + getLineSeparator();

        for (int i = 0; i < appends; i++) {
            ret += formatLine(getDivider()) + (i < appends - 1 ? getLineSeparator() : "");
        }
        return ret;
    }

    /**
     * Formats a string as a viewable indexed list item.
     * @param index visible index for this listing
     * @param item
     * @return
     */
    public String formatListItem(int index, String item) {
        return formatLine(String.format(getIndexedListItemFormat(), index, item));
    }

    /**
     * Formats a list of strings as a viewable indexed list item.
     * @param strs list of items
     * @param displayOffset Offset required to convert between 1-indexing and 0-indexing.
     * @return
     */
    public String formatIndexedList(List<String> strs, int displayOffset) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + displayOffset;
        for (String listItem : strs) {
            formatted.append(formatListItem(displayIndex, listItem)).append(getLineSeparator());
            displayIndex++;
        }
        formatted.append(getLinePrefix());
        return formatted.toString();
    }
}
