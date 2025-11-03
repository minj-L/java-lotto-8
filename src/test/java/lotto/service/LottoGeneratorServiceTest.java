package lotto.service;

import org.junit.jupiter.api.Test;

public class LottoGeneratorServiceTest {
    private final LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();

    @Test
    void 로또_구입_리스트() {
        System.out.println(lottoGeneratorService.buyingLottoes(3));
    }

    @Test
    void 랜덤_로또_번호_출력() {
        System.out.println(lottoGeneratorService.generateLottoNums());
    }
}
