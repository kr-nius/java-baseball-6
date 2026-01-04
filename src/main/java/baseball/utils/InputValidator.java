package baseball.utils;

import baseball.constant.GameConstants;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    // 사용자 입력값(문자열)에 대한 전체 검증
    public static void validateInput(String input) {
        validateLength(input);
        validateNumeric(input);
        validateUnique(input);
    }

    // 길이 검증
    private static void validateLength(String input) {
        if (input.length() != GameConstants.NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력값은 " + GameConstants.NUMBER_LENGTH + "자리여야 합니다.");
        }
    }

    // 숫자 여부 검증
    private static void validateNumeric(String input) {
        // 정규식을 사용하여 1~9 사이의 숫자로만 구성되었는지 확인
        if (!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("입력값은 1부터 9까지의 숫자로만 이루어져야 합니다.");
        }
    }

    // 중복 검증
    private static void validateUnique(String input) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : input.toCharArray()) {
            uniqueChars.add(c);
        }
        if (uniqueChars.size() != GameConstants.NUMBER_LENGTH) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
        }
    }
}
