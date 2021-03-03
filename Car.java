
//import java.text.DecimalFormat;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Car extends Sprite                                              //Contains an engine and a gas thank and allow it to keep track of location and fuel level while being driven
{
    //instance variables
    private String description;                                 //descrption of car
    private int maxFuel = 0;                                    //to store max fuel value
    private GasTank gas_tank;
    private Engine engine;
    private  double x_Ratio;
    private  double y_Ratio;


    //Methods
   
    Car(String script, int fuelCapacity, Engine engine, String jpg)         //Arguement constructor
    {
       
        super (jpg);
        //System.out.println("car constructor called");
        if (script.length() == 0)
            description = "Generic Car";
        else
            description = script;
        if (engine == null)
            this.engine = new Engine("",0,0);
        else
            this.engine = engine;
        if(fuelCapacity < 0)
            fuelCapacity = 0;
        maxFuel = fuelCapacity;
        gas_tank = new GasTank(maxFuel);
         
    }
    public void updateImage(Graphics g)
    {
        /** *
        int x = getX();
        int y = getY();
        setX(x + 1);
        setY(y + 1);*/

        super.updateImage(g);

    }
    public double getx()
    {
        return super.getX();
    }
    public double gety()
    {
        return super.getY();
    }
    public void setx(int x)
    {
        setX(x);
    }
    public void sety(int y)
    {
        setY(y);
    }
    public double getFuelLevel()
    {
        return gas_tank.getLevel();
    }
    public int getMPG()
    
    {
        return this.engine.getMpg();
    }

    public void fillUp()
    {
        gas_tank.setLevel(maxFuel);
    }
    public int getMaxspeed()
    {
        return this.engine.getMaxspeed();
    }
    public void drive (int distance, double x_Ratio, double y_Ratio)
    {
        double newDistance = distance;
        double maxDistance = getMPG() * this.getFuelLevel();        //maxDistance possible given fuel level
        if (newDistance >= maxDistance)                             //not enough fuel to travel given distance
        {
            newDistance = maxDistance;
            this.gas_tank.setLevel(0);                              //fuel at this point is empty
            String x = String.valueOf(newDistance);
            String message = "Ran out of gas after driving " + x + " miles.";
            //System.out.println(message);
            
        }
        else
        {                                  
            double fuelUsed =(1.0/getMPG()) * newDistance;          //equation will how much fuel was used used in gallons-->[gallons/mile] * mile = gallons            
            this.gas_tank.setLevel(this.getFuelLevel()- fuelUsed);
        }

            
        double hypt = Math.sqrt(Math.pow(x_Ratio,2) + Math.pow(y_Ratio, 2));
        double distanceRatio = newDistance/hypt;

        int x = getX();
        int y = getY();
        
        x+= distanceRatio * x_Ratio;
        y += distanceRatio * y_Ratio; 

    


        setx(x);
        sety(y);
        /** 
        this.xRatio = x;
        this.yRatio =y;*/

        //return newDistance;

    }
    
    public double getxRatio()
    {
        return x_Ratio;
    }
    public double getyRatio()
    {
        return y_Ratio;
    }
    public String getDescription()
    {
        //converting int to strings
        String currentLevel = String.format("%.2f",this.getFuelLevel());
        String maxLevel =String.valueOf(maxFuel);
        String x = String.format("%.0f",this.getX());
        String y = String.format("%.0f",this.getY());

        //Concatenating strings
        String Name = description+ "(engine:" + this.engine.getDescription() + "),fuel:" + currentLevel + "/" + maxLevel + ",location: (" + x + "," + y + "))";
        return Name;
        
    }
    public GasTank get_gas_tank()
    {
        return gas_tank;
    }


}
