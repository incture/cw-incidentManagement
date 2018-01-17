package com.incture.im.dto;

public class ResponseDto {
	
	private boolean status;
	private String Message;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}


}
