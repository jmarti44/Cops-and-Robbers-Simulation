import java.awt.Graphics;
import java.util.Random;
public class CopCar extends Car 
{
    private static int xRatio;
    private static int yRatio;
    private int newX =1;
    private int newY =1;
    Graphics g;

    Sprite newCar;
    CopCar()
    {                    
        super ("CopCar",5000, new Engine("V12",30,100),"cop-car.jpg");

        Random ranX = new Random();
        Random ranY = new Random();

        xRatio = ranX.nextInt(5+5) -5;  //(max-min) + min
        yRatio = ranY.nextInt(5+5) - 5;


        this.fillUp();
    }
    CopCar(int x, int y)
    {
        super ("CopCar",5000, new Engine("V12",30,100),"cop-car.jpg");
  
        this.fillUp();

    }
  
    public void updateImage(Graphics g)
    {
    
        super.updateImage(g);

    }
 
    public void updateState(int width, int height)
    {
       
        if (this.gety() <= 0 || this.gety() > height)
        {

            newX = (-1) * newX;
            newY = (-1) * newY;
        }
        else if (this.getx() <=0 || this.getx() > width)
        {
            newX = (-1) * newX;
            newY = (-1) * newY;
        }
       

        super.drive(2,newX * xRatio, newY * yRatio);
        setx((int)getx());
        sety((int)gety());
    
    }



}
    
       

       
    
    


