package seedu.address.model.entry;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import seedu.address.testutil.EntryBuilder;

public class EntryInfoTest {

    public EntryInfo buildEntryInfo() {
        List<String> list = Arrays.asList(EntryBuilder.DEFAULT_TITLE, EntryBuilder.DEFAULT_CAT, EntryBuilder.DEFAULT_DURATION);
        return new EntryInfo(list);
    }

    @Test
    public void constructorFromListTest() {
        // correct constructor no error returned
        buildEntryInfo();
    }

    @Test
    public void gettersTest() {
        buildEntryInfo().getEntryInfo();
    }

    @Test
    public void hashCodeTest() {
        assertTrue(buildEntryInfo().hashCode() == buildEntryInfo().hashCode());
    }
}