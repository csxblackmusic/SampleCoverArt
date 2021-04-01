
public class AlbumInfo 
{
	private String title;
	private String artist;
	private String coverImage;
	
	public AlbumInfo(String title, String artist, String coverImage)
	{
		this.title = title;
		this.artist = artist;
		this.coverImage = coverImage;
		
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getArtist()
	{
		return artist;
	}
	public String getCoverImage()
	{return coverImage;}

}