package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGeneratorService {
    public List<List<Integer>> buyingLottoes(int lottoCnt) {
        return IntStream.range(0, lottoCnt)
                .mapToObj(i -> reRangeLottoNums(generateLottoNums()))
                .collect(Collectors.toList());
    }

    public List<Integer> reRangeLottoNums(List<Integer> lottoNums) {
        Collections.sort(lottoNums);
        return lottoNums;
    }

    public List<Integer> generateLottoNums() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
