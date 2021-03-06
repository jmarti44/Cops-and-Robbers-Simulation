public class SpriteMover implements Runnable
{
    private Model spriteModel;
    private View spriteView;
    SpriteMover(Model m, View v)
    {   
        spriteView = v;
        spriteModel = m;
    }
    public void run()
    {
        while (true)
        {

            spriteModel.updateScene(spriteView.getWidth(),spriteView.getHeight());
            spriteView.repaint();

            try{
                Thread.sleep(2);
            }catch(InterruptedException e){}
        }

    }
}
