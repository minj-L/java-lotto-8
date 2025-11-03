package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public HashSet<Integer> toHashSet() {
        return new HashSet<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        lengthValidate(numbers);
        duplicateNumValidate(numbers);
        rangeValidate(numbers);
    }

    private void duplicateNumValidate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 존재합니다.");
        }
    }

    private void lengthValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < MIN_NUMBER || num > MAX_NUMBER) {
                throw new IllegalArgumentException(
                        "[ERROR] 로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이여야 합니다.");
            }
        }

    }
}
