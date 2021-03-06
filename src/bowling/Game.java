package src.bowling;

public class Game {
	private int score;
	private Frame[] frames;
	
    public Game() {
    	this.score = this.calculate(this.start());
	}
	
	public Game(int[][] set) {
    	this.score = this.calculate(this.start(set));
	}
	
	public String toString() {
		String string = "";
		for (int i = 0; i < frames.length; i++) {
			string += frames[i] + " _ ";
		}
		return string;
	}
    
    public int getScore() {
    	return score;
	}
	
	public Frame[] getFrames() {
		return frames;
	}
    
    private Frame[] start() {
    	this.frames = new Frame[10];
    	for (int i = 0; i < frames.length; i++) {
			System.out.println("Frame: " + (i + 1) + " ");
			frames[i] = (i != 9) ? new Frame(i + 1) : new LastFrame(i + 1);
		}
    	return this.addBonus(frames);
	}

    private Frame[] start(int[][] set) {
    	this.frames = new Frame[10];
    	for (int i = 0; i < frames.length; i++) {
			frames[i] = (i != 9) ? new Frame(i + 1, set[i]) : new LastFrame(i + 1, set[i]);
		}
    	return this.addBonus(frames);
	}
	
	private Frame[] addBonus(Frame[] frames) {
		for (int i = 0; i < frames.length; i++) {
			boolean spare = frames[i].isSpare();
			boolean strike = frames[i].isStrike();
			boolean strikeStrikeStrike = frames[i].isStrike() && frames[i+1].isStrike() && frames[i+2].isStrike();
			boolean strikeStrikeSpare = frames[i].isStrike() && frames[i+1].isStrike() && frames[i+2].isSpare();
			boolean strikeStrike = frames[i].isStrike() && frames[i+1].isStrike();
			int frameNumber = i + 1;

			if (frameNumber < 10 && spare) {
				frames[i].addBonus(frames[i+1].getTries()[0].getScore());
			}
			else if (frameNumber < 9 && strikeStrikeStrike) {
				frames[i].addBonus(20);
			}
			else if (frameNumber < 9 && strikeStrikeSpare) {
				frames[i].addBonus(10 + frames[i+2].getTries()[0].getScore());
			}
			else if (frameNumber < 10 && strikeStrike) {
				frames[i].addBonus(frames[i+1].getTries()[0].getScore() + frames[i+2].getTries()[0].getScore());
			}
			else if (frameNumber < 10 && strike) {
				frames[i].addBonus(frames[i+1].getTries()[0].getScore() + frames[i+1].getTries()[1].getScore());
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
    
    public void print() {
		String firstLine = "";
		String secondLine = "";
		int score = 0;
		for (Frame frame : frames) {
			firstLine += frame + " _ ";
			score += frame.getScore();
			secondLine += score + " ____ ";
		}
		System.out.println(firstLine + "\n" + secondLine);
    }
}
