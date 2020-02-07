package src.bowling;

public class Try {
    private int score;
    private Try nextTry;

    public Try(int score) {
        this.score = score;
    }

    public String toString() {
        return "" + score;
    }

    public int getScore() {
        return score;
    }

    public void addBonus(int bonus) {
        this.score += bonus;
    }
}