package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class LottoPrepareServiceTest {
    private final LottoPrepareService lottoPrepareService = new LottoPrepareService();

    @Test
    void outPut_lotto_cnt_crt() {
        int result = lottoPrepareService.lottoCnt("8000");
        assertThat(result).isEqualTo(8);
    }

    @Test
    void outPut_lotto_cnt_fail() {
        assertThatThrownBy(() -> lottoPrepareService.lottoCnt("1256"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또는 1000원으로 나누어 떨어지도록 구입해야 합니다.");
    }

    @Test
    void get_lotto_winning_num1() {
        String winningNums = "1, 2,3, 4,5";
        List<Integer> hashLottoNums = lottoPrepareService.winningNums(winningNums);
        HashSet<Integer> expected = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        assertThat(hashLottoNums)
                .hasSize(5)
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void get_lotto_winning_num2() {
        String winningNums = "1, 2,3, 4,5,6";
        List<Integer> hashLottoNums = lottoPrepareService.winningNums(winningNums);
        HashSet<Integer> expected = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(hashLottoNums)
                .hasSize(6)
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void bonusNum_parsing_success() {
        String bonusNum = "7";
        HashSet<Integer> lottoWinningNums = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        int result = lottoPrepareService.parsingBonusNum(bonusNum, lottoWinningNums);
        assertThat(result).isEqualTo(7);
    }

    @Test
    void bonusNum_parsing_fail_1() {
        String bonusNum = "46";
        HashSet<Integer> lottoWinningNums = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lottoPrepareService.parsingBonusNum(bonusNum, lottoWinningNums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1 이상 45이하의 숫자가 입력되어야 합니다.");

    }

    @Test
    void bonusNum_parsing_fail_2() {
        String bonusNum = "6";
        HashSet<Integer> lottoWinningNums = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lottoPrepareService.parsingBonusNum(bonusNum, lottoWinningNums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호에 있는 숫자를 보너스 번호로 입력할 수 없습니다.");

    }
}
