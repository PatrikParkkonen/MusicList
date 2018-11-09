package fi.haagahelia.project.MusicList.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fi.haagahelia.project.MusicList.domain.Genre;

@Entity
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=1, message="Name cannot be null")
	private String name;
	
	@NotNull
	@Size(min=1, message="Name cannot be null")
	private String artist;
	
	@NotNull
	@Size(min=1, message="Name cannot be null")
	private String album;
	
	@NotNull
	@Size(min=1, message="Name cannot be null")
	private String duration;
	
	@Valid
	private int date;
	
	 	@ManyToOne
	 	@JsonIgnore
	    @JoinColumn(name = "genreid")
	    private Genre genre;

	public Song() {}

	public Song(String name, String artist, String album, String duration, int date, Genre genre) {
		super();
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.duration = duration;
		this.date = date;
		this.genre = genre;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		if (this.genre != null)
			return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", album=" + album + ", duration="
					+ duration + ", date=" + date + ", genre = " + this.getGenre() + "]";

		else
			return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", album=" + album + ", duration="
					+ duration + ", date=" + date + "]";
	}

}