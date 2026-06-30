import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Mole {

	
	private int x;
	private int y;
	private int size;
	private ImageIcon image;
	
	public Mole(int x, int y, int size, String image) {
		
		this.x = x;
		this.y = y;
		this.size = size;

		this.image = new  ImageIcon(image);
		
		
	}
		





public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}

public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}


public ImageIcon getImage() {
	return image;
}
public void setImage(ImageIcon image) {
	this.image = image;
}


public void draw(Graphics k) {
	
	k.drawImage(image.getImage(), x ,  y, size ,size ,null);
	
	
	
	}	
}