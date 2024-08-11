import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(final LottoNumbers lottoNumbers) {
        validate(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    private void validate(final LottoNumbers lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.toSet().size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 번호를 가져야 합니다.");
        }
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public long match(final Lotto lotto) {
        return lotto.lottoNumbers.match(this.lottoNumbers);
    }
}
