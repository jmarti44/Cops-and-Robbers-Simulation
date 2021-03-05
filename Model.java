import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


class Model
{

    public ArrayList <Sprite> sprites = new ArrayList<Sprite>();
    public Iterator<Sprite> iterator;
    CopCar copCar;
    RobberCar robberCar;
    Sprite sprite;
    Bank bank;
    private static int counter;


    Model() throws IOException {
    /** 
    Sprite sprite_1 = new Sprite("smiley.jpg");
    sprite_1.setX(0);
    sprite_1.setY(0);
   */

    //inital sprites

    copCar = new CopCar();
    robberCar = new RobberCar();
    Sprite sprite_1 = new Bank();
    sprites.add(sprite_1);    //staionary bank
    
   
    }

    
  public void intialize()
  {
      sprites = new ArrayList<Sprite>();
      Sprite newBank = new Bank();
      sprites.add(newBank);
      RobberCar.setEscape(0);
      RobberCar.setCapture(0);

   }
  public void newSprite(int x, int y)
  {
  
    //CopCar object creation

    if (counter == 0)
    {
      sprite = new RobberCar();
      sprite.setX(300);
      sprite.setY(300);
      sprites.add(sprite);
      counter = 1;
    }
    else if (counter == 1)
    {
      sprite = new CopCar();
      sprite.setX(x);
      sprite.setY(y);
      sprites.add(sprite);
      counter = 0;
    }
   



    /** 
    sprite = new CopCar();
    sprite.setX(x);
    sprite.setY(y);
    sprites.add(sprite);*/
    

  }
 
  public void update(Graphics g) 
  { 
    synchronized(sprites)
    {
      for (int i = 0; i<sprites.size();i++)
      {
        sprites.get(i).updateImage(g);
      }
    }   
  }
  public ArrayList getList()
  {
    return sprites;
  }
  public void updateScene(int width, int height)
  {
    synchronized(sprites)
    {
    for (int i = 0; i< getList().size(); i++)
    {
        sprites.get(i).updateState(width, height);
    }

    for (int i = 1; i<sprites.size();i++)
    {
      for (int k = 2; k<sprites.size();k++)
      {
        if (sprites.get(i)instanceof RobberCar && sprites.get(k) instanceof CopCar )
        {
          
          
          if(sprites.get(i).overlaps(sprites.get(k)) == true)
           {
              RobberCar captured =(RobberCar)sprites.get(i);
              captured.captured();
           }

        }
      }
    }
        iterator = sprites.iterator();
        //removing element 
        int i = 0;
        while(iterator.hasNext())
        {
            Sprite car =iterator.next();
            if( car instanceof RobberCar)
            {
              if (((RobberCar)car).hasEscaped() == true)
              {
                iterator.remove();
                System.out.println("I'm free");
              }
            }
        }
      }
    }
    }


