import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    @DisplayName("로또는 6개의 중복되지 않은 번호를 가진다.")
    void constructorTest1() {
        // given
        final List<LottoNumber> lottoNumbers = List.of(1, 2, 3, 4, 5, 6)
                .stream()
                .map(LottoNumber::getInstance)
                .toList();
        // when & then
        assertThatNoException().isThrownBy(() -> new Lotto(new LottoNumbers(lottoNumbers)));
    }

    @ParameterizedTest
    @DisplayName("로또는 6개의 중복되지 않은 번호를 가지지 않으면 예외가 발생한다.")
    @MethodSource("invalidLottoNumbersParameters")
    void constructorExceptionTest1(final List<Integer> given) {
        // given
        final List<LottoNumber> lottoNumbers = given.stream()
                .map(LottoNumber::getInstance)
                .toList();
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(new LottoNumbers(lottoNumbers)));
    }

    private static Stream<Arguments> invalidLottoNumbersParameters() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @Test
    @DisplayName("로또는 로또 번호가 null 일 경우 예외가 발생한다.")
    void constructorNullExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(null));
    }
}
