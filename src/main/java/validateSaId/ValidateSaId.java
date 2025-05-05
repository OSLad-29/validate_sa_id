package validateSaId;

public class ValidateSaId {
    public static boolean isIdNumberValid(String idNumber) {
        if (idNumber == null || idNumber.length() != 13) {
            return false;
        }
        // Check all characters are digits
        return idNumber.matches("\\d+");
    }
}