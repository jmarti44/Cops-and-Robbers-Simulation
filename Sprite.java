import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


class Sprite
{
	private String jpgName;
	private int locationX;
	private int locationY;
	private Image image;

	public Sprite(String jpgName)
	{
		setImage(jpgName);
		locationX = 0;
		locationY = 0;

	}
	
	public  int getX() {	return locationX; }
	public  int getY() {	return locationY; }

	public void setX(int x) { locationX = x; }
	public void setY(int y) { locationY = y; }
	/** 
	public set getnewX() {	location_x =x; }
	public setgety() {location_y =y; }
	public int getnewX() {	return location_x; }
	public int getynewY() {	return location_y; }
	*/

	
	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }	
	
	public void updateImage(Graphics g) 
	{
        // Move the sprite
		//System.out.println("sprite method called");
		/**System.out.println("getX()");
		System.out.println(getX());
		System.out.println("getY()");
		System.out.println(getY());*/




		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
	public void updateState(int width, int height)
	{
		int borderWidth = width;
		int borderHeight = height;
		//System.out.println(borderHeight);
		//System.out.println(borderWidth);
		locationX = getX();
		locationY = getY();
	}
	public boolean overlaps (Sprite s)
	{
	
	

		int width_1 = this.getImage().getWidth(null);
		int height_1 = this.getImage().getHeight(null);

		int width_2 = s.getImage().getWidth(null);
		int height_2= s.getImage().getHeight(null);

		System.out.println(width_1);
		System.out.println(width_2);
		//First condition -top left coordinate
		if ((this.getX() == s.getX()) && (this.getY() == s.getY()))
		{	
			return true;
		}
		//second top right coordinate
		if((this.getX()+ 60 == s.getX()+60)&&(this.getY() == s.getY()))
		{
			return true;
		}
		//bottom right coordinate
		if ((this.getX()+60 == s.getX() + 60) && (this.getY()+60 == s.getY() + 60))
		{
			return true;
		}
		//bottom left coordinate
		if((this.getX()== s.getX())&&(this.getY() + 60 == s.getY() + 60))
		{
			return true;
		}
		return false;
	}
		



		                                                                                                                                        
	
}