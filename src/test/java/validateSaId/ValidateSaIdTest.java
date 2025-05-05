package validateSaId;

import validateSaId.ValidateSaId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateSaIdTest {
    @Test
    void testValidIdNumber() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
        assertFalse(ValidateSaId.isIdNumberValid("1234")); // Too short
        assertFalse(ValidateSaId.isIdNumberValid("20010148000861234")); // Too long
    }

    @Test
    void testNonNumericCharacters() {
        assertFalse(ValidateSaId.isIdNumberValid("20010148000A6"));
    }

    @Test
    void testInvalidDate() {
        assertFalse(ValidateSaId.isIdNumberValid("9902304800086")); // Invalid date (Feb 30)
        assertFalse(ValidateSaId.isIdNumberValid("0000004800086")); // All zeros
    }

    @Test
    void testCitizenshipDigit() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800286")); // '2' is invalid
    }
}