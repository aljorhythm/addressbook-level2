package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class TextUi {

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    public static final int DISPLAYED_INDEX_OFFSET = 1;

    private final Scanner in;
    private final PrintStream out;
    private OutputFormatter outFormatter;

    public TextUi() {
        this(System.in, System.out, new StandardFormatter());
    }

    public TextUi(InputStream in, PrintStream out, OutputFormatter outFormatter) {
        this.in = new Scanner(in);
        this.out = out;
        this.outFormatter = outFormatter;
    }

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Echos the command back to the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
        out.print(outFormatter.formatLine("Enter command: "));
        String fullInputLine = in.nextLine();

        // silently consume all ignored lines
        while (shouldIgnore(fullInputLine)) {
            fullInputLine = in.nextLine();
        }

        showToUserFormatted("[Command entered:" + fullInputLine + "]");
        return fullInputLine;
    }

    public void showWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        showToUser(outFormatter.formatLinesWithDividers(2, 1, MESSAGE_WELCOME, version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo));
    }

    public static void main(String[] args) {
        new TextUi().showToUser("hello", "abs");
        new TextUi().showWelcomeMessage("123", "something");
    }

    public void showGoodbyeMessage() {
        showToUser(outFormatter.formatLinesWithDividers(0, 2, MESSAGE_GOODBYE));
    }

    public void showInitFailedMessage() {
        showToUser(outFormatter.formatLinesWithDividers(0, 2, MESSAGE_INIT_FAILED));
    }

    /**
     * Shows message as-is to user 
     */
    public void showToUser(String message) {
        out.println(message);
    }

    /**
     * Shows formatted message to user 
     */
    public void showToUserFormatted(String message) {
        out.println(outFormatter.formatLine(message));
    }

    /** Formats and shows message(s) to the user */
    public void showToUser(String... message) {
        out.println(outFormatter.formatLines(message));
    }

    /**
     * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    public void showResultToUser(CommandResult result) {
        final Optional<List<? extends ReadOnlyPerson>> resultPersons = result.getRelevantPersons();
        if (resultPersons.isPresent()) {
            showPersonListView(resultPersons.get());
        }
        showToUser(outFormatter.formatLinesWithDividers(0, 1, result.feedbackToUser));
    }

    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    private void showPersonListView(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        showToUserAsIndexedList(formattedPersons);
    }

    /** Shows a list of strings to the user, formatted as an indexed list. */
    private void showToUserAsIndexedList(List<String> list) {
        showToUser(outFormatter.formatIndexedList(list, 1));
    }

}
