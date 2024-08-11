import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class JackpotLottoTest {
    private static final List<LottoNumber> numbers = List.of(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::getInstance)
            .toList();
    private static final LottoNumbers lottoNumbers = new LottoNumbers(numbers);
    private static final Lotto lotto = new Lotto(lottoNumbers);
    private static final LottoNumber bonus = LottoNumber.getInstance(7);

    @Test
    @DisplayName("당첨 로또는 6개의 번호와 1개의 보너스 번호를 가진다.")
    void constructorTest() {
        assertThatNoException().isThrownBy(() -> new JackpotLotto(lotto, bonus));
    }

    @Test
    @DisplayName("match test")
    void matchTest() {
        // given
        final JackpotLotto jackpotLotto = new JackpotLotto(lotto, bonus);
        final LottoRankCalculator lottoRankCalculator = new LottoRankCalculator() {
            @Override
            public Rank calculate(long matchCount, boolean matchBonus) {
                return new Rank(1);
            };
        };

        // when
        final Rank actual = jackpotLotto.match(lotto, lottoRankCalculator);

        // then
        assertThat(actual.is1st()).isTrue();
    }
}
