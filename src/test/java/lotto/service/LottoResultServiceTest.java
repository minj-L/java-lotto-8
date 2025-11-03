package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoResultServiceTest {

    private final LottoResultService lottoResultService = new LottoResultService();

    @Test
    void find_same_lotto_num() {
        HashSet<Integer> winningNums = new HashSet<>(List.of(1, 2, 3, 4, 5, 6));
        HashSet<Integer> lottoNums = new HashSet<>(List.of(1, 2, 3, 7, 18, 45));

        int result = lottoResultService.cntWinningNumbersInUserLotto(winningNums, lottoNums);
        assertThat(result).isEqualTo(3);
    }
}
