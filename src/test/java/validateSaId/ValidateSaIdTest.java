package validateSaId;

import validateSaId.ValidateSaId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateSaIdTest {
    @Test
    void testValidIdNumber() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
    }
    @Test
    void testInvalidIdNumber() {
        assertFalse(ValidateSaId.isIdNumberValid("1234")); // Too short
    }
}