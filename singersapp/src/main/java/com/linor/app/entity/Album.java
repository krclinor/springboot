package com.linor.app.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Album {
	private int id;
	private int singerId;
	private String title;
	private Date releaseDate;
}
