package com.linor.app.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Singer {
	private int id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private List<Album> albums;
	
	public void addAlbum(Album album) {
		if(albums == null) {
			albums = new ArrayList<>();
		}
		albums.add(album);
	}
}
