
public class GasTank                        //keeps track of the current and max levels of fuel
{
    /**private instance varaibles */
    private int capacity;                   /** keeps track of maximum capacity */
    private double currentLevel;            /** keeps track of current level */

    /** method declarations*/
    GasTank()                               /**default constructor */
    {
    
    }
    GasTank(int cap)                        /**constructor*/
    {
        if(cap<0)
            capacity = 0;
        else
            capacity = cap;  
        currentLevel = 0;
    }
    //*getters and setters*/
    public int getCapacity()
    {
        return capacity;
    }
    public double getLevel()
    {
        return currentLevel;
    }
    public void setLevel(double levelIn)
    {
        if (levelIn <0)
            currentLevel = 0;
        else if(levelIn >capacity)
        {
            currentLevel = capacity;
        }
        else
        {
            currentLevel = levelIn;
        }
    }

}