import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumberTest {
    @Test
    @DisplayName("로또 번호는 " + LottoNumber.MIN_LOTTO_NUMBER + " ~ " + LottoNumber.MAX_LOTTO_NUMBER + " 까지의 숫자만 존재한다.")
    void constructorTest() {
        assertThatNoException().isThrownBy(() -> LottoNumber.getInstance(LottoNumber.MIN_LOTTO_NUMBER));
    }

    @Test
    @DisplayName("로또 번호는 1 ~ 45 까지의 숫자가 아니면 예외가 발생한다.")
    void constructorExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.getInstance(LottoNumber.MAX_LOTTO_NUMBER + 1));
    }
}
