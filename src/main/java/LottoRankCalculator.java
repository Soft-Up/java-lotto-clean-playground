@FunctionalInterface
public interface LottoRankCalculator {
    Rank calculate(
            final long matchCount,
            final boolean matchBonus
    );
}
