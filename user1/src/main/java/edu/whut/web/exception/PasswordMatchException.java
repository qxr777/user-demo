package edu.whut.web.exception;

public class PasswordMatchException extends BaseException {

	/**
	 * password����ʱ�׳��쳣
	 */
	private static final long serialVersionUID = -8077530677006565701L;
	
	public PasswordMatchException(){
		super.message = PASSWORD_MATCH_ERROR;
	}
	
	public static final String PASSWORD_MATCH_ERROR = "������������벻ƥ��";

	
}
