package lotto.service;

import java.util.Map;
import lotto.common.CommonUtils;
import lotto.enums.LottoPrize;

public class LottoPrizeService {
    public double calculateLottoPrize(Map<String, Integer> lottoResult, String lottoCosts) {
        int parsingLottoCosts = CommonUtils.stringToInt(lottoCosts);

        int totalPrize = 0;

        for (Map.Entry<String, Integer> entry : lottoResult.entrySet()) {
            String winningLottoCnt = entry.getKey();
            int winningCount = entry.getValue();

            int prize = LottoPrize.getPrizeByKey(winningLottoCnt); // enum에서 상금 조회
            totalPrize += prize * winningCount;
        }

        return (double) totalPrize / parsingLottoCosts * 100;
    }
}
