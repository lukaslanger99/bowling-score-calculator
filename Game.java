public class Game {
	private int score;
	
    public Game() {
    	this.score = this.calculate(this.start());
    	this.printScore();
    }
    
    public int getScore() {
    	return score;
    }
    
    private Frame[] start() {
    	Frame[] frames = new Frame[10];
    	for (int i = 0; i < frames.length; i++) {
    		System.out.println("Frame: " + (i + 1) + " ");
    		frames[i] = new Frame(i + 1);
		}
    	return frames;
    }
    
    private int calculate(Frame[] frames) {
    	int score = 0;
    	
    	for (Frame frame : frames) {
			Try[] tries = frame.getTries();
			for (Try currentTry : tries) {
				score += currentTry.getScore();
			}
		}
    	return score;
    }
    
    private void printScore() {
    	System.out.println(this.getScore());
    }
}
