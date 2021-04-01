import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;
import java.util.*;

public class ImagePanel extends JPanel
{
	private int coverCount =0;
	private AlbumInfo [] covers = {new AlbumInfo("August Greene","August Greene","C:\\Users\\Dave\\Pictures\\AugustGreene.jpg"),new AlbumInfo("Volume 2","H.E.R","C:\\Users\\Dave\\Pictures\\HER.jpg"),new AlbumInfo("Laila's Wisdom","Rapsody","C:\\Users\\Dave\\Pictures\\rapsody.jpg")};
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(0,0,0));//values passed for red green and bule color components
		g.fillRect(0, 0, getWidth(), getHeight());
		Image cover = new ImageIcon(covers[coverCount].getCoverImage(),"cover").getImage(); 
		g.drawImage(cover,0,0,this);
	}
	public void advanceCoverCount()
	{
		coverCount++;
		if(coverCount>covers.length-1)
			coverCount=0;
	}
	public AlbumInfo getCurrentAlbum()
	{
		return covers[coverCount];
	}
	
	public int getNumAlbums()
	{
		return covers.length;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
