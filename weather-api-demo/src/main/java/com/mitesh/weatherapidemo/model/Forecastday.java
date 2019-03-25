package com.mitesh.weatherapidemo.model;

import java.util.Date;

public class Forecastday {

	public Forecastday() {
		
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Long getDate_epoch() {
		return date_epoch;
	}

	public void setDate_epoch(Long date_epoch) {
		this.date_epoch = date_epoch;
	}

	public DayWeather getDay() {
		return day;
	}

	public void setDay(DayWeather day) {
		this.day = day;
	}

	public Astro getAstro() {
		return astro;
	}

	public void setAstro(Astro astro) {
		this.astro = astro;
	}

	private Date date;
	private Long date_epoch;
	private DayWeather day;
	private Astro astro;
	
	
}
