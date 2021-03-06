package com.mitesh.weatherapidemo.common;

import com.mitesh.weatherapidemo.model.WeatherReportDTO;

public class CustomResponse {
	
	private WeatherReportDTO data;
	private int statusCode; // 0 fail 1 success
	private String status;
	private String err;

	public WeatherReportDTO getData() {
		return data;
	}
	public void setData(WeatherReportDTO data) {
		this.data = data;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	
}
