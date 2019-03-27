package com.mitesh.weatherapidemo.common;

public enum WeatherReportEnum {
	
	TODAY("today", 1), FORECAST("forecast", 5);
	
	private String val;
	
	private int days;
	
	WeatherReportEnum() {
	}
	
	WeatherReportEnum(String val, int days) {
		this.val = val;
		this.days = days;
	}

	public String getVal() {
		return val;
	}
	
	// fetch
	public static WeatherReportEnum getEnumByVal(String val) {
		for(WeatherReportEnum reportEnum : WeatherReportEnum.values()) {
			if (reportEnum.getVal().equalsIgnoreCase(val)) {
				return reportEnum;
			}
		}
		return null; // not found
	}

	public int getDays() {
		return days;
	}

}
