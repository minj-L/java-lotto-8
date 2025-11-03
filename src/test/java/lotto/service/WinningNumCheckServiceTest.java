package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import lotto.view.LottoView;
import org.junit.jupiter.api.Test;

public class WinningNumCheckServiceTest {
    private final WinningNumCheckService winningNumCheckService = new WinningNumCheckService();
    private final LottoView lottoView = new LottoView();

    @Test
    void lottoResult_Test() {
        List<List<Integer>> userLottoes = List.of(List.of(1, 2, 3, 4, 7, 12),   // 4개 + 보너스 = 5게
                List.of(1, 2, 3, 4, 5, 7),    // 5개 + 보너스
                List.of(1, 2, 3, 9, 10, 11),  // 3개
                List.of(1, 2, 3, 7, 10, 11),  // 3개 + 보너스 = 4개
                List.of(1, 3, 5, 8, 9, 10),   // 3개
                List.of(1, 2, 3, 4, 11, 12),  // 4개
                List.of(1, 2, 3, 4, 5, 7),  // 5개 + 보너스
                List.of(1, 2, 3, 4, 5, 6),  // 6개
                List.of(7, 8, 9, 10, 11, 12)  // 0개
        );

        HashSet<Integer> winningNums = new HashSet<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNum = 7;

        Map<String, Integer> res = winningNumCheckService.lottoResult(winningNums, userLottoes, bonusNum);

        lottoView.showWinningResult(lottoView.prizeMap(), res);
    }
}
