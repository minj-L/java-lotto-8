package lotto.service;

import java.util.HashSet;

public class LottoResultService {
    public int cntWinningNumbersInUserLotto(HashSet<Integer> winningNums, HashSet<Integer> lottoNums) {
        HashSet<Integer> matchedNums = new HashSet<>(winningNums);
        matchedNums.retainAll(lottoNums);

        return matchedNums.size();
    }
}
