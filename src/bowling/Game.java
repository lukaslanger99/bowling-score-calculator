package src.bowling;

public class Game {
	private int score;
	
    public Game() {
    	this.score = this.calculate(this.start());
    	this.printScore();
	}
	
	public Game(int[][] set) {
    	this.score = this.calculate(this.start(set));
    	this.printScore();
    }
    
    public int getScore() {
    	return score;
    }
    
    private Frame[] start() {
    	Frame[] frames = new Frame[10];
    	for (int i = 0; i < frames.length; i++) {
			System.out.println("Frame: " + (i + 1) + " ");
			frames[i] = (i != 9) ? new Frame(i + 1) : new LastFrame(i + 1);
		}
    	return this.addBonus(frames);
	}

    private Frame[] start(int[][] set) {
    	Frame[] frames = new Frame[10];
    	for (int i = 0; i < frames.length; i++) {
			frames[i] = (i != 9) ? new Frame(i + 1, set[i]) : new LastFrame(i + 1, set[i]);
		}
    	return this.addBonus(frames);
	}
	
	private Frame[] addBonus(Frame[] frames) {
		for (int i = 0; i < frames.length; i++) {
			boolean spare = frames[i].isSpare();
			boolean strikeStrikeStrike = frames[i].isStrike() && frames[i+1].isStrike() && frames[i+2].isStrike();
			boolean strikeStrikeSpare = frames[i].isStrike() && frames[i+1].isStrike() && frames[i+2].isSpare();
			boolean strikeStrike = frames[i].isStrike() && frames[i+1].isStrike();
			int frameNumber = i + 1;

			if (frameNumber < 10 && spare) {
				frames[i].addBonus(frames[i+1].getTries()[0].getScore());
			}
			if (frameNumber < 9 && strikeStrikeStrike) {
				frames[i].addBonus(20);
			}
			if (frameNumber < 9 && strikeStrikeSpare) {
				frames[i].addBonus(10 + frames[i+2].getTries()[0].getScore());
			}
			if (frameNumber < 10 && strikeStrike) {
				frames[i].addBonus(10);
			}
		}
		return frames;
	}
    
    private int calculate(Frame[] frames) {
    	int score = 0;
    	
    	for (Frame frame : frames) {
			score += frame.getScore();
		}
    	return score;
    }
    
    private void printScore() {
    	System.out.println(this.getScore());
    }
}
