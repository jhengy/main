package seedu.address.ui;

import com.google.common.eventbus.Subscribe;

import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.EntryPanelSelectionChangedEvent;
import seedu.address.commons.events.ui.JumpToListRequestEvent;
import seedu.address.model.entry.ResumeEntry;

public class EntryListPanel extends UiPart<Region> {
    private static final String FXML = "EntryListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(EntryListPanel.class);

    @FXML
    private ListView<ResumeEntry> entryListView;

    public EntryListPanel(ObservableList<ResumeEntry> entryList) {
        super(FXML);
        setConnections(entryList);
        registerAsAnEventHandler(this);
    }

    private void setConnections(ObservableList<ResumeEntry> entryList) {
        try{
            System.out.println("test" + entryList + " " + entryList == null);
            entryListView.setItems(entryList);
            entryListView.setCellFactory(listView -> new EntryListViewCell());
            setEventHandlerForSelectionChangeEvent();
        } catch (NullPointerException e) {
            System.out.println("null pointer caught");
        }

    }

    private void setEventHandlerForSelectionChangeEvent() {
        entryListView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        logger.fine("Selection in person list panel changed to : '" + newValue + "'");
                        raise(new EntryPanelSelectionChangedEvent(newValue));
                    }
                });
    }

    /**
     * Scrolls to the {@code PersonCard} at the {@code index} and selects it.
     */
    private void scrollTo(int index) {
        Platform.runLater(() -> {
            entryListView.scrollTo(index);
            entryListView.getSelectionModel().clearAndSelect(index);
        });
    }

    @Subscribe
    private void handleJumpToListRequestEvent(JumpToListRequestEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        scrollTo(event.targetIndex);
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class EntryListViewCell extends ListCell<ResumeEntry> {
        @Override
        protected void updateItem(ResumeEntry entry, boolean empty) {
            super.updateItem(entry, empty);

            if (empty || entry == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new EntryCard(entry, getIndex() + 1).getRoot());
            }
        }
    }

}
