import java.util.Scanner;

public class Frame {
    private Try[] tries = new Try[2];

    public Frame() {
        Scanner s = new Scanner(System.in);
        
        for (int i = 0; i < tries.length; i++) {
        	System.out.println("Try: " + (i + 1) + " enter thrown pins");
        	tries[i] =  new Try(s.nextInt());
        }
        s.close();
    }
    
    public Try[] getTries() {
    	return tries;
    }
}
