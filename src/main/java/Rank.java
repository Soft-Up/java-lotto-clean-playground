public class Rank {
    private final long matchCount;

    private final boolean matchBonus;

    public Rank(final long matchCount, final boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public boolean is1st() {
        return matchCount == 6;
    }

    public boolean is2nd() {
        return matchCount == 5 && matchBonus;
    }

    public boolean is3rd() {
        return matchCount == 5 && !matchBonus;
    }

    public boolean is4th() {
        return matchCount == 4;
    }

    public boolean is5th() {
        return matchCount == 3;
    }

    public boolean isUnranked() {
        return matchCount < 3;
    }
}
