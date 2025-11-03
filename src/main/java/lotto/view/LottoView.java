package lotto.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.service.LottoGeneratorService;

public class LottoView {
    private static final int DEFAULT_WINNING_NUM = 0;

    private static final LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();

    public List<List<Integer>> buyingLottoes(int lottoCnt) {
        List<List<Integer>> buyingLottoes = lottoGeneratorService.buyingLottoes(lottoCnt);
        buyingLottoes.forEach(System.out::println);

        return buyingLottoes;
    }

    public void showWinningResult(Map<String, String> prizeMap, Map<String, Integer> lottoResult) {
        List<String> printOrder = List.of("3", "4", "5", "5개 일치, 보너스 볼 일치 (30,000,000원)", "6");

        printOrder.forEach(key -> {
            int count = lottoResult.getOrDefault(key, DEFAULT_WINNING_NUM);
            String label = Optional.ofNullable(prizeMap.get(key)).orElse(key);
            System.out.printf("%s - %d개%n", label, count);
        });
    }

    public Map<String, String> prizeMap() {
        Map<String, String> prizeMap = new HashMap<>();
        prizeMap.put("3", "3개 일치 (5,000원)");
        prizeMap.put("4", "4개 일치 (50,000원)");
        prizeMap.put("5", "5개 일치 (1,500,000원)");
        prizeMap.put("6", "6개 일치 (2,000,000,000원)");

        return prizeMap;
    }
}
