package lotto.common;

import static java.util.Objects.isNull;

public class CommonUtils {
    public static int stringToInt(String number) {
        return Integer.parseInt(number);
    }

    public static void checkIsNull(String input) {
        if (isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException(
                    "[ERROR] 잘못된 입력 형식: 입력된 것이 없습니다.");
        }
    }

    public static String[] splitByDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }

    public static String removeWhitespace(String input) {
        return input.replaceAll("\\s+", "");
    }
}
