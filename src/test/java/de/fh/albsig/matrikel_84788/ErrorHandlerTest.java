package de.fh.albsig.matrikel_84788;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.fh.albsig.matrikel_84788.errorhandler.ErrorHandler;

/**
 * The Class ErrorHandlerTest.
 */
public class ErrorHandlerTest {
    /**
     * Test return of error helper.
     */
    @Test
    public void testReturnOfErrorHandler() {
        ErrorHandler eh = new ErrorHandler("FOO", "BAR");
        assertTrue(
                !"".equals(eh.throwErrorXML()) || eh.throwErrorXML() != null);
    }

    /**
     * Test getters.
     */
    @Test
    public void testGetters() {
        ErrorHandler eh = new ErrorHandler("FOO", "BAR");

        assertTrue(eh.getDescription() != null);
        assertTrue(eh.getTitle() != null);
    }

    @Test
    public void testSetters() {
        ErrorHandler eh = new ErrorHandler();
        eh.setTitle("FOO");
        eh.setDescription("BAR");

        assertTrue("FOO".equals(eh.getTitle()));
        assertTrue("BAR".equals(eh.getDescription()));
    }
}
