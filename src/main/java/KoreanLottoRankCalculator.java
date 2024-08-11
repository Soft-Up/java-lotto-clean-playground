public class KoreanLottoRankCalculator implements LottoRankCalculator {
    @Override
    public Rank calculate(long matchCount, boolean matchBonus) {
        if(matchCount == 6) {
            return new Rank(1);
        }
        if(matchCount == 5) {
            if(matchBonus) {
                return new Rank(2);
            }
            return new Rank(3);
        }
        if(matchCount == 4) {
            return new Rank(4);
        }
        if(matchCount == 3) {
            return new Rank(5);
        }
        return new Rank(0);
    }
}
