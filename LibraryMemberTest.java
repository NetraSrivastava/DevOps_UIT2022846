import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LibraryMemberTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testRegisterMemberSuccessfully() {
        assertTrue(library.registerMember("M101"));
    }

    @Test
    public void testRegisterDuplicateMember() {
        library.registerMember("M101");
        assertFalse(library.registerMember("M101"));
    }

    @Test
    public void testRemoveMemberSuccessfully() {
        library.registerMember("M101");
        assertTrue(library.removeMember("M101"));
    }

    @Test
    public void testRemoveNonExistingMember() {
        assertFalse(library.removeMember("M999"));
    }

    @Test
    public void testValidateMember() {
        library.registerMember("M101");
        assertTrue(library.isValidMember("M101"));
        assertFalse(library.isValidMember("M202"));
    }
}
