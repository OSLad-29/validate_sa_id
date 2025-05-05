package validateSaId;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidateSaId {
    public static boolean isIdNumberValid(String idNumber) {
        // Null or length check
        if (idNumber == null || idNumber.length() != 13 || !idNumber.matches("\\d+")) {
            return false;
        }

        // Date validation
        if (!validateDate(idNumber.substring(0, 6))) {
            return false;
        }

        // Citizenship digit
        char citizenship = idNumber.charAt(10);
        if (citizenship != '0' && citizenship != '1') {
            return false;
        }
        return false;
    }

    private static boolean validateDate(String dateStr) {
        try {
            String yy = dateStr.substring(0, 2);
            String mm = dateStr.substring(2, 4);
            String dd = dateStr.substring(4, 6);

            int year = Integer.parseInt(yy);
            int month = Integer.parseInt(mm);
            int day = Integer.parseInt(dd);

            // Handle century (2000 for 00-21, else 1900)
            int fullYear = (year <= 21) ? 2000 + year : 1900 + year;
            LocalDate.parse(
                    String.format("%04d-%02d-%02d", fullYear, month, day),
                    DateTimeFormatter.ISO_LOCAL_DATE
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}