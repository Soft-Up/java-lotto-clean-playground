import java.util.*;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(final Collection<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public LottoNumbers(final LottoNumber... lottoNumbers) {
        this(Arrays.stream(lottoNumbers).toList());
    }

    public LottoNumbers toSet() {
        return new LottoNumbers(new HashSet<>(this.lottoNumbers));
    }

    public int size() {
        return this.lottoNumbers.size();
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public long match(final LottoNumbers lottoNumbers) {
        return lottoNumbers.lottoNumbers
                .stream()
                .filter(lottoNumbers::contains)
                .count();
    }
}
