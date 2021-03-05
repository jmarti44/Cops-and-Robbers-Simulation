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
	
		
		

		
		

	
		//two conditions exist in which the shapes don't overlap
		//1.-> top edge of one above another
		//2.--> left edge of any one rectangle to the left side of the other
		//therefore the coordinates of interest are the following
		/**
		 top right coordinates and bottom left coordinates 
		 according to java coordiante system 

		top-left (x,4)----------------->top-right(x + width,y)
		\													\
		\													\
		bottom-left(x,y+height)------->(bottom-right(x+width),y+height)	
		*/

		//comparsion of cases-return other true other


		//coordinate adjustment
		int sBottomLeftY = s.getY() + 60;
		int sTopRightX = this.getY() + 60;
		int thisTopRightX= this.getX() + 60;
		int thisBottomLeftY = this.getY() + 60;

		
		// top edge condition
		if (thisTopRightX < this.getX() || s.getX() > sTopRightX)
		{
		
			return false;
		}
		//left edge condition
		if (this.getY() > sBottomLeftY || thisBottomLeftY < s.getY())
		{
			
			return false;
		}


		return true;
	
	}
		



		                                                                                                                                        
	
}
