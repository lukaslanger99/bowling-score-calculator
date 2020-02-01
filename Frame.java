import java.util.Scanner;

public class Frame {
    private Try[] tries = new Try[2];
    private boolean spare;
    private boolean strike;
    private int frameNumber;

    public Frame(int frameNumber) {
        this.frameNumber = frameNumber;
        Scanner s = new Scanner(System.in);
        
        for (int i = 0; i < tries.length; i++) {
        	System.out.println("Try: " + (i + 1) + " enter thrown pins");
            tries[i] =  new Try(s.nextInt());
            if (i == 0 && tries[0].getScore() == 10) {
                this.strike = true;
            }
            if (i == 1 && tries[0].getScore() + tries[1].getScore() == 10) {
                this.spare = true;
            }
        }
    }

    public int getFrameNumber() {
        return frameNumber;
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
