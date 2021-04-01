import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FirstWindow extends JFrame
{
	JButton nextAlbumButton;
	JButton shuffleAlbumButton;
	JLabel artistLabel;
	JLabel albumLabel;
	JPanel albumInfoPanel;
	ImagePanel panel;
	JPanel southPanel;
	void go()
	{
		nextAlbumButton = new JButton("Change Album Cover");//saved as member variables so that event handlers can a
		shuffleAlbumButton = new JButton("Pick Random Album");//saved as member variables so that event handlers can a
		nextAlbumButton.setFont(new Font("Calibri",Font.BOLD,12));
		shuffleAlbumButton.setFont(new Font("Calibri",Font.BOLD,12));
		southPanel = new JPanel();//Flow Layout by default - will fit components at preferred height and width if they can fit
		southPanel.add(nextAlbumButton);
		southPanel.add(shuffleAlbumButton);
		panel= new ImagePanel();
		artistLabel = new JLabel("Artist: "+panel.getCurrentAlbum().getArtist());
		albumLabel=new JLabel("Title: "+panel.getCurrentAlbum().getTitle());
		artistLabel.setFont(new Font("Calibri",Font.BOLD,16));
		albumLabel.setFont(new Font("Calibri",Font.BOLD,16));
		albumInfoPanel=new JPanel();
		albumInfoPanel.setLayout(new BoxLayout(albumInfoPanel,BoxLayout.Y_AXIS));
		albumInfoPanel.add(artistLabel);
		albumInfoPanel.add(albumLabel);
		this.setTitle("Album Cover Viewer");
		this.getContentPane().add(BorderLayout.SOUTH,southPanel);
		this.getContentPane().add(BorderLayout.CENTER,panel);
		this.getContentPane().add(BorderLayout.NORTH, albumInfoPanel);
		nextAlbumButton.addActionListener(new NextAlbumListener()); //registers this class so that its action performed method can be called when the button is clicked
		shuffleAlbumButton.addActionListener(new ShuffleListener());		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(440,400);
		this.setVisible(true);
	}
	private class ShuffleListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			for (int i=0; i<(int)(panel.getNumAlbums()*Math.random());i++)
			{
				panel.advanceCoverCount();
			}
			artistLabel.setText("Artist: "+panel.getCurrentAlbum().getArtist());
			albumLabel.setText("Title: "+panel.getCurrentAlbum().getTitle());
			panel.repaint();
		}
	}
	private class NextAlbumListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			panel.advanceCoverCount();
			artistLabel.setText("Artist: "+panel.getCurrentAlbum().getArtist());
			albumLabel.setText("Title: "+panel.getCurrentAlbum().getTitle());
			panel.repaint();
		}
	}
	
	
	
	public static void main(String[] args) 
	{
		FirstWindow win = new FirstWindow();
		win.go();	
		// TODO Auto-generated method stub
	}

}
