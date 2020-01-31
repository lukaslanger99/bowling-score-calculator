import java.util.Scanner;

public class FrameNormal extends Frame {
    Try[] tries = new Try[2];

    public FrameNormal() {
        Scanner s = new Scanner(System.in);
        
        for (int i = 0; i < tries.length; i++) {
        	System.out.println("Try: " + (i + 1) + " enter thrown pins");
            tries[i] =  new Try(s.nextInt());
        }
        s.close();
    }
}
