package seedu.addressbook.data.person;

import java.util.ArrayList;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * A read-only immutable interface for a Person in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface ReadOnlyPerson extends Printable {
    static class PrintableTags implements Printable {
        private UniqueTagList tags;

        PrintableTags(UniqueTagList tags) {
            this.setTags(tags);
        }

        @Override
        public String getPrintableString() {
            StringBuilder builder = new StringBuilder();
            builder.append(" Tags: ");
            for (Tag tag : getTags()) {
                builder.append(tag);
            }
            return builder.toString();
        }

        /**
         * @return the tags
         */
        public UniqueTagList getTags() {
            return tags;
        }

        /**
         * @param tags the tags to set
         */
        public void setTags(UniqueTagList tags) {
            this.tags = tags;
        }
    }

    Name getName();

    Phone getPhone();

    Email getEmail();

    Address getAddress();

    /**
     * The returned TagList is a deep copy of the internal TagList,
     * changes on the returned list will not affect the person's internal tags.
     */
    UniqueTagList getTags();

    default Printable[] getReadableContactDetails() {
        Printable[] printables = { getName(), getPhone(), getEmail(), getAddress(), new PrintableTags(getTags()) };
        return printables;

    }

    /**
     * Returns true if the values inside this object is same as those of the other
     * (Note: interfaces cannot override .equals)
     */
    default boolean isSameStateAs(ReadOnlyPerson other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                        && other.getName().equals(this.getName()) // state checks here onwards
                        && other.getPhone().equals(this.getPhone()) && other.getEmail().equals(this.getEmail())
                        && other.getAddress().equals(this.getAddress()));
    }

    /**
     * Formats the person as text, showing all contact details.
     */
    default String getAsTextShowAll() {
        return getPrintableString(getReadableContactDetails());
    }

    /**
     * Formats a person as text, showing only non-private contact details.
     */
    default String getAsTextHidePrivate() {
        ArrayList<Printable> notPrivatePrintables = new ArrayList<Printable>();
        for (Printable contactDetail : getReadableContactDetails()) {
            if (!(contactDetail instanceof PrivatableContactDetail
                    && ((PrivatableContactDetail) contactDetail).isPrivate())) {
                notPrivatePrintables.add(contactDetail);
            }
        }

        Printable[] toPrint = new Printable[notPrivatePrintables.size()];
        toPrint = notPrivatePrintables.toArray(toPrint);
        return getPrintableString(toPrint);
    }

    @Override
    public default String getPrintableString() {
        return getAsTextShowAll();
    }
}
