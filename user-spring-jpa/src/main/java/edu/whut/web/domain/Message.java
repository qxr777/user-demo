package edu.whut.web.domain;

/*
 * 消息
 * */
public class Message {
	
	private boolean success;
	private String msg;
	private String code;
	private Object object;
	
	public Message(){
		this.success=true;
		this.msg="ok";
		this.code="400";
		this.object=null;
	}

	@Override
	public String toString() {
		return "Message [success=" + success + ", msg=" + msg + ", code="
				+ code + ", object=" + object + "]";
	}

	public boolean getSuccess() {
		return success;
	}

	public String getMsg() {
		return msg;
	}

	public String getCode() {
		return code;
	}

//	@JSON(serialize=false)
	public Object getObject() {
		return object;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
