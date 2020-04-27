package edu.whut.web.exception;

public class PasswordMatchException extends BaseException {

	/**
	 * password错误时抛出异常
	 */
	private static final long serialVersionUID = -8077530677006565701L;
	
	public PasswordMatchException(){
		super.message = PASSWORD_MATCH_ERROR;
	}
	
	public static final String PASSWORD_MATCH_ERROR = "两次输入的密码不匹配";

	
}
