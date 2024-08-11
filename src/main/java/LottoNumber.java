import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MAX_LOTTO_NUMBER = 45;

    public static final int MIN_LOTTO_NUMBER = 1;

    private final static List<LottoNumber> INSTANCES;

    private final int value;

    static {
        INSTANCES = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .mapToObj(LottoNumber::new)
                .toList();
    }

    private LottoNumber(final int value) {
        validate(value);

        this.value = value;
    }

    public static LottoNumber getInstance(final int value) {
        validate(value);
        return INSTANCES.get(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber that)) return false;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static void validate(final int value) {
        if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format("로또 번호는 %s부터 %s까지의 숫자만 가능합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }
}
