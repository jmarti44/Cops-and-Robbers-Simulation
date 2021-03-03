import java.awt.Graphics;
import java.util.Random;
public class RobberCar extends Car 
{
    private int xRatio;
    private int yRatio;
    RobberCar()
    {
        super ("RobberCar", 5000, new Engine("V8",20,200),"red-car.jpg");
        Random ranX = new Random();
        Random ranY = new Random();

        xRatio = ranX.nextInt(5+5) -5;  //(max-min) + min
        yRatio = ranY.nextInt(5+5) - 5;
        this.fillUp();
    }

    public void updateImage(Graphics g)
    {
    
        //grabbing x and y from the grandparent class and updating location

        /**
        setx((int)getx() + xRatio);
        sety((int)gety() + yRatio);
        */
        
   
        super.updateImage(g);

    }
    public void updateState(int width, int height)
    {
        drive(40, xRatio, yRatio);
        setx((int)getx());
        sety((int)gety());
    }

}