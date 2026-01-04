package baseball.model;

import java.util.List;

public class BaseballNumbers {
    private final List<Integer> numbers;

    public BaseballNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 특정 위치의 숫자가 같은지 확인 (스트라이크 판별용)
    public boolean isStrike(int index, int number) {
        return numbers.get(index) == number;
    }

    // 특정 숫자가 포함되어 있는지 확인 (볼 판별용)
    public boolean contains(int number) {
        return numbers.contains(number);
    }

    // 특정 인덱스의 값을 가져옴
    public int get(int index) {
        return numbers.get(index);
    }
}
