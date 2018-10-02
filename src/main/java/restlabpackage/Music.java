package restlabpackage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="musics")
public class Music {
	
	@Id
	@Column(name="musicid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String albumname;
	
	private String artist;
	
	private String releasedate;
	
	private String label;
	
	private double rating;

	private String description;
	
	@ManyToOne
	@JoinColumn(name="genreid")
	private Genre genre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlbumname() {
		return albumname;
	}

	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void copy(Music m) {

		this.setAlbumname(m.getAlbumname());
		this.setArtist(m.getArtist());
		this.setDescription(m.getDescription());
		this.setLabel(m.getLabel());
		this.setRating(m.getRating());
		this.setReleasedate(m.getReleasedate());
	}

	
	

	

}
