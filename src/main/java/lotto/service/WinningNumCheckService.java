package lotto.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class WinningNumCheckService {
    private static final int WINNING_LIMIT = 3;
    private static final int BONUS_MATE_NUM = 5;
    private static final int DEFAULT_WINNING_NUM = 0;

    private final LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();
    private final LottoResultService lottoResultService = new LottoResultService();

    public Map<String, Integer> lottoResult(HashSet<Integer> lottoWinningNums, List<List<Integer>> userLottoes,
                                            int bonusNum) {
        Map<String, Integer> lottoResult = new HashMap<>();

        for (List<Integer> lotto : userLottoes) {
            HashSet<Integer> userlotto = new HashSet<>(lotto);

            int matchNumCnt = lottoResultService.cntWinningNumbersInUserLotto(lottoWinningNums, userlotto);
            if (matchNumCnt < WINNING_LIMIT) {
                continue;
            }

            boolean hasBonus = userlotto.contains(bonusNum);
            String winningLottoNumCnt = getWinningLottoNumCnt(hasBonus, matchNumCnt);

            lottoResult.put(winningLottoNumCnt, lottoResult.getOrDefault(winningLottoNumCnt, DEFAULT_WINNING_NUM) + 1);
        }

        return lottoResult;
    }

    private String getWinningLottoNumCnt(boolean hasBonus, int matchNumCnt) {
        if (hasBonus && matchNumCnt == BONUS_MATE_NUM) {
            return matchNumCnt + "개 일치, 보너스 볼 일치 (30,000,000원)";
        }

        if (hasBonus) {
            matchNumCnt += 1;
            return String.valueOf(matchNumCnt);
        }

        return String.valueOf(matchNumCnt);
    }
}
