package seedu.address.model.entry;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.core.index.Index;

/**
 *  Represents bullet points content for an entry.
 */
public class EntryDescription {
    private List<String> descriptionList;

    public EntryDescription() {
        this.descriptionList = new ArrayList<>();
    }

    public List<String> getDescriptionList() {
        return descriptionList;
    }

    public void addBullet(String bullet) {
        descriptionList.add(bullet);
    }

    public void editBullet(Index index, String editedMsg) {

    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof EntryDescription
                && descriptionList.equals(((EntryDescription) other)
                    .getDescriptionList()));
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        descriptionList.forEach(s -> builder.append(s).append("\n"));
        return builder.toString();
    }
}
