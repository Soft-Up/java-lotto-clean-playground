public class Rank {
    private final int value;

    public Rank(final int value) {
        this.value = value;
    }

    public boolean is1st() {
        return value == 1;
    }

    public boolean is2nd() {
        return value == 2;
    }

    public boolean is3rd() {
        return value == 3;
    }

    public boolean is4th() {
        return value == 4;
    }

    public  boolean is5th() {
        return value == 5;
    }

    public boolean isUnranked() {
        return !(is1st() || is2nd() || is3rd() || is4th() || is5th());
    }
}
