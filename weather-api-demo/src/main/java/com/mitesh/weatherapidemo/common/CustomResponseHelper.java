package com.mitesh.weatherapidemo.common;

public class CustomResponseHelper {
	
	private CustomResponseHelper() {
		
	}

	public static CustomResponse getSuccessResponse() {
		CustomResponse customResponse = new CustomResponse();
		customResponse.setStatus(AppConstants.SUCCESS);
		customResponse.setStatusCode(AppConstants.SUCCESS_STATUS_CODE);
		return customResponse;
	}
	
	public static  CustomResponse getErrorResponse() {
		CustomResponse customResponse = new CustomResponse();
		customResponse.setStatus(AppConstants.ERROR);
		customResponse.setStatusCode(AppConstants.ERROR_STATUS_CODE);
		return customResponse;
	}
}
