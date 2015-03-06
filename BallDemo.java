import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate n bouncing balls
     * @param n numero de bolas 
     */
    public void bounce(int n)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);
        Random random = new Random();
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        ArrayList<BouncingBall> balls = new ArrayList<>();

        float r ;
        float g ;
        float b ;
        // crate and show the balls
        for(int i=0; i<n; i++){
            r = random.nextFloat();
            g = random.nextFloat();
            b = random.nextFloat();
            balls.add(new BouncingBall(random.nextInt(50), random.nextInt(50), random.nextInt(40)+10, new Color(r,g,b), ground, myCanvas));
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            for(int i=0; i<n; i++){
                BouncingBall ball = balls.get(i);
                myCanvas.wait(50);           // small delay
                ball.move();

                // stop once ball has travelled a certain distance on x axis
                if(ball.getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
