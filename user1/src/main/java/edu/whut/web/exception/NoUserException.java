package edu.whut.web.exception;

public class NoUserException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6934854258189330871L;

	/**
	 * User������ʱ�׳��쳣
	 */
	
	public NoUserException(){
		super.message = NO_USER_ERROR;
	}	
	
	public static final String NO_USER_ERROR = "�û���Ϣ��ȡ�쳣��";

}
