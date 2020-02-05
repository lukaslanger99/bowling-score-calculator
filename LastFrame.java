import java.util.Scanner;

public class LastFrame extends Frame {
    private Try[] tries;
    private boolean spare;
    private boolean strike;
    private int frameNumber;
    private int score;

    public LastFrame(int frameNumber) {
        super(1);
        this.frameNumber = frameNumber;
        this.tries = new Try[3];
        Scanner s = new Scanner(System.in);
        
        for (int i = 0; i < tries.length; i++) {
            System.out.println("Try: " + (i + 1) + " enter thrown pins");
            switch (i) {
                case 0:
                    tries[i] =  new Try(s.nextInt());
                    break;
                case 1:
                    tries[i] =  new Try(s.nextInt());
                    break;
                case 2:
                    if (tries[0].getScore() + tries[1].getScore() != 10 || tries[0].getScore() + tries[1].getScore() != 20) {
                        tries[i] =  new Try(0);
                        break;
                    }
                    tries[i] =  new Try(s.nextInt());
                    break;
        }
        this.score = tries[0].getScore() + tries[1].getScore() + tries[2].getScore();

        if (tries[0].getScore() + tries[1].getScore() == 10) {
            tries[i] =  new Try(s.nextInt());
            this.addBonus(tries[i].getScore());
        }
        if (tries[0].getScore() + tries[1].getScore() == 20) {
            this.addBonus(20);
        }
        }
    }

    public LastFrame(int frameNumber, int[] set) {
        super(frameNumber, set);
        this.frameNumber = frameNumber;
        this.tries = new Try[3];

        tries[0] = new Try(set[0]);
        tries[1] = new Try(set[1]);
        tries[2] = new Try(set[2]);

        this.score = tries[0].getScore() + tries[1].getScore() + tries[2].getScore();

        if (tries[0].getScore() + tries[1].getScore() == 10) {
            this.addBonus(tries[2].getScore());
        }
        if (tries[0].getScore() + tries[1].getScore() + tries[1].getScore() == 30) {
            this.addBonus(20);
        }
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