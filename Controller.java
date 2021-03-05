
import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.Timer;



import javax.swing.SwingUtilities;

class Controller implements MouseListener,KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
    
        
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
            view.repaint();
            model.newSprite(e.getX(),e.getY());

			// Gets here is left mouse button was clicked
		} else if (SwingUtilities.isRightMouseButton(e))  {
            // Gets here if right mouse button was clicked
            view.repaint();

           
            model.updateScene(view.getWidth(),view.getHeight()); 
            



            //ArrayList <Sprite> fillSprites = new ArrayList<Sprite>();
            
            /** 
            model.getList().size();

           for (int i = 0; i<model.getList().size(); i++)
           {
               Car fill = (Car)model.getList().get(i);
               fill.fillUp();
           }
    
            
            /** 
            for (int i = 0; i<fillSprites.size();i++)
            {
                Car fill = (Car)fillSprites.get(i);
                fill.fillUp();
            }*/


                
            
            
		}
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }


    public void keyPressed(KeyEvent e)
    {
    
    }
    public void keyTyped(KeyEvent e )
    {
        if(e.getKeyChar() =='h')
        {
            System.out.println("hello world");
        }
        else if(e.getKeyChar() =='n')
        {
            int escape = RobberCar.getEscape();
            int captured = RobberCar.getCapture();

            System.out.println(escape);
            System.out.println("Robbers have escaped");
            System.out.println(captured);
            System.out.println("Robbers have been captured");
        }
        else if(e.getKeyChar() == 'r')
        {
            model.intialize();
            view.repaint();
        }
        else if (e.getKeyChar() == 's')
        {
            new SpriteMover(this.model,this.view);
        }
    }
   
    public void keyReleased(KeyEvent e)
    {
       
        SpriteMover newMover = new SpriteMover(this.model,this.view);
        Thread myThread = new Thread(newMover);
        myThread.start();
    }
   



    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));

    
       

        
        new Controller();


        

    }
}

