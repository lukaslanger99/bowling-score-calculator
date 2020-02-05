package src.bowling;

public class Try {
    private int score;
    private Try nextTry;

    public Try(int score) {
        this.score = score;
    }

    public void setNextTry(Try nextTry) {
        this.nextTry = nextTry;
    }

    public Try getNextTry() {
        return nextTry;
    }

    public int getScore() {
        return score;
    }

    public void addBonus(int bonus) {
        this.score += bonus;
    }
}