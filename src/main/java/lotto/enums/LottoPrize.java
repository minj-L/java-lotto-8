package lotto.enums;

public enum LottoPrize {
    THREE("3", 5000),
    FOUR("4", 50000),
    FIVE("5", 1500000),
    FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX("6", 2000000000);

    private final String lottoCnt;
    private final int prize;

    LottoPrize(String lottoCnt, int prize) {
        this.lottoCnt = lottoCnt;
        this.prize = prize;
    }

    public static int getPrizeByKey(String key) {
        for (LottoPrize prizeMoney : values()) {
            if (prizeMoney.lottoCnt.equals(key)) {
                return prizeMoney.prize;
            }
        }

        throw new IllegalArgumentException("[ERROR] 일치하는 키값이 없습니다.");
    }
}
