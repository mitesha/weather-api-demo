package com.mitesh.weatherapidemo.controller;

import java.beans.PropertyEditorSupport;

import com.mitesh.weatherapidemo.common.WeatherReportEnum;


public class WeatherReportEnumConverter extends PropertyEditorSupport {

	@Override
	public void setAsText(final String text) {
        setValue(WeatherReportEnum.getEnumByVal(text));
    }


}
