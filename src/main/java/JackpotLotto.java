public class JackpotLotto {
    private final Lotto lotto;

    private final LottoNumber bonus;

    public JackpotLotto(
            final Lotto lotto,
            final LottoNumber bonus
    ) {
        validate(lotto, bonus);

        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(
            final Lotto lotto,
            final LottoNumber bonus
    ) {
        if(lotto.contains(bonus)) {
            throw new IllegalArgumentException("당첨 로또는 번호가 중복되면 안 됩니다.");
        }
    }

    public Rank match(final Lotto lotto) {
        final long count = this.lotto.match(lotto);
        return new Rank(count, lotto.contains(bonus));
    }
}
