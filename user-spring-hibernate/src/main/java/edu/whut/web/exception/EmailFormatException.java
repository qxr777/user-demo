package edu.whut.web.exception;

public class EmailFormatException extends BaseException {

	/**
	 *
	 */
	private static final long serialVersionUID = 6934854258189330871L;

	/**
	 * User邮箱格式异常
	 */

	public EmailFormatException(String email){
		super.message = email + EMAIL_FORMAT_ERROR;
	}

	public static final String EMAIL_FORMAT_ERROR = "邮箱格式不规范！";

}
