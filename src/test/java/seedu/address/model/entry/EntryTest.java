package seedu.address.model.entry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static seedu.address.testutil.TypicalEntrys.WORK_AT_FACEBOOK;
import static seedu.address.testutil.TypicalEntrys.NUS_EDUCATION;


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
        assertTrue(WORK_AT_FACEBOOK.isSameEntry(WORK_AT_FACEBOOK));

        // null -> returns false
        assertFalse(WORK_AT_FACEBOOK.isSameEntry(null));
        assertFalse(NUS_EDUCATION.isSameEntry(null));

        // different category -> returns false
        MajorResumeEntry editedWork = new EntryBuilder(WORK_AT_FACEBOOK).withCategory("education").build();
        assertFalse(WORK_AT_FACEBOOK.isSameEntry(editedWork));
        MajorResumeEntry editedEducation = new EntryBuilder(NUS_EDUCATION).withCategory("work").build();
        assertFalse(NUS_EDUCATION.isSameEntry(editedEducation));

        // all fields different
        assertFalse(NUS_EDUCATION.isSameEntry(WORK_AT_FACEBOOK));
    }

    @Test
    public void equals() {

        final MajorResumeEntry WORK_AT_FACEBOOK = new EntryBuilder().withCategory("work")
                .withTitle("Facebook").withDuration("2010 - 2013")
                .withSubHeader("software engineering intern")
                .withTags("java").build();

        final MajorResumeEntry NUS_EDUCATION = new EntryBuilder().withCategory("education")
                .withTitle("National University of Singapore").withDuration("2010 - 2013")
                .withSubHeader("Bachelor of computing")
                .withTags("t").build();

        // same object -> returns true
        assertTrue(WORK_AT_FACEBOOK.equals(WORK_AT_FACEBOOK));
        assertTrue(NUS_EDUCATION.equals(NUS_EDUCATION));

        // null -> returns false
        assertFalse(WORK_AT_FACEBOOK.equals(null));
        assertFalse(NUS_EDUCATION.equals(null));

        // different category -> returns false
        MajorResumeEntry editedWork = new EntryBuilder(WORK_AT_FACEBOOK).withCategory("education").build();
        assertFalse(WORK_AT_FACEBOOK.equals(editedWork));
        MajorResumeEntry editedEducation = new EntryBuilder(NUS_EDUCATION).withCategory("work").build();
        assertFalse(NUS_EDUCATION.equals(editedEducation));

        // all fields different
        assertFalse(NUS_EDUCATION.equals(WORK_AT_FACEBOOK));
    }
}
