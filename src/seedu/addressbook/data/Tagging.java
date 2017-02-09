package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

/**
 * 
 * Represent an adding or deleting of a tag for a specific person
 *
 */

public class Tagging {
    private Person person;
    private Tag tag;
    private Action action;

    private enum Action {
        DELETE, ADD
    };

    public Tagging(Person person, Tag tag, Action action) {
        this.setPerson(person);
        this.setTag(tag);
        this.setAction(action);
    }

    /**
     * @return the tag
     */
    public Tag getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(Tag tag) {
        this.tag = tag;
    }

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(Action action) {
        this.action = action;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

}
