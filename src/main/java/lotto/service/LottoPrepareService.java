package lotto.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.CommonUtils;
import lotto.common.Validation;

public class LottoPrepareService {
    private static final int LOTTO_PRICE = 1000;

    public int lottoCnt(String strLottoCosts) {
        Validation.validateValues(strLottoCosts);

        int lottoCosts = CommonUtils.stringToInt(strLottoCosts);

        if (lottoCosts % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원으로 나누어 떨어지도록 구입해야 합니다.");
        }
        return lottoCosts / LOTTO_PRICE;
    }

    public List<Integer> winningNums(String winningNums) {
        Validation.validateValues(winningNums);

        return Arrays.stream(winningNums.split(",")).map(String::trim).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int parsingBonusNum(String bonusNum, HashSet<Integer> lottoWinningNums) {
        Validation.validateValues(bonusNum);
        int parsingBonusNum = CommonUtils.stringToInt(bonusNum);

        if (parsingBonusNum > 45 || parsingBonusNum < 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 이상 45이하의 숫자가 입력되어야 합니다.");
        }

        if (lottoWinningNums.contains(parsingBonusNum)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 있는 숫자를 보너스 번호로 입력할 수 없습니다.");
        }

        return parsingBonusNum;
    }
}
