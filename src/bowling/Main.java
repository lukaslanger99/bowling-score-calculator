package src.bowling;

public class Main {
	public static void main(String[] args) {
		Game game = new Game(new int[][] {{1,4},{4,5},{6,4},{5,5},{10,0},{0,1},{7,3},{6,4},{10,0},{2,8,6}});
		System.out.println(game.toString());
	}

}
