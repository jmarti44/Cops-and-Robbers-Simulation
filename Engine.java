public class Engine                         //stores engine attributes
{
    private String name;                    //store description of the engine
    private int mpg;                        //keeps track of miles per gallon
    private int maxSpeed;                   //keeps track of max speed value

    //Methods and constructors
    Engine()                                //Default constructor                                
    {

    }
    Engine(String script, int x, int y)     //Constructor
    {
        if (script.length() == 0)
            name = "Genetic Engine";
        else
            name = script;
        if (x < 0 || y <0)
        {
            this.mpg = 0;
            this.maxSpeed = 0;
        }
        else
        {
            this.mpg = x;
            this.maxSpeed = y;
        }
    }
    public int getMpg()
    {
        return this.mpg;
    }
    public int getMaxspeed()
    {
        return this.maxSpeed;
    }
    public String getDescription()
    {
        /** should return for example "V6(MPG:20,Max speed: 120" */

        //First convert int values to string
        String Mpg = String.valueOf(mpg);
        String Maxspeed = String.valueOf(maxSpeed);

        //Concatenating strings
        String Name = name + "(" + "MPG:" + Mpg + ",Max speed:" + Maxspeed + ")";
        
        return Name;

    }

}
