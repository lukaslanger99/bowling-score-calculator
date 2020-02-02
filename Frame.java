import java.util.Scanner;

public class Frame {
    private Try[] tries;
    private boolean spare;
    private boolean strike;
    private int frameNumber;
    private int score;

    public Frame(int frameNumber) {
        this.frameNumber = frameNumber;
        this.tries = new Try[2];
        Scanner s = new Scanner(System.in);
        
        for (int i = 0; i < tries.length; i++) {
        	System.out.println("Try: " + (i + 1) + " enter thrown pins");
            tries[i] =  new Try(s.nextInt());
            if (i == 0 && tries[0].getScore() == 10) {
                this.strike = true;
                tries[1] =  new Try(0);
                break;
            }
            if (i == 1 && tries[0].getScore() + tries[1].getScore() == 10) {
                this.spare = true;
            }
        }
        this.score = tries[0].getScore() + tries[1].getScore();
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public void addBonus(int bonus) {
        this.score += bonus;
    }

    public int getScore() {
        return score;
    }
    
    public Try[] getTries() {
    	return tries;
    }

    public boolean isSpare() {
        return spare;
    }

    public boolean isStrike() {
        return strike;
    }
}
