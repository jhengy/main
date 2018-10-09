package seedu.address.model.entry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static seedu.address.testutil.TypicalEntrys.NUS_EDUCATION;
import static seedu.address.testutil.TypicalEntrys.WORK_FACEBOOK;

import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;

import seedu.address.testutil.EntryBuilder;

public class EntryTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        MajorResumeEntry entry = new EntryBuilder().build();
        thrown.expect(UnsupportedOperationException.class);
        entry.getTags().remove(0);
    }

    @Test
    public void isSamePerson() {
        // same object -> returns true
        assertTrue(NUS_EDUCATION.isSameEntry(NUS_EDUCATION));
        assertTrue(WORK_FACEBOOK.isSameEntry(WORK_FACEBOOK));

        // null -> returns false
        assertFalse(WORK_FACEBOOK.isSameEntry(null));
        assertFalse(NUS_EDUCATION.isSameEntry(null));

        // different category -> returns false
        MajorResumeEntry editedWork = new EntryBuilder(WORK_FACEBOOK).withCategory("education").build();
        assertFalse(WORK_FACEBOOK.isSameEntry(editedWork));
        MajorResumeEntry editedEducation = new EntryBuilder(NUS_EDUCATION).withCategory("work").build();
        assertFalse(NUS_EDUCATION.isSameEntry(editedEducation));

        // all fields different
        assertFalse(NUS_EDUCATION.isSameEntry(WORK_FACEBOOK));
    }

    @Test
    public void equals() {

        // same object -> returns true
        assertTrue(WORK_FACEBOOK.equals(WORK_FACEBOOK));
        assertTrue(NUS_EDUCATION.equals(NUS_EDUCATION));

        // null -> returns false
        assertFalse(WORK_FACEBOOK.equals(null));
        assertFalse(NUS_EDUCATION.equals(null));

        // different category -> returns false
        MajorResumeEntry editedWork = new EntryBuilder(WORK_FACEBOOK).withCategory("education").build();
        assertFalse(WORK_FACEBOOK.equals(editedWork));
        MajorResumeEntry editedEducation = new EntryBuilder(NUS_EDUCATION).withCategory("work").build();
        assertFalse(NUS_EDUCATION.equals(editedEducation));

        // all fields different
        assertFalse(NUS_EDUCATION.equals(WORK_FACEBOOK));
    }
}
