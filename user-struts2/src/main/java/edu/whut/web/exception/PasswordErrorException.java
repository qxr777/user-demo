package edu.whut.web.exception;

public class PasswordErrorException extends BaseException {

	/**
	 * password����ʱ�׳��쳣
	 */
	private static final long serialVersionUID = -8077530677006565701L;
	
	public PasswordErrorException(){
		super.message = PASSWORD_ERROR_ERROR;
	}
	
	public static final String PASSWORD_ERROR_ERROR = "�������";

	
}
