package seedu.address.commons.events.ui;

import seedu.address.commons.events.BaseEvent;
import seedu.address.model.entry.ResumeEntry;

/**
 * Represents a selection change in the Person List Panel
 */
public class EntryPanelSelectionChangedEvent extends BaseEvent {

    private final ResumeEntry newSelection;

    public EntryPanelSelectionChangedEvent(ResumeEntry newSelection) {
        this.newSelection = newSelection;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public ResumeEntry getNewSelection() {
        return newSelection;
    }
}
