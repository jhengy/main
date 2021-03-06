package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import static seedu.address.logic.parser.CliSyntax.PREFIX_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;

import seedu.address.model.Model;
import seedu.address.model.category.Category;
import seedu.address.model.entry.ResumeEntry;
import seedu.address.model.tag.Tag;

/**
 * Add tags to specified entry.
 */
public class TagRetagCommand extends TagCommand {
    public static final String COMMAND_WORD = "retag";
    public static final String COMMAND_WORD2 = "rt";

    public static final String MESSAGE_SUCCESS = "Entries retagged";
    public static final String MESSAGE_USAGE = TagCommand.COMMAND_WORD + " " + COMMAND_WORD + ": Retag entries \n"
            + "Parameters: INDEX "
            + PREFIX_CATEGORY + "CATEGORY "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + TagCommand.COMMAND_WORD + " " + COMMAND_WORD + " 1 "
            + PREFIX_CATEGORY + "work "
            + PREFIX_TAG + "java ";

    private final Index index;
    private final Category category;
    private Set<Tag> tags;

    /**
     * Creates an TagRetagCommand to add the specified {@code Entry}
     */
    public TagRetagCommand(Index index, Category category, Set<Tag> tags) {
        this.tags = tags;
        this.index = index;
        this.category = category;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);
        List<ResumeEntry> lastShownList = model.getFilteredEntryList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ENTRY_DISPLAYED_INDEX);
        }

        ResumeEntry entryToEdit = lastShownList.get(index.getZeroBased());
        ResumeEntry editedEntry = newEntry(entryToEdit);

        model.updateEntry(entryToEdit, editedEntry);
        model.updateFilteredEntryList(Model.PREDICATE_SHOW_ALL_ENTRIES);
        model.commitAddressBook();

        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }

    /**
     * Takes an entry and return an {@code Entry} with updated details specified
     */
    private ResumeEntry newEntry(ResumeEntry entry) {
        return new ResumeEntry(
                category, entry.getEntryInfo(),
                tags, entry.getDescription());
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TagRetagCommand)) {
            return false;
        }

        TagRetagCommand retag = (TagRetagCommand) other;

        return other == this // short circuit if same object
                || (other instanceof TagRetagCommand // instanceof handles nulls
                && category.equals(retag.category)
                && index.equals(retag.index)
                && tags.equals(retag.tags));
    }
}
