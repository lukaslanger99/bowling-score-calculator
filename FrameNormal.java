import java.util.Scanner;

public class FrameNormal extends Frame {
    Try[] tries = new Try[2];

    public FrameNormal() {
        Scanner s = new Scanner(System.in);
        for (Try try1 : tries) {
            int score = s.nextLine();
            try1 = new Try(score);
        }
        s.close();
    }
}
