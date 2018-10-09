package seedu.address.model.entry;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PersonalInfoTest {
    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_GITHUB = "source102";

    /**
     *
     * @return A default PersonalInfo instance.
     */
    public PersonalInfo createDefualt() {
        PersonalInfo defaultInfo = new PersonalInfo(new Name(DEFAULT_NAME),
                new Address(DEFAULT_ADDRESS), new Phone(DEFAULT_PHONE),
                new Email(DEFAULT_EMAIL), DEFAULT_GITHUB);
        return defaultInfo;
    }

    @Test
    public void equals() {
        assertTrue(createDefualt().equals(createDefualt()));
    }

}
