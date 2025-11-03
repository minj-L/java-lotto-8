package lotto.service;

import org.junit.jupiter.api.Test;

public class LottoGeneratorServiceTest {
    private final LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();

    @Test
    void buying_lotto_list() {
        System.out.println(lottoGeneratorService.buyingLottoes(3));
    }

    @Test
    void output_random_lotto_num() {
        System.out.println(lottoGeneratorService.generateLottoNums());
    }
}
