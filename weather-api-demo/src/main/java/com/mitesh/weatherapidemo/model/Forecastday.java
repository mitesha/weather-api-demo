package com.mitesh.weatherapidemo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Forecastday {

	private Date date;

	@JsonProperty(value = "date_epoch")
	private Long dateEpoch;
	private DayWeather day;
	private Astro astro;

	public Date getDate() {
		if(null == date) {
			return null;
		}else {
			return new Date(date.getTime());
		}
	}

	public void setDate(Date date) {
		if (null == date) {
			this.date = null;
		} else {
			this.date = new Date(date.getTime());
		}
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

}
