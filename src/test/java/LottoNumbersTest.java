import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumbersTest {
    @Test
    @DisplayName("LottoNumbers Collection 생성자 테스트")
    void collectionConstructorTest() {
        assertThatNoException().isThrownBy(() -> new LottoNumbers(List.of(LottoNumber.getInstance(1))));
    }

    @Test
    @DisplayName("LottoNumbers spread 생성자 테스트")
    void spreadConstructorTest() {
        assertThatNoException().isThrownBy(() -> new LottoNumbers(LottoNumber.getInstance(1)));
    }

    @Test
    @DisplayName("LottoNumbers contains 테스트")
    void containsTest() {
        // given
        final LottoNumber lottoNumber = LottoNumber.getInstance(1);
        final LottoNumbers lottoNumbers = new LottoNumbers(LottoNumber.getInstance(1));

        // when
        final boolean actual = lottoNumbers.contains(lottoNumber);

        // then
        assertThat(actual).isTrue();
    }
}
