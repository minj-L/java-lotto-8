package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import lotto.common.ConsoleMessage;
import lotto.model.Lotto;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoPrepareService;
import lotto.service.LottoPrizeService;
import lotto.service.WinningNumCheckService;
import lotto.view.LottoView;

public class LottoController {
    private static final LottoPrepareService lottoPrepareService = new LottoPrepareService();
    private static final LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();
    private static final WinningNumCheckService winningNumCheckService = new WinningNumCheckService();
    private static final LottoPrizeService lottoPrizeService = new LottoPrizeService();
    private static final LottoView lottoView = new LottoView();

    public void run() {
        System.out.println(ConsoleMessage.PAYING_COSTS);
        String lottoCosts = readLine();
        int lottoCnt = lottoPrepareService.lottoCnt(lottoCosts);
        System.out.println();

        System.out.printf(ConsoleMessage.LOTTO_CNT + "%n", lottoCnt);
        List<List<Integer>> userLottoes = lottoView.buyingLottoes(lottoCnt);
        System.out.println();

        System.out.println(ConsoleMessage.INPUT_WINNING_NUMS);
        String winningNums = readLine();

        List<Integer> lottoWinningNums = lottoPrepareService.winningNums(winningNums);
        Lotto lotto = new Lotto(lottoWinningNums);
        HashSet<Integer> lottoWinningNumbers = lotto.toHashSet();

        System.out.println();

        System.out.println(ConsoleMessage.INPUT_BONUS_NUM);
        String bonusNumber = readLine();
        int bonusNum = lottoPrepareService.parsingBonusNum(bonusNumber, lottoWinningNumbers);
        System.out.println();

        System.out.println(ConsoleMessage.LOTTO_RES);
        System.out.println("---");
        Map<String, Integer> lottoResult = winningNumCheckService.lottoResult(lottoWinningNumbers, userLottoes,
                bonusNum);
        lottoView.showWinningResult(lottoView.prizeMap(), lottoResult);
        double winningPrize = lottoPrizeService.calculateLottoPrize(lottoResult, lottoCosts);
        System.out.printf(ConsoleMessage.TOTAL_COSTS + "%n", winningPrize);
    }
}
